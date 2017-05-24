package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/17.
 * @brief 预约信息实体类
 */
public class ReserveInfo {
    private long revID;
    private String revDate;//时间

    public ReserveInfo(){

    }

    public ReserveInfo(long revID,String revDate){
        this.revID = revID;
        this.revDate = revDate;
    }

    public long getRevID() {
        return revID;
    }

    public void setRevID(long revID) {
        this.revID = revID;
    }

    public String getRevDate() {
        return revDate;
    }

    public void setRevDate(String revDate) {
        this.revDate = revDate;
    }
}
