package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoleService;
import com.czw.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
@Service
@Transactional
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

    public Role getRoleByName(String roleName) {
        Role role=null;
        Session session = getSession();
        Query query = session.createQuery("FROM Role role WHERE role.roleName=?");
        query.setParameter(0,roleName);
        role = (Role) query.uniqueResult();
        return role;
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
