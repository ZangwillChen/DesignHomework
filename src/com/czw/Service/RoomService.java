package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.ReserveInfo;
import com.czw.entity.Room;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public interface RoomService extends BaseDao<Room> {

    List<Room> getRoomList();

    List<Room> getRoomListByStatus(String roomStatus);

    ReserveInfo getReserveInfo(long roomID, ReserveInfo info);

    Room changeType(long roomID, int roomtype);

    void roomStatusChange(long roomID);

    void roomAdd(Room room);

    void roomDeleteById(long roomID);

}
