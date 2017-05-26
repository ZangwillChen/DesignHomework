package com.czw.Action;

import com.czw.Service.RoomService;
import com.czw.Service.UserService;
import com.czw.entity.Admin;
import com.czw.entity.Room;
import com.czw.entity.User;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
@Scope("prototype")
@Controller("RoomAction")
public class RoomAction extends BaseAction implements ModelDriven<Room> {

    private static final long serialVersionUID = 1L;

    Room room = new Room();
    User user = new User();
    Admin admin = new Admin();

    @Resource
    RoomService roomService;
    UserService userService;

    /**
     * @brief 房间列表
     * @return
     */

    public String roomListUI(Admin admin) {
        List<Room> roomList = roomService.getRoomList();
        session.setAttribute("roomList",roomList);
        return "roomListUI";
    }

    public String roomListUI(User user) {
        List<Room> roomList = roomService.getRoomListByRole(user.getUserType().getPermission(),room.getRoomStatus());
        session.setAttribute("roomList",roomList);
        return "roomListUI";
    }

    /**
     * @brief 房间添加列表
     * @return
     */

    public String roomAddUI() {
        return "roomAddUI";
    }

    /**
     * @brief 房间添加
     * @return
     */

    public String roomAdd() {
        roomService.roomAdd(room);
        return "toRoomListUI";
    }

    /**
     * @brief 房间修改
     * @return
     */
    public String roomEdit(){

        System.out.println("(房间修改信息)房间ID"+room.getRoomStatus());
        Room editRoom = roomService.getById(room.getRoomID());

        if (editRoom != null) {
            System.out.println("编辑之前："+editRoom.getRoomID());
            editRoom.setRoomName(room.getRoomName());
            editRoom.setRoomStatus(room.getRoomStatus());
            editRoom.setRoomtype(room.getRoomtype());

            roomService.update(editRoom);

            System.out.println("编辑之后："+editRoom.getRoomStatus());
            return "toRoomListUI";
        }
        return "ERROR";
    }

    public String roomEditUI() {
        return "roomEditUI";
    }

    /**
     * @brief 房间删除
     * @return
     */
    public String roomDelete() {
        roomService.roomDeleteById(room.getRoomID());
        return "toRoomListUI";
    }

    @Override
    public Room getModel(){
        return room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
