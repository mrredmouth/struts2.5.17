package com.ccg.struts.actions;

import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;


public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 有GS的属性，放在action的值栈的Value Stack Contents里，页面可以直接拿到
	 * 	值栈： 1、Value Stack Contents
	 * 			里面的数据在jsp访问：<s:property value="username">
	 * 		  2、Stack Context
	 * 			里面的数据在jsp访问：<s:property value="#session.userMsg" />
	 */
	@Getter@Setter
	private String username;
	
	{
		
	}
	
	@Override
	public String execute(){
		System.out.println("struts2的execute方式：LoginAction.excute()");
		return SUCCESS;
	}
	public String login(){
		username = "jakky";
		System.out.println("struts2的method方式：LoginAction.login()");
		return SUCCESS;
	}
	public String input(){
		System.out.println("LoginAction.input()");
		return INPUT;
	}
}
