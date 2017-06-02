package com.czw.Action;

import com.czw.Service.RoleService;
import com.czw.Service.RoomService;
import com.czw.Service.UserService;
import com.czw.entity.Admin;
import com.czw.entity.Role;
import com.czw.entity.Room;
import com.czw.entity.User;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Iterator;
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
    private RoomService roomService;
    private UserService userService;
    private Role role = new Role();
    private User user;
    private Room room;


    /*
    * @brief 查询所有用户类型
    * @return
    * */
    public String roleListUI() throws Exception {
        List<Role> roleList = roleService.getAllRoles();
        Iterator<Role> itr = roleList.iterator();
        while (itr.hasNext()){
            Role str = itr.next();
            System.out.println(str.getRoleID());
            System.out.println(str.getRoleName());
            System.out.println(str.getPermission());
        }

        if (roleList != null && roleList.size() >0){
            session.setAttribute("roleList",roleList);
        }

        return "roleListUI";
    }


    public String roleEditUI() {
        return "roleEditUI";
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

    /*
   * @brief 检查用户类型是否有权预订该房间
   * @return
   * */
    public String roleCheck() {
        String userName = request.getParameter("userName");
        String roomName = request.getParameter("roomName");

        Room room = roomService.getRoomByName(roomName);
        User user = userService.getUserByName(userName);

        if (user.getUserType().getPermission()>room.getRoomtype()){
            return "toReserveUI";
        }
        else return "ERROR";
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
