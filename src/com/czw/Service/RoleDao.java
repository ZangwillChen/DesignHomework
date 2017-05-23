package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.Role;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 * @brief 角色业务逻辑接口
 */
public interface RoleDao extends BaseDao<Role> {


    /*
    * @brief 获取所有用户类型逻辑接口
    * @return
    * */
    List<Role> getAllRoles();

    /*
    * @brief 修改角色逻辑接口
    * @param role
    * @return
    * */
    Role roleEdit(Role role);

    /*
    * @brief 添加角色逻辑接口
    * @param role
    * @return
    * */
    Role roleAdd(Role role);
    /*
    * @brief 删除角色逻辑接口
    * @param roleID
    * @return
    * */
    Role roleDelete(long roleID);
}
