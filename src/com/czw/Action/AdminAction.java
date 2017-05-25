package com.czw.Action;

import com.czw.Service.AdminService;
import com.czw.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

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

    public String adminListUI() throws Exception {
        List<Admin> adminList = adminService.admin_findAll();
        Iterator<Admin> itr = adminList.iterator();
        while (itr.hasNext()){
            Admin str = itr.next();
            System.out.println(str.getAdminName());
            System.out.println(str.getAdminID());
            System.out.println(str.getAdminEmail());
            System.out.println(str.getAdminPhone());
        }

        if (adminList != null && adminList.size() >0){
            session.setAttribute("adminList",adminList);
        }

        return "adminListUI";
    }

    /**
     * @brief 管理员用户删除
     * @return
     * @throws Exception
     */
    public String adminDelete() throws Exception {
        adminService.admin_delete(admin.getAdminID());
        return "adminListUI";
    }

    /**
     * @brief 管理员用户添加
     * @return
     * @throws Exception
     */
    public String adminAdd() throws Exception {
        adminService.admin_add(admin);
        return "toAdminListUI";
    }

    /**
     * @brief 管理员用户添加UI
     * @return
     * @throws Exception
     */
    public String adminAddUI() throws Exception {
        return "adminAddUI";
    }

    /**
     * @brief 管理员用户修改
     * @return
     * @throws Exception
     */

    @SuppressWarnings("deprecation")
    public String adminEdit() throws Exception {
        System.out.println("(管理员修改信息)管理员ID"+admin.getAdminID());
        Admin editAdmin = adminService.admin_edit_getById(admin.getAdminID());
        Admin loginAdmin;
        if (editAdmin != null){
            System.out.println("编辑之前：");
            editAdmin.setAdminName(admin.getAdminPhone());
            editAdmin.setAdminPassword(admin.getAdminPassword());
            editAdmin.setAdminPhone(admin.getAdminPhone());
            editAdmin.setAdminEmail(admin.getAdminEmail());

            adminService.admin_edit_update(editAdmin);

            loginAdmin = editAdmin;
            session.putValue("adminName",loginAdmin.getAdminName());
            session.setAttribute("logAdmin",loginAdmin);

            System.out.println("编译之后:"+editAdmin.getAdminPhone());
            return "toAdminInfoUI";

        }
        return "ERROR";
    }

    /**
     * @brief 管理员用户修改UI
     * @return
     * @throws Exception
     */
    public String adminEditUI() throws Exception {
        return "adminEditUI";
    }

    @Override
    public Admin getModel() {
        // TODO Auto-generated method stub
        return admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


}
