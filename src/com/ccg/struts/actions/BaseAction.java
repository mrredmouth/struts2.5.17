package com.ccg.struts.actions;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

    private static final long serialVersionUID = 4271951142973483943L;

    protected Logger logger = Logger.getLogger(getClass());

    // 获取Attribute
    public Object getAttribute(String name) {
        return ServletActionContext.getRequest().getAttribute(name);
    }

    // 设置Attribute
    public void setAttribute(String name, Object value) {
        ServletActionContext.getRequest().setAttribute(name, value);
    }

    // 获取Parameter
    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    // 获取Parameter数组
    public String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
    }

    // 获取Request
    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    // 获取Response
    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    // 获取Application
    public ServletContext getApplication() {
        return ServletActionContext.getServletContext();
    }

    // AJAX输出，返回null
    public String ajax(String content, String type) {
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType(type + ";charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // AJAX输出文本，返回null
    public String ajaxText(String text) {
        return ajax(text, "text/plain");
    }

    // AJAX输出HTML，返回null
    public String ajaxHtml(String html) {
        return ajax(html, "text/html");
    }

    // AJAX输出XML，返回null
    public String ajaxXml(String xml) {
        return ajax(xml, "text/xml");
    }

    // 根据字符串输出JSON，返回null
    public String ajaxJson(String jsonString) {
        return ajax(jsonString, "application/json");
    }
    
    // 根据Map输出JSON，返回null
    public String ajaxJson(Map<String, String> jsonMap) {
        return ajax(mapToJson(jsonMap), "application/json");
    }
    
    // 输出JSON成功消息，返回null
    public String ajaxJsonSuccessMessage(String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put("status", SUCCESS);
        jsonMap.put("message", message);
        return ajax(mapToJson(jsonMap), "application/json");
    }
    
    // 输出JSON错误消息，返回null
    public String ajaxJsonErrorMessage(String message) {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put("status", ERROR);
        jsonMap.put("message", message);
        return ajax(mapToJson(jsonMap), "application/json");
    }
    // map转化为json数据
    public String mapToJson(Map<String,String> map){
        ObjectMapper mapper = new ObjectMapper();
        Writer sw = new StringWriter();
        try {
            JsonGenerator json = mapper.getFactory().createGenerator(sw);
            json.writeObject(map);
            sw.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
