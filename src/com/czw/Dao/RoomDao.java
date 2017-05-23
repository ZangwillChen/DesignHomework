package com.czw.Dao;

import com.czw.entity.ReserveInfo;
import com.czw.entity.Room;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
public interface RoomDao extends BaseDao<Room> {
    Room getRoomByName(String roomName);
    List<Room> getRoomByTime(String timeTable);
    List<Room> getRoomByStatus(String roomStatus);
    List<ReserveInfo> getReserveInfo(Room room);
}
