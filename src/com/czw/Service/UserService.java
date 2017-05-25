package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 * @brief 用户业务逻辑实体类
 */
public interface UserService extends BaseDao<User> {

    /*
    * @brief 获取所有用户逻辑接口
    * @return
    * */
    List<User> userFindAll();

    /*
    * @brief 根据姓名获取用户信息逻辑接口
    * @param userName
    * @return
    * */
    User getUserByName(String userName);

    /*
    * @brief 用户登录逻辑接口
    * @param userName
    * @param userPassword
    * @return
    * */
    User user_login(String userName,String userPassword);

    /*
    * @brief 添加用户逻辑接口
    * @param user
    * @return
    * */
    void userAdd(User user);

    /*
    * @brief 根据ID删除用户逻辑接口
    * @param userID
    * @return
    * */
    void userDeleteById(long userID);

    /*
    * @brief 更新用户信息逻辑接口
    * @param user
    * @return
    * */
    User user_edit_getById(long userID);

    void user_edit_update(User user);

}
