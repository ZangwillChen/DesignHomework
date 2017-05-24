package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoomService;
import com.czw.entity.ReserveInfo;
import com.czw.entity.ReserveStatus;
import com.czw.entity.Room;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public class RoomServiceImpl extends BaseDaoImpl<Room> implements RoomService {

    /*
   * @brief 获取房间列表逻辑接口实现
   * @return
   * */
    @Override
   public List<Room> getRoomList(){
       List<Room> roomList = findall();
       return roomList;
   }

    /*
    * @brief 根据房间状态（是否停用）逻辑接口实现
    * @param roomStatus
    * @return
    * */
    @Override
    public List<Room> getRoomListByStatus(String roomStatus){
        List<Room> roomList = getRoomListByStatus(roomStatus);
        return roomList;
    }

    /*
    * @brief 获取预约信息逻辑接口实现
    * @param roomID
    * @param ReserveInfo
    * @return
    * */
    @Override
    public ReserveInfo getReserveInfo(long roomID){

    }

    /*
    * @brief 修改房间类型逻辑接口实现
    * @param roomID
    * @param roomType
    * @return
    * */
    Room changeType(long roomID, int roomType);

    void updateReserveStatus(ReserveInfo info, ReserveStatus status);

    /*
    * @brief 修改房间停用状态逻辑接口实现实现
    * @param roomID
    * */
    void roomStatusChange(long roomID);

    /*
    * @brief 添加房间逻辑接口实现
    * @param room
    * */
    void roomAdd(Room room);

    /*
    * @brief 根据ID删除房间逻辑接口实现
    * @param roomID
    * */
    void roomDeleteById(long roomID);
}
