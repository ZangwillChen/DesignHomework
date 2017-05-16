package com.czw.entity;

import javax.xml.soap.SAAJResult;
import java.util.Set;

/**
 * Created by chenzhaowen on 2017/5/16.
 * @brief 用户实体类
 */
public class User {

    private long userID;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String ReserveInf;
    private Role userType;

    public  User(){

    }

    public User(long userID,String userName,String userPassword,
                String userPhone,String userEmail,String ReserveInf,Role userType){
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.ReserveInf = ReserveInf;
        this.userType = userType;
    }
}
