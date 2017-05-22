package com.czw.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenzhaowen on 2017/5/17.
 */
public class Room {

    private long roomID;
    private String roomName;
    private String timeTable;
    private String roomStatus;
    private int roomtype;
    private ReserveInfo reserveInfos ;

    public Room(){

    }

    public Room(long roomID,String roomName,String timeTable,String roomStatus,
                int roomtype,ReserveInfo reserveInfos){
        this.roomID = roomID;
        this.roomName = roomName;
        this.timeTable = timeTable;
        this.roomStatus = roomStatus;
        this.roomtype = roomtype;
        this.reserveInfos = reserveInfos;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public String getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public ReserveInfo getReserveInfos() {
        return reserveInfos;
    }

    public void setReserveInfos(ReserveInfo reserveInfos) {
        this.reserveInfos = reserveInfos;
    }
}
