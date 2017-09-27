package cn.tedu.action;

import com.opensymphony.xwork2.ActionSupport;

import ssh.day02.JsonResult;

public abstract class AbstractAction 
	extends ActionSupport{
	
	public static final String JSON="json";
	
	protected JsonResult jsonResult;
	
	public JsonResult getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}
}
