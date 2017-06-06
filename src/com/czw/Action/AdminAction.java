package com.czw.Action;

        import java.util.Iterator;
        import java.util.List;

        import javax.annotation.Resource;
        import org.springframework.context.annotation.Scope;
        import org.springframework.stereotype.Controller;

        import com.czw.entity.Admin;
        import com.czw.Service.AdminService;
        import com.opensymphony.xwork2.ActionContext;
        import com.opensymphony.xwork2.ModelDriven;
        import org.apache.log4j.Logger;

/**
 * Created by chenzhaowen on 2017/5/16.
 */
@Scope("prototype")
@Controller("AdminAction")
public class AdminAction extends BaseAction implements ModelDriven<Admin> {


    private static final long serialVersionUID = 1L;

    private Admin admin = new Admin();

    private static Logger logger = Logger.getLogger(Admin.class);
    /**
     * @brief 业务逻辑对象
     */
    @Resource
    private AdminService adminService;

    public String logonUI() throws Exception{
        return "adminLoginUI";
    }

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
            logger.info("管理员"+loginAdmin.getAdminName()+"登陆");

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
        logger.info("查看管理员列表");
        return "adminListUI";
    }

    /**
     * @brief 管理员用户删除
     * @return
     * @throws Exception
     */
    public String adminDelete() throws Exception {
        logger.info("删除管理员"+admin.getAdminID());
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
        logger.info("添加管理员"+admin.getAdminID());
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
  /* public String adminEdit() throws Exception {
       // Admin loginAdmin = (Admin) session.getAttribute("loginAdmin") ;
        System.out.println("(管理员修改信息)管理员ID"+admin.getAdminID());
        Admin editAdmin = adminService.admin_edit_getById(admin.getAdminID());
        Admin loginAdmin;
        if (editAdmin != null){
            //System.out.println("编辑之前：");
            editAdmin.setAdminName(admin.getAdminName());
            editAdmin.setAdminPassword(admin.getAdminPassword());
            editAdmin.setAdminPhone(admin.getAdminPhone());
            editAdmin.setAdminEmail(admin.getAdminEmail());

            adminService.admin_edit_update(editAdmin);

            loginAdmin = editAdmin;
            session.putValue("adminName",loginAdmin.getAdminName());
            session.setAttribute("loginAdmin",loginAdmin);

            System.out.println("编译之后:"+editAdmin.getAdminPassword());
            return "toAdminInfoUI";

        }
        return "toAdminInfoUI";
    }*/

  public String adminEdit() {
      if (adminService.getById(admin.getAdminID()) != null){
          setAdmin(admin);
          adminService.update(admin);
          return "toAdminInfoUI";
      }
        return "toAdminInfoUI";
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

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
