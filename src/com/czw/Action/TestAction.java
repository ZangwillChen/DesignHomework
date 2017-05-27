package com.czw.Action;

import com.czw.Service.TestService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by chenzhaowen on 2017/5/27.
 */
//@Scope("prototype")
//@Controller("TestAction")
public class TestAction extends ActionSupport {

    @Resource
    TestService testService;

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        testService.saveTwoUsers();
        System.out.println("testAction.execute()");
        return "success";
    }
}
