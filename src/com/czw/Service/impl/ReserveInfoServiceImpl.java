package com.czw.Service.impl;

import com.czw.Dao.ReserveInfoDao;
import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.ReserveInfoService;
import com.czw.entity.ReserveInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/25.
 */
@Service
@Transactional
public class ReserveInfoServiceImpl extends BaseDaoImpl<ReserveInfo> implements ReserveInfoService {

    @Resource
    ReserveInfoDao reserveInfoDao;

    @Override
    public List<ReserveInfo> ReserveInfofindAll() {
        List<ReserveInfo> reserveInfoList = findall();
        return reserveInfoList;
    }

    public List<ReserveInfo> getReserveInfoByUserName(String userName){
        return reserveInfoDao.getReserveInfoByUserName(userName);
    }
    public ReserveInfo getReserveInfoByRoomName(String roomName){
        return reserveInfoDao.getReserveInfoByRoomName(roomName);
    }

    @Override
    public void deleteById(long revID){
        delete(revID);
    }

    @Override
    public void reserveInfo_update(ReserveInfo reserveInfo){
        update(reserveInfo);
    }


}
