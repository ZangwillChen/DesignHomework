package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/17.
 * @brief 预约信息实体类
 */
public class ReserveInfo {
    private long revID;
    private String revDate;//时间
    private User user;
    private Room room;
    private Course course;

    public ReserveInfo() {
    }

    public ReserveInfo(long revID, String revDate, User user, Room room, Course course) {
        this.revID = revID;
        this.revDate = revDate;
        this.user = user;
        this.room = room;
        this.course = course;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
