<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path ;
    session.setAttribute("ctxpath", basePath);
            
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
	<title>addUser</title>
	<script src="${ctxpath}/js/common/jquery-3.3.1.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function(){
		$("#userName").blur(function(){
			$.get(
				"${ctxpath}/testajax/checkUser.action", 
				{ userName: $("#userName").val()},
			    function(data){
					alert("Data Loaded: " + data);
				});
		});
	});
	function ajax(){
	    $.ajax({
	        url: '${ctxpath}/testajax/checkUser.action', 
	        data: {"userName": $("#userName").val()},
	        dataType: "json",
	        async: false,
	        type: "POST",
	        success: function(data) {
	            console.log("data:"+JSON.stringify(data));
	            if (data.status == "success") {
	                console.log("succ");
	            }else{
	                data;
	                console.log("fail");
	            }
	        }
	    });
	}
	</script>
</head>
<body>
	<form action="/struts/upload" method="post">
		<input type="text" name="userName" id="userName" placeholder="请输入用户名" value="${user.userName }"/><br/>
		<input type="password" name="password" id="password" placeholder="password" value="${user.password }"/><br/>
		<input type="submit" id="regist" value="注册" />
	</form>
	<hr/>
	
	<s:debug></s:debug>
</body>
</html>
