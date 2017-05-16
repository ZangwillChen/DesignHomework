package com.czw.Action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chenzhaowen on 2017/5/16.
 * @brief 基础Action类
 */
abstract class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {

    private static final long serialVersionUID = 1L;

    protected HttpServletRequest request; //请求对象
    protected HttpServletResponse response; //响应对象
    protected HttpSession session; //回话对象
    protected ServletContext application; //全局对象

    @Override
    public void setServletContext(ServletContext application){
        this.application = application;
    }

    @Override
    public void setServletResponse(HttpServletResponse response){
        this.request = request;
    }

    @Override
    public void setServletRequest(HttpServletRequest request){
        this.request = request;
        this.session = request.getSession();
    }


}
