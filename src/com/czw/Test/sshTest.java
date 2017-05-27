package com.czw.Test;

import com.czw.Action.TestAction;
import com.czw.Service.TestService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by chenzhaowen on 2017/5/27.
 */
public class sshTest {

    private ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext-common.xml");

    @Test
    public void testBean() throws Exception {
        TestAction testAction = (TestAction) ac.getBean("testAction");
        System.out.println(testAction);
    }


    @Test
    public void testSessionFactory() throws Exception {
        SessionFactory sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
        System.out.println(sessionFactory);
    }

    @Test
    public void testTransaction() throws Exception {
        TestService testService = (TestService) ac.getBean("testService");
        testService.saveTwoUsers();
    }
}
