package com.czw.entity;

import java.util.Date;

/**
 * Created by chenzhaowen on 2017/5/24.
 */
public class RoomTimeTable {

    private long roomTimeTableID;
    private  String roomTimeTableWeek;//课表中的星期次
    private Room room;//课表中教室外键
    private User user;
    private Date roomTime = new Date();//这节课的时间
    private String roomStatus;//这节课的状态
    private String roomName;
    //private String userName;

    public RoomTimeTable() {
    }

    public RoomTimeTable(long roomTimeTableID, String roomTimeTableWeek, Room room, User user, Date roomTime, String roomStatus, String roomName) {
        this.roomTimeTableID = roomTimeTableID;
        this.roomTimeTableWeek = roomTimeTableWeek;
        this.room = room;
        this.user = user;
        this.roomTime = roomTime;
        this.roomStatus = roomStatus;
        this.roomName = roomName;
       // this.userName = userName;
    }

    public long getRoomTimeTableID() {
        return roomTimeTableID;
    }

    public void setRoomTimeTableID(long roomTimeTableID) {
        this.roomTimeTableID = roomTimeTableID;
    }

    public String getRoomTimeTableWeek() {
        return roomTimeTableWeek;
    }

    public void setRoomTimeTableWeek(String roomTimeTableWeek) {
        this.roomTimeTableWeek = roomTimeTableWeek;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRoomTime() {
        return roomTime;
    }

    public void setRoomTime(Date roomTime) {
        this.roomTime = roomTime;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


}
