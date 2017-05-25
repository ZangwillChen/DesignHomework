package com.czw.Action;

import com.czw.Service.AdminService;
import com.czw.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by chenzhaowen on 2017/5/16.
 */
@Scope("prototype")
@Controller
public class AdminAction extends BaseAction implements ModelDriven<Admin> {


    private static final long serialVersionUID = 1L;

    private Admin admin = new Admin();

    /**
     * @brief 业务逻辑对象
     */

    @Resource
    private AdminService adminService;

    /**
     * @brief 管理员登录界面
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public String logon() throws Exception{
        System.out.println("(管理员登录)用户名密码和ID:"+admin.getAdminName()+admin.getAdminPassword()+admin.getAdminID());
        Admin loginAdmin = adminService.admin_login(admin.getAdminName(),admin.getAdminPassword());
        if (loginAdmin != null){
            session.putValue("adminName",loginAdmin.getAdminName());
            session.setAttribute("loginAdmin",loginAdmin);
        } else {
            return "adminLoginUI";  // 返回后台登录页面
        }
        return "toIndex";

    }

    /**
     * @brief 管理员退出
     * @return
     * @throws Exception
     */
    public String logout() throws Exception{
        ActionContext.getContext().getSession().remove("admin");
        return "adminLoginUI";
    }

    /**
     * @brief 管理员个人信息
     * @return
     * @throws Exception
     */
    public String adminInfo() throws Exception {
        return "toAdminInfoUI";
    }

    /**
     * @brief 管理员用户列表
     * @return
     * @throws Exception
     */



}
