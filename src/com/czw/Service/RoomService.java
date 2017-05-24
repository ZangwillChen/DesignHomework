package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.ReserveInfo;
import com.czw.entity.ReserveStatus;
import com.czw.entity.Room;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 * @brief 房间业务逻辑接口
 */
public interface RoomService extends BaseDao<Room> {

    /*
    * @brief 获取房间列表逻辑接口
    * @return
    * */
    List<Room> getRoomList();

    /*
    * @brief 根据房间状态（是否停用）逻辑接口
    * @param roomStatus
    * @return
    * */
    List<Room> getRoomListByStatus(String roomStatus);


    /*
    * @brief 获取预约信息逻辑接口
    * @param roomID
    * @param ReserveInfo
    * @return
    * */
    ReserveInfo getReserveInfo(long roomID);

    /*
    * @brief 修改房间类型逻辑接口
    * @param roomID
    * @param roomType
    * @return
    * */
    Room changeType(long roomID, int roomType);

    /*
    * @brief 修改房间停用状态逻辑接口
    * @param roomID
    * */
    void roomStatusChange(long roomID);

    /*
    * @brief 添加房间逻辑接口
    * @param room
    * */

    void updateReserveStatus(ReserveInfo info, ReserveStatus status);

    void roomAdd(Room room);

    /*
    * @brief 根据ID删除房间逻辑接口
    * @param roomID
    * */
    void roomDeleteById(long roomID);

}
