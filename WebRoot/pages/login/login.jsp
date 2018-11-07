<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path ;
    session.setAttribute("basePath", basePath);
            
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>struts2</title>
</head>
<body>
	<form action="/struts/upload" method="post">
		<input type="text" name="userName" id="userName" placeholder="请输入用户名" value="${user.userName }"/><br/>
		<input type="password" name="password" id="password" placeholder="password" value="${user.password }"/><br/>
		<input type="submit" id="login" value="登陆" />
		<a href="${basePath }/pages/user/addUser.jsp">注册</a>
	</form>
	<hr/>
	
	
	<h4>jsp九大内置对象，可以在jsp页面直接使用</h4>
	四个作用域对象（从小到大）：pageContext,request,session,application<br/>
	其他：response,exception,config,out,page
	<% session.setAttribute("userMsg", "sessionMsg");%>
	<hr/>
	<h4>s标签库，查看jsp页面里的变量值：</h4>
	action方法的属性username：<s:property value="username" /> <br/>
	session中的属性userMsg,<br/>
	1、jsp表达式：<%=session.getAttribute("userMsg") %><br/>
	2、el表达式：${userMsg }<br/>
	3、s标签表达式：<s:property value="#session.userMsg" /><br/>
	${basePath }<br/>
	<%=basePath %>
	
	
	<hr/>
	
	<s:debug></s:debug>
</body>
</html>
