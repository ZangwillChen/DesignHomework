package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.RoomTimeTable;
import com.czw.entity.User;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/25.
 */
public interface RoomTimeTableService extends BaseDao<RoomTimeTable> {
    List<RoomTimeTable> getRoomTimeTableList(String unhandle);

    void confirmUnhandleRoom(long roomTimeTableID, String handle);

    void RoomTimeTableDeleteById(long RoomTimeTableId);

    void RoomTimeTableSave(RoomTimeTable roomTimeTable);

    List<RoomTimeTable> getRoomTimeTableListByUser(User user);
}
