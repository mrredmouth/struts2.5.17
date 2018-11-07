package com.ccg.struts.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截器，在访问action之前
 * @author Administrator
 *
 */
public class MyLoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//上下文对象
		ActionContext invocationContext = invocation.getInvocationContext();
		//session对象
		Map<String, Object> session = invocationContext.getSession();
		System.out.println("MyLoginInterceptor.intercept()---放行之前");
		session.get("userMsg");
		//放行，访问action
		String result = invocation.invoke();
		System.out.println(result+"--MyLoginInterceptor.intercept()---放行之后");
		return result;
	}

}
