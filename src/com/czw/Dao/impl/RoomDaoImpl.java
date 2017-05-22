package com.czw.Dao.impl;

import com.czw.Dao.RoomDao;
import com.czw.entity.ReserveInfo;
import com.czw.entity.Room;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import org.hibernate.Query;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
@Repository
public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao{
    @Override
    public Room getRoomByName(String roomName){
        Room room = null;
        Session session = getSession();
        Query query = session.createQuery("FROM Room room WHERE room.roomName=?");
        query.setParameter(0,roomName);
        room = (Room)query.uniqueResult();
        return room;
    }

    public List<Room> getRoomByTime(String timeTable){

    }

    public List<Room> getRoomByStatus(String roomStatus){

    }

    public Room getReserveInfo(String roomName, List<ReserveInfo> info){

    }

}
