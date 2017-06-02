package com.czw.Service.impl;

import com.czw.Dao.RoomTimeTableDao;
import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoomTimeTableService;
import com.czw.entity.Room;
import com.czw.entity.RoomTimeTable;
import com.czw.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
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

    @Override
    public List<RoomTimeTable> getRoomTimeTableList(String unhandle){
        List<RoomTimeTable> roomTimeTables = roomTimeTableDao.getAllByStatus(unhandle);
        return roomTimeTables;
    }
    public List<RoomTimeTable> getRoomTimeTableListByUser(User user){
        List<RoomTimeTable> roomTimeTableList ;
        Session session = getSession();
        Query query =session.createQuery("FROM RoomTimeTable roomttb WHERE roomttb.user.userName=? ");    //角色的权限大于房间的roomtype时即可访问
        query.setParameter(0,user.getUserName());
        roomTimeTableList = (List<RoomTimeTable>) query.list();
        return roomTimeTableList;
    }

    @Override
    public void confirmUnhandleRoom(long roomTimeTableID, String handle){       //管理员更改未审核的房间状态
        RoomTimeTable roomTimeTable = getById(roomTimeTableID);
        roomTimeTable.setRoomStatus(handle);
        update(roomTimeTable);
    }
    @Override
    public void RoomTimeTableDeleteById(long RoomTimeTableId){
        delete(RoomTimeTableId);
    }


    public void RoomTimeTableSave(RoomTimeTable roomTimeTable){
        Session session = sessionFactory.openSession();
        Room room = (Room) getSession().load(Room.class,1L);
        roomTimeTable.setRoom(room);
        session.save(roomTimeTable);
    }
}
