package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
public class ReserveInfoSearch {
    private String revRoomName;// 教室名称
    private String revCourseTime;// 课程节数
    private String revTime;// 教室预约时间
    private String revWeek;//根据日期自己换算出来的星期

    public ReserveInfoSearch() {
    }


    public ReserveInfoSearch(String revRoomName, String revCourseTime, String revTime, String revWeek) {
        this.revRoomName = revRoomName;
        this.revCourseTime = revCourseTime;
        this.revTime = revTime;
        this.revWeek = revWeek;
    }


    public String getRevRoomName() {
        return revRoomName;
    }

    public void setRevRoomName(String revRoomName) {
        this.revRoomName = revRoomName;
    }

    public String getRevCourseTime() {
        return revCourseTime;
    }

    public void setRevCourseTime(String revCourseTime) {
        this.revCourseTime = revCourseTime;
    }

    public String getRevTime() {
        return revTime;
    }

    public void setRevTime(String revTime) {
        this.revTime = revTime;
    }

    public String getRevWeek() {
        return revWeek;
    }

    public void setRevWeek(String revWeek) {
        this.revWeek = revWeek;
    }
}
