package com.czw.Action;

import com.czw.Service.UserService;
import com.czw.entity.ReserveInfo;
import com.czw.entity.ReserveInfoSearch;
import com.czw.entity.User;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
    @SuppressWarnings("deprecation")
    public String logon() throws Exception{
        System.out.println("(管理员登录)用户名密码和ID:"+user.getUserName()+user.getUserPassword()+user.getUserID());
        User ulogin = userService.user_login(user.getUserName(),user.getUserPassword());
        if (ulogin != null){
            session.putValue("userName",ulogin.getUserName());
            session.setAttribute("ulogin",ulogin);
        } else {
            return "toUserLogin";  // 返回后台登录页面
        }
        return "userLogin";

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
        User editUser = userService.user_edit_getById(user.getUserID());

        if (editUser != null){
            editUser.setUserName(user.getUserName());
            editUser.setUserPassword(user.getUserPassword());
            editUser.setUserPhone(user.getUserPhone());
            editUser.setUserEmail(user.getUserEmail());

            userService.user_edit_update(editUser);
            userUpdateInfo = editUser;
            session.setAttribute("ulogin",userUpdateInfo);
            return "toUserInfoUI";
        }
        return "ERROR";
    }

    /**
     * @brief 教室预约页面
     * @return
     */
    public String userReserveRoomUI() {
        return "userReserveRoomUI";
    }
    /**
     * @brief 房间可预约列表
     * @return
     */
    public String userReserveSearch() {
        String roomName = request.getParameter("roomName");
        String courseTime = request.getParameter("courseTime");
        String roomTime = request.getParameter("roomTime");

        User user = (User) session.getAttribute("ulogin");
        int userTypeNum = user.getUserType().getPermission();
        long userID = user.getUserID();
        String week = "";
        System.out.println("(预约查询)查询信息"+roomName+courseTime+roomTime+userID);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 字符串格式转化为日期格式并获取星期数
        try {
            Date new_time = df.parse(roomTime);
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            week = sdf.format(new_time);
            System.out.println("星期数"+week);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        // 初始化查询条件
        ReserveInfoSearch reserveInfoSearch = new ReserveInfoSearch(roomName,courseTime,roomTime,week);
        // 执行查询并返回结果
        ReserveInfo reserveInfo = userService.getReserveInfoList(reserveInfoSearch);
        session.setAttribute("reserveInfo",reserveInfo);
        return "userReserveRoomList";
    }

    /**
     * @brief 用户列表显示
     * @return
     */
    public String userListUI() throws Exception {
        List<User> userList = userService.userFindAll();
        Iterator<User> itr = userList.iterator();
        while (itr.hasNext()){
            User str = itr.next();
            System.out.println(str.getUserName());
            System.out.println(str.getUserID());
            System.out.println(str.getUserPhone());
            System.out.println(str.getUserEmail());
        }

        if (userList != null && userList.size() >0){
            session.setAttribute("userList",userList);
        }

        return "userListUI";
    }
    /**
     * @brief 用户添加页面
     * @return
     */
    public String userAddUI() {
        return "userAddUI";
    }

    /**
     * @brief 用户添加
     * @return
     */
    public String userAdd() {
        userService.userAdd(user);
        return "toUserList";
    }

    /**
     * @brief 用户删除
     * @return
     */
    public String userDelete() {
        userService.userDeleteById(user.getUserID());
        return "toUserList";
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
