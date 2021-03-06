package com.czw.Service.impl;

import com.czw.Dao.RoomDao;
import com.czw.Dao.RoomTimeTableDao;
import com.czw.Dao.UserDao;
import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.UserService;
import com.czw.entity.ReserveInfo;
import com.czw.entity.ReserveInfoSearch;
import com.czw.entity.RoomTimeTable;
import com.czw.entity.User;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/25.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

    @Resource
    UserDao userDao;
    RoomTimeTableDao roomTimeTableDao;
    RoomDao roomDao;

    /*
   * @brief 获取所有用户逻辑接口实现
   * @return
   * */
    @Override
    public List<User> userFindAll(){
        List<User> userList = findall();
        return userList;
    }

    /*
    * @brief 根据姓名获取用户信息逻辑接口实现
    * @param userName
    * @return
    * */
    @Override
    public User getUserByName(String userName){

        User user = null;
        Session session = getSession();
        Query query = session.createQuery("FROM User user WHERE user.userName=?");
        query.setParameter(0,userName);
        user = (User) query.uniqueResult();
        return user;
    }

    /*
    * @brief 用户登录逻辑接口实现
    * @param userName
    * @param userPassword
    * @return
    * */
    @Override
    public User user_login(String userName,String userPassword){
        User user = userDao.getUserByNameAndPwd(userName,userPassword);
        return user;
    }

    /*
    * @brief 添加用户逻辑接口实现
    * @param user
    * @return
    * */
    @Override
    public void userAdd(User user){
        save(user);
    }

    /*
    * @brief 根据ID删除用户逻辑接口实现
    * @param userID
    * @return
    * */
    @Override
    public void userDeleteById(long userID){
        delete(userID);
    }

    /*
    * @brief 更新用户信息逻辑接口实现
    * @param user
    * @return
    * */
    @Override
    public User user_edit_getById(long userID){
        User userEdit = getById(userID);
        if (userEdit != null){
            return userEdit;
        }
        return null;
    }

    @Override
    public void user_edit_update(User user){
        update(user);
    }

    @Override
    public List<User> getUserByType(String userType){
        List<User> users = userDao.getByType(userType);
        return users;
    }

    public ReserveInfo getReserveInfoList(ReserveInfoSearch serchInfo){
        ReserveInfo reserveInfo = new ReserveInfo();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date revTime = null;
        try {
            revTime = df.parse(serchInfo.getRevTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RoomTimeTable roomTimeTable = roomTimeTableDao.getRoomTimeTableByCtime(serchInfo.getRevRoomName(),
                serchInfo.getRevWeek(),serchInfo.getRevTime());

        if (roomTimeTable != null){
            return reserveInfo;
        }
        reserveInfo.setcRevLabName(serchInfo.getRevRoomName());
        reserveInfo.setcRevLabLocation(roomDao.getRoomByName(serchInfo.getRevRoomName()).getRoomName());
        reserveInfo.setcRevData(revTime);
        // 将查询结果保存到List中
        return reserveInfo;
    }


}
