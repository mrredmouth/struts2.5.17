<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
request.setAttribute("cxtpath",request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta name="author" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>使用$.post提交Ajax请求</title>
<s:property value="cxtpath"/>
<script src="${cxtpath}/js/common/jquery-1.8.3.js" type="text/javascript"></script>
<script type="text/javascript">
function post()
{
    // 以form1表单封装的请求参数发送请求。
    $.post('${cxtpath}/test/post.action', 
    		$("#form1").serializeArray(),
        // data代表服务器响应，此处只是把服务器响应显示出来
        function(data) {
            console.log("data:"+JSON.stringify(data));
        }
    )
}
</script>
</head>
<body>
<div>使用$.post提交Ajax请求
<s:form id="form1" method="post">
    field1：<s:textfield name="field1" label="field1"/><br/>
    field2：<s:textfield name="field2" label="field2"/><br/>
    field3：<s:textfield name="field3" label="field3"/><br/>
    <tr>
        <td colspan="2">
        <input type="button" value="提交" onClick="post();"/></td>
    </tr>
</s:form>
</div>
</body>
</html>