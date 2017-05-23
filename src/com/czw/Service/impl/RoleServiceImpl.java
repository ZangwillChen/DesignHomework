package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoleService;
import com.czw.entity.Role;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public class RoleServiceImpl extends BaseDaoImpl<Role> implements RoleService {


    /*
    * @brief 获取所有用户类型逻辑接口实现
    * @return
    * */
    @Override
    public List<Role> getAllRoles(){
        List<Role> ListRole = findall();
        return ListRole;
    }

    /*
    * @brief 修改角色逻辑接口实现
    * @param role
    * @return
    * */
    @Override
    public Role role_edit_getById(long roleID){
        Role editRole = getById(roleID);

        if (editRole != null){
            return editRole;
        }
        return null;
    }

    @Override
    public void role_edit_update(Role r){
        update(r);
    }

    /*
    * @brief 添加角色逻辑接口实现
    * @param role
    * @return
    * */
    @Override
    public void roleAdd(Role role){
        save(role);
    }
    /*
    * @brief 删除角色逻辑接口实现
    * @param roleID
    * @return
    * */
    @Override
    public void roleDelete(long roleID){
        delete(roleID);
    }
}
