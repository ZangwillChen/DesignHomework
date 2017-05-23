package com.czw.Dao;

import com.czw.entity.Role;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
public interface UserDao extends BaseDao<User> {
    User getUserByNameAndPwd(String userName,String userPassword);
    List<User> getByType(Role userType);    //待检验
}
