package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public interface UserService extends BaseDao<User> {

    List<User> userFindAll();

    List<User> getUserByName(String userName);

    User user_login(String userName,String userPassword);

    User userAdd(User user);

    User userDeleteById(long userID);

    User updateUserInfo(User user);

}
