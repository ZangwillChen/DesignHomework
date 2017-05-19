package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/17.
 * @brief 房间时间表实体类
 */
public class RoomTimeTable {

    private Room room;
    private String roomStatus;

    public RoomTimeTable(){

    }

    public RoomTimeTable(Room room,String roomStatus){
        this.room = room;
        this.roomStatus = roomStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
