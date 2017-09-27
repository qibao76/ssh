package ssh.day02;

/**
 * 将控制器中jsonResult属性发送到客户端 
 */
public class JsonResultAction {
	private JsonResult jsonResult;
	
	public JsonResult getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	public String execute(){
		String[] names = {"熊大", "熊二"};
		jsonResult = new JsonResult(names);
		return "success";
	}
}




