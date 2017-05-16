package com.czw.entity;
/**
 * Created by chenzhaowen on 2017/5/16.
 * @brief 管理员实体类
 */
public class Admin {
    protected long adminID;
    protected String adminName;
    protected String adminPassword;
    protected String adminPhone;
    protected String adminEmail;

    public Admin(long adminID,String adminName, String adminPassword,
                 String adminPhone,String adminEmail){
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminPhone = adminPhone;
        this.adminEmail = adminEmail;
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
