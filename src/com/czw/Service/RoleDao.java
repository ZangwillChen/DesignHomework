package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.Role;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public interface RoleDao extends BaseDao<Role> {

    List<Role> getAllRoles();


    Role roleEdit(Role role);

    Role roleAdd(Role role);

    Role roleDelete(long roleID);
}
