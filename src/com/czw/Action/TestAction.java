package com.czw.Action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by chenzhaowen on 2017/5/27.
 */
//@Scope("prototype")
//@Controller("TestAction")
public class TestAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        System.out.println("testAction.execute()");
        return "success";
    }
}
