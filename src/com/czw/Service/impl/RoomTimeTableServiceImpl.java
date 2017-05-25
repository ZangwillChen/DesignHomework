package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoomTimeTableService;
import com.czw.entity.RoomTimeTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by chenzhaowen on 2017/5/25.
 */
@Service
@Transactional
public class RoomTimeTableServiceImpl extends BaseDaoImpl<RoomTimeTable> implements RoomTimeTableService {
    List<RoomTimeTable> getAllByStatus(String unhandle);

    RoomTimeTable getRoomTimeTableByCtime(String revRoomName,String revWeek,String revTime);

    List<RoomTimeTable> RomTimeTablefindAll();

    RoomTimeTable getRoomTimeTableByRoom(String roomName);



}
