package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/17.
 * @brief 房间时间表实体类
 */
public class RoomTimeTable {

    private long tableID;
    private Room room;
    private String roomStatus;

    public RoomTimeTable(){

    }

    public RoomTimeTable( long tableID,Room room,String roomStatus){
        this.tableID = tableID;
        this.room = room;
        this.roomStatus = roomStatus;
    }

    public long getTableID() {
        return tableID;
    }

    public void setTableID(long tableID) {
        this.tableID = tableID;
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
