package com.czw.Dao;

import com.czw.entity.ReserveInfo;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/24.
 */
public interface ReserveInfoDao extends BaseDao<ReserveInfo> {
   List<ReserveInfo> getReserveInfoByUserName(String userName);
    ReserveInfo getReserveInfoByRoomName(String roomName);
}
