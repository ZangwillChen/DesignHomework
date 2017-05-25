package com.czw.Service.impl;

import com.czw.Dao.RoomTimeTableDao;
import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoomTimeTableService;
import com.czw.entity.RoomTimeTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by chenzhaowen on 2017/5/25.
 */
@Service
@Transactional
public class RoomTimeTableServiceImpl extends BaseDaoImpl<RoomTimeTable> implements RoomTimeTableService {

    @Resource
    RoomTimeTableDao roomTimeTableDao;

    public List<RoomTimeTable> getAllByStatus(String unhandle){
        List<RoomTimeTable> roomTimeTableList = roomTimeTableDao.getAllByStatus(unhandle);
        return roomTimeTableList;
    }

    public void confirmUnhanleRoom(long roomTimeTableID, String handle){       //管理员更改未审核的房间状态
        RoomTimeTable roomTimeTable = getById(roomTimeTableID);
        roomTimeTable.setRoomStatus(handle);
        update(roomTimeTable);
    }

    public void RoomTimeTableDeleteById(long RoomTimeTableId){
        delete(RoomTimeTableId);
    }


}
