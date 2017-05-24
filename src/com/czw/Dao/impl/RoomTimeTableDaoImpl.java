package com.czw.Dao.impl;

import com.czw.Dao.RoomTimeTableDao;
import com.czw.entity.RoomTimeTable;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/24.
 */
@Repository
public class RoomTimeTableDaoImpl extends BaseDaoImpl<RoomTimeTable> implements RoomTimeTableDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<RoomTimeTable> getAllByStatus(String unhandle){
        List<RoomTimeTable> roomTimeTableList = null;
        Session session = getSession();
        Query query = session.createQuery("FROM RoomTimeTable roomtimetable WHERE roomtimetable.roomStatus=?");
        query.setParameter(0,unhandle);
        roomTimeTableList = (List<RoomTimeTable>) query.list();
        return roomTimeTableList;
    }

    @Override
    public RoomTimeTable getRoomTimeTableByCtime(String revRoomName,String revWeek,String revTime){
        RoomTimeTable roomTimeTable = null;
        Date begin = new Date();
        Date end = new Date();

        // 日期的处理，获取当前时间的开始，和当前时间的结束
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Calendar c = Calendar.getInstance();

            Date new_time = df.parse(revTime);
            c.setTime(new_time);
            //对数据库中时间参数赋值

            c.set(Calendar.HOUR_OF_DAY,0);
            c.set(Calendar.MINUTE,0);
            c.set(Calendar.SECOND,0);
            begin = c.getTime();
            String sbegin = df.format(begin);
            System.out.println("一天的开始"+sbegin);

            c.setTime(new_time);
            c.add(Calendar.DAY_OF_MONTH, +1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            end = c.getTime();
            String send = df.format(end);
            System.out.println("一天的结束：" + send);
        } catch (ParseException e){
            e.printStackTrace();
        }

        System.out.println("(教室查询参数)"+revRoomName+revWeek+revWeek);
        // 按照时间范围查询数据库中那个时间范围内的房间课表
        Session session = getSession();
        Query query = session.createQuery("FROM RoomTimeTable roomtimetable WHERE roomtimetable.roomTime>? AND roomtimetable.roomTime<=? AND roomtimetable.room.roomName=? AND roomtimetable.roomTimeTableWeek=?");
        query.setParameter(0,begin);
        query.setParameter(1,end);
        query.setParameter(2,revRoomName);
        query.setParameter(3,revWeek);

        roomTimeTable = (RoomTimeTable) query.uniqueResult();
        return roomTimeTable;
    }
}
