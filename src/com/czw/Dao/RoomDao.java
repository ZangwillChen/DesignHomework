package com.czw.Dao;

import com.czw.entity.Room;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
public interface RoomDao extends BaseDao<Room> {
    Room getRoomByName(String roomName);

  //  Room getRoomByNameAndType(String roomName, User user);
    /*List<Room> getRoomByTime(String timeTable);*/
    List<Room> getRoomByStatus(String roomStatus);
}
