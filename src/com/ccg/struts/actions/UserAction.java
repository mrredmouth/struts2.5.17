package com.ccg.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	public String execute(){
		System.out.println("action的name：userlist");
		return SUCCESS;
	}
	
	public String add(){
		System.out.println("action的name：user_add");
		return SUCCESS;
	}
	public String delete(){
		System.out.println("action的name：user_delete");
		return SUCCESS;
	}
	public String detail(){
		System.out.println("action的name：user_detail");
		return SUCCESS;
	}
}
