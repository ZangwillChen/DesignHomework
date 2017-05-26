package com.czw.Action;

import com.czw.Service.UserService;
import com.czw.entity.User;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
@Scope("prototype")
@Controller("UserAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

    private static final long serialVersionUID = 1L;

    @Resource
    private UserService userService;

    private User user = new User();

    /**
     * @brief 用户登录
     * @return
     */
    public String userLogin(){
        System.out.println("(用户登录)用户名"+user.getUserName()+"用户密码"+user.getUserPassword());
        User ulogin = userService.user_login(user.getUserName(),user.getUserPassword());

        if (ulogin != null){
            session.setAttribute("userName",ulogin.getUserName());
            session.setAttribute("ulogin",ulogin);
            return "userLogin";
        }
        return "toUserLogin";
    }

    /**
     * @brief 用户个人信息页面
     * @return
     */
    public String userInfoUI() {
        return "userInfoUI";
    }

    /**
     * @brief 用户信息修改界面
     * @return
     */
    public String userEditUI(){
        return "userEditUI";
    }
    /**
     * @brief 用户信息修改
     * @return
     */
    public String userEdit() {
        User userUpdateInfo;
        System.out.println("(用户信息修改)用户ID"+user.getUserID());

    }



    @Override
    public User getModel(){
        return user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
