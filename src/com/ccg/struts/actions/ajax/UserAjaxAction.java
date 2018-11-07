package com.ccg.struts.actions.ajax;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

public class UserAjaxAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 1L;
	
	@Getter@Setter
	private String ajaxData;
	private HttpServletRequest request;

	/**
	 * 实现ServletRequestAware接口的目的，是为了获取HttpServletRequest对象，从而在action里获取请求参数
	 */
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public String execute() throws Exception {
		
		return super.execute();
	}
	
	public String addUser(){
		return SUCCESS;
	}
	public String checkUser(){
		this.ajaxData = "check的对象是：" + request.getParameter("userName");
		return SUCCESS;
	}
	
}
