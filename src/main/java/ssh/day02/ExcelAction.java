package ssh.day02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 动态下载Excel文件 
 *
 */
public class ExcelAction {
	
	private InputStream out;
	
	public InputStream getOut() {
		return out;
	}
	public void setOut(InputStream out) {
		this.out = out;
	}
	
	public String execute() throws IOException{
		byte[] excel = createExcel();
		out =new  ByteArrayInputStream(excel);
		return "success";
	}

	private byte[] createExcel() throws IOException {
		//创建工作表(Excel 文件)
		HSSFWorkbook workbook = 
				new HSSFWorkbook();
		//创建 工作表
		HSSFSheet sheet =
			workbook.createSheet("Hello");
		//在工作表中添加一行数据
		HSSFRow head=sheet.createRow(0);
		//在表头里面插入3个格子
		HSSFCell c1=head.createCell(0);
		HSSFCell c2=head.createCell(1);
		HSSFCell c3=head.createCell(2);
		c1.setCellValue("编号");
		c2.setCellValue("姓名");
		c3.setCellValue("年龄");
		//插入数据
		HSSFRow row=sheet.createRow(1);
		c1=row.createCell(0);
		c2=row.createCell(1);
		c3=row.createCell(2);
		c1.setCellValue(1);
		c2.setCellValue("Tom");
		c3.setCellValue(5);
		//将工作簿写到文件中
		ByteArrayOutputStream out=
			new ByteArrayOutputStream();
		workbook.write(out);
		workbook.close();
		out.close();
		return out.toByteArray();
	}
}




