package com.czw.Action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletRequest;

/**
 * Created by chenzhaowen on 2017/5/16.
 * @brief 基础Action类
 */
public class BaseAction extends ActionSupport implements ServletRequest,ServletResponseAware,ServletContextAware {


}
