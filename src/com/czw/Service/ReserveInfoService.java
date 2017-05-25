package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.ReserveInfo;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/25.
 */
public interface ReserveInfoService extends BaseDao<ReserveInfo> {
    List<ReserveInfo> getReserveInfoByUserName(String userName);
    ReserveInfo getReserveInfoByRoomName(String roomName);
    List<ReserveInfo> ReserveInfofindAll();
    void deleteById(long revID);
    void reserveInfo_update(ReserveInfo reserveInfo);


}
