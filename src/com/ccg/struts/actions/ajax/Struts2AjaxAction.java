package com.ccg.struts.actions.ajax;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.ccg.struts.actions.BaseAction;

//@ParentPackage("ajax")
//@Namespace("/test")
public class Struts2AjaxAction extends BaseAction
{
    /**
     * struts2-ajax 用例
     */
    private static final long serialVersionUID = -4227395311084215139L;
    
    @Action(value = "gotoStruts2JsonPlugin", results = { 
    @Result(name = "success", location = "/pages/ajax/struts2JsonPlugin.jsp")})
    public String gotoStruts2JsonPlugin()
    {
        return SUCCESS;
    }
    
    @Action(value = "gotoStruts2Ajax_post", results = { 
    @Result(name = "success", location = "/pages/ajax/struts2Ajax_post.jsp")})
    public String struts2Ajax_post()
    {
        return SUCCESS;
    }

    @Action(value = "gotoStruts2Ajax_ajax", results = { 
    @Result(name = "success", location = "/pages/ajax/struts2Ajax_ajax.jsp")})
    public String struts2Ajax_ajax()
    {
        return SUCCESS;
    }
    
    @Action(value = "post")
    public String post()
    {
        String f1 = StringUtils.defaultString(getRequest().getParameter("field1"));
        String f2 = StringUtils.defaultString(getRequest().getParameter("field2"));
        ajaxText(f1+"，测试，"+f2);
        return null;
    }
    
    @Action(value = "ajax")
    public String ajax() throws UnsupportedEncodingException
    {
        String f1 = StringUtils.defaultString(getRequest().getParameter("field1"));
        String f2 = StringUtils.defaultString(getRequest().getParameter("field2"));

        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(f1, f1);
        jsonMap.put(f2, f2);
        jsonMap.put("status", SUCCESS);
        super.ajaxJson(jsonMap);
        return null;
    }
}