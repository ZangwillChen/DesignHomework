package com.czw.entity;

import java.util.Date;

/**
 * @brief 可预约实验室信息
 * @author zhuguangjin
 *
 */
public class ReserveInfo {

    private String cRevLabName;// 可预约实验室名
    private String cRevLabLocation;// 可预约实验室位置
    private Date cRevData = new Date();// 可预约实验时间

    public ReserveInfo() {

    }

    public ReserveInfo(String cRevLabName, String cRevLabLocation, Date cRevData) {
        // super();
        this.cRevLabName = cRevLabName;
        this.cRevLabLocation = cRevLabLocation;
        this.cRevData = cRevData;
    }

    public String getcRevLabName() {
        return cRevLabName;
    }

    public void setcRevLabName(String cRevLabName) {
        this.cRevLabName = cRevLabName;
    }

    public String getcRevLabLocation() {
        return cRevLabLocation;
    }

    public void setcRevLabLocation(String cRevLabLocation) {
        this.cRevLabLocation = cRevLabLocation;
    }

    public Date getcRevData() {
        return cRevData;
    }

    public void setcRevData(Date cRevData) {
        this.cRevData = cRevData;
    }

}
