package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.RoomTimeTable;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/25.
 */
public interface RoomTimeTableService extends BaseDao<RoomTimeTable> {
    List<RoomTimeTable> getAllByStatus(String unhandle);

    RoomTimeTable getRoomTimeTableByCtime(String revRoomName,String revWeek,String revTime);

    List<RoomTimeTable> RomTimeTablefindAll();

    RoomTimeTable getRoomTimeTableByRoom(String roomName);

}
