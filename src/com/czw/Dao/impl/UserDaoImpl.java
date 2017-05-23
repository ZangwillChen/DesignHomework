package com.czw.Dao.impl;

import com.czw.Dao.UserDao;
import com.czw.entity.Role;
import com.czw.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User getUserByNameAndPwd(String userName,String userPassword){

        User user = null;
        Session session = getSession();
        Query query = session.createQuery("FROM User user WHERE user.userName=? AND user.userPassword=?");
        query.setParameter(0,userName);
        query.setParameter(1,userPassword);
        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public List<User> getByType(Role userType){

        List<User> userList;
        Session session = getSession();
        Query query = session.createQuery("FROM User user WHERE user.userType.roleName=?");
        query.setParameter(0,userType);
        userList = (List<User>) query.list();
        return userList;

    }
}
