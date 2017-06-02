package com.czw.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenzhaowen on 2017/5/17.
 */
public class Room {

    private long roomID;
    private String roomName;
    private String roomStatus;//是否为停用
    private int roomtype;


    public Room(){

    }

    public Room(long roomID, String roomName, String roomStatus, int roomtype) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomStatus = roomStatus;
        this.roomtype = roomtype;

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

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(int roomtype) {
        this.roomtype = roomtype;
    }

}
