package com.czw.Action;

import com.czw.Service.RoleService;
import com.czw.entity.Admin;
import com.czw.entity.Role;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
@Scope("prototype")
@Controller("RoleAction")
public class RoleAction extends BaseAction implements ModelDriven<Role> {

    private static final long serialVerisonUID = 1L;

    @Resource
    private RoleService roleService;
    private Role role = new Role();


    /*
    * @brief 查询所有用户类型
    * @return
    * */
    public String roleListUI() {
        List<Role> roleList = roleService.getAllRoles();
        session.setAttribute("roleList",roleList);

        return "roleListUI";
    }


    /*
    * @brief 删除用户类型
    * @return
    * */
    public String roleDelete() {
        roleService.roleDelete(role.getRoleID());
        return "toRoleList";
    }

    /*
    * @brief 添加用户类型
    * @return
    * */
    public String roleAdd() {
        roleService.roleAdd(role);
        return "toRoleList";
    }

    public String roleAddUI() {
        return "roleAddUI";
    }

    @Override
    public Role getModel(){
        return role;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
