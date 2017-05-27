package com.czw.Service;

import com.czw.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chenzhaowen on 2017/5/27.
 */
@Service
public class TestService {

    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void saveTwoUsers() {
        Session session = sessionFactory.getCurrentSession();
        session.save(new User());

        session.save(new User());
    }
}
