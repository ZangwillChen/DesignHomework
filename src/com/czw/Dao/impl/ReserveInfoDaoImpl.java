package com.czw.Dao.impl;

import com.czw.Dao.ReserveInfoDao;
import com.czw.entity.ReserveInfo;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/24.
 */
@Repository
public class ReserveInfoDaoImpl extends BaseDaoImpl<ReserveInfo> implements ReserveInfoDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<ReserveInfo> getReserveInfoByUserName(String userName){
        List<ReserveInfo> reserveInfoList = null;
        Session session = getSession();
        Query query = session.createQuery("FROM ReserveInfo reserveinfo WHERE reserveinfo.user.userName=?");
        query.setParameter(0,userName);
        reserveInfoList = (List<ReserveInfo>) query.list();
        return reserveInfoList;
    }
    @Override
    public ReserveInfo getReserveInfoByRoomName(String roomName){

        ReserveInfo reserveInfo = null;
        Session session = getSession();
        Query query = session.createQuery("FROM ReserveInfo reserveinfo WHERE reserveinfo.room.roomName=?");
        query.setParameter(0,roomName);
        reserveInfo = (ReserveInfo) query.uniqueResult();
        return reserveInfo;
    }
}
