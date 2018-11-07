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
<title>ʹ��$.ajax�ύAjax����</title>
<s:property value="cxtpath"/>
<script src="${cxtpath}/js/common/jquery-1.9.1.js" type="text/javascript"></script>
<script type="text/javascript">
function ajax()
{
    // ��form1����װ�����������������
    var val1 = $("#form1_field1").val();
    var val2 = $("#form1_field2").val();
    $.ajax({
        url: '${cxtpath}/test/ajax.action', 
        data: {"field1": val1,"field2": val2},
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
<div>ʹ��$.ajax�ύAjax����
<s:form id="form1" method="post">
    field1��<s:textfield name="field1" label="field1"/><br/>
    field2��<s:textfield name="field2" label="field2"/><br/>
    field3��<s:textfield name="field3" label="field3"/><br/>
    <tr>
        <td colspan="2">
        <input type="button" value="�ύ" onClick="ajax();"/></td>
    </tr>
</s:form>
</div>
</body>
</html>