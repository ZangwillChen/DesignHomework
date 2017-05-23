package com.czw.Service;

import com.czw.entity.Admin;
import com.czw.Dao.BaseDao;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 * @ 管理员业务逻辑接口
 */
public interface AdminService extends BaseDao<Admin> {

    /*
    * @brief 管理员登陆逻辑接口
    * @param adminName
    * @param adminPassword
    * @return
    * */

    Admin admin_login(String adminName, String adminPassword);

    /*
    * @brief 查询所有
    * @return
    * */

    List<Admin> admin_findAll();

    /*
    * @brief 按ID删除
    * @param adminID
    * */

    void admin_delete(long adminID);

    /*
    * @brief 添加管理员
    * @param admin
    * */

    void admin_add(Admin admin);

    /*
    * @brief 按ID获取
    * @param adminID
    * @return
    * */

    Admin admin_edit_getById(long adminID);

    /*
    * @brief 更新实体
    * @param a
    * @return
    * */

    Admin admin_edit_update(Admin a);
}
