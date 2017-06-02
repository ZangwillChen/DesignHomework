package com.czw.Service.impl;

import com.czw.Dao.RoomDao;
import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.RoomService;
import com.czw.entity.Room;
import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
@Service
@Transactional
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

    @Override
    public Room getRoomByName(String roomName){
       return roomDao.getRoomByName(roomName);
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

    public List<Room> getRoomListByRoleAndStatus(int userType,String roomStatus){
        List<Room> roomList = null;
        Session session = getSession();
        Query query =session.createQuery("FROM Room room WHERE room.roomStatus=? AND room.roomtype<=? ");    //角色的权限大于房间的roomtype时即可访问
        query.setParameter(0,roomStatus);
        query.setParameter(1,userType);
        roomList = (List<Room>) query.list();
        return roomList;

    }

    @Override
    public void changeType(long roomID, int roomType){
        Room room;
        room = roomDao.getById(roomID);
        room.setRoomtype(roomType);
    }

    /*
    * @brief 修改房间停用状态逻辑接口
    * @param roomID
    * */
    @Override
    public void roomStatusChange(long roomID, String roomStatus){
        Room room = roomDao.getById(roomID);
        room.setRoomStatus(roomStatus);
    }

    /*
    * @brief 添加房间逻辑接口
    * @param room
    * */
    /*
    * @brief 添加房间逻辑接口实现
    * @param room
    * */
    @Override
    public void roomAdd(Room room){
        save(room);
    }

    /*
    * @brief 根据ID删除房间逻辑接口实现
    * @param roomID
    * */

    @Override
    public void roomDeleteById(long roomID){
        delete(roomID);
    }
}
