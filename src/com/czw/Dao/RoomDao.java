package com.czw.Dao;

import com.czw.entity.ReserveInfo;
import com.czw.entity.Room;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
public interface RoomDao extends BaseDao<Room> {
    List<Room> getRoomByTime(String timeTable);
    Room getReserveInfo(String roomName, List<ReserveInfo> info);
}
