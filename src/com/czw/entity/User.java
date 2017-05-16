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

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getReserveInf() {
        return ReserveInf;
    }

    public void setReserveInf(String reserveInf) {
        ReserveInf = reserveInf;
    }

    public Role getUserType() {
        return userType;
    }

    public void setUserType(Role userType) {
        this.userType = userType;
    }
}
