package com.czw.entity;

import java.util.Date;

/**
 * Created by chenzhaowen on 2017/5/24.
 */
public class RoomTimeTable {

    private long roomTimeTableID;
    private  String roomTimeTableWeek;//课表中的星期次
    private Room room;//课表中教室外键
    private Date roomTime = new Date();//这节课的时间
    private String roomStatus;//这节课的状态

    public RoomTimeTable() {
    }

    public RoomTimeTable(long roomTimeTableID, String roomTimeTableWeek, Room room, Date roomTime, String roomStatus) {
        this.roomTimeTableID = roomTimeTableID;
        this.roomTimeTableWeek = roomTimeTableWeek;
        this.room = room;
        this.roomTime = roomTime;
        this.roomStatus = roomStatus;
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
}
