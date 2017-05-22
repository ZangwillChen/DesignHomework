package com.czw.Dao;

import com.czw.entity.RoomTimeTable;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
public interface RoomTimeTableDao extends BaseDao<RoomTimeTable>{
    List<RoomTimeTable> getAllByStatus(String roomStatus);
}
