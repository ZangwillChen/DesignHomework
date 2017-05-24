package com.czw.Service.impl;

import com.czw.Dao.RoomDao;
import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoomService;
import com.czw.entity.ReserveInfo;
import com.czw.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public class RoomServiceImpl extends BaseDaoImpl<Room> implements RoomService {

    @Resource
    RoomDao roomDao;


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
        List<Room> roomList = roomDao.getRoomByStatus(roomStatus);
        return roomList;
    }

    public List<Room> getRoomListByRole(int userType,String roomStatus){
        List<Room> roomList = null;
        Session session = getSession();
        Query query =session.createQuery("FROM Room room WHERE room.roomStatus=? AND room.roomtype<=?");
        query.setParameter(0,roomStatus);
        query.setParameter(1,userType);
        roomList = (List<Room>) query.list();
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
