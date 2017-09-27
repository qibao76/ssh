package ssh.day01;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 下载图片到浏览器 
 */
public class ImageAction {
	private InputStream img;
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	
	public String execute() throws IOException{
		byte[] png = createPng();
		//将byte数组作为流读取
		img=new ByteArrayInputStream(png);
		return "success";
	}
	
	private byte[] createPng() 
				throws IOException{
		BufferedImage img = 
			new BufferedImage(200,100,
			BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(100, 50, 0xffff00);
		Graphics2D g = img.createGraphics();
		g.setColor(new Color(0xff0000)); 
		g.drawLine(0, 0, 200, 100);
		ByteArrayOutputStream out =
			new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] data = out.toByteArray();
		return data;
	}
}










