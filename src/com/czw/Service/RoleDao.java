package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.Role;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
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

    Role roleAdd(Role role);

    Role roleDelete(long roleID);
}
