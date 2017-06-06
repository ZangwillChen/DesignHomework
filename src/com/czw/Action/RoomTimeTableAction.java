package com.czw.Action;

import com.czw.Service.RoomService;
import com.czw.Service.RoomTimeTableService;
import com.czw.entity.Room;
import com.czw.entity.RoomTimeTable;
import com.czw.entity.User;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
@Scope("prototype")
@Controller("RoomTimeTableAction")
public class RoomTimeTableAction extends BaseAction implements ModelDriven<RoomTimeTable> {

    private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(RoomTimeTable.class);

    RoomTimeTable roomTimeTable =new RoomTimeTable();
    Room room = new Room();
    @Resource
    RoomTimeTableService roomTimeTableService;
    RoomService roomService;

    /**
     * @brief 房间申请状态
     * @author zhuguangjin
     *
     */
    public interface roomtbStatus {
        public final String unhandle = "已申请";
        public final String handle = "已处理";
        public final String finished = "已拒绝";
    }

    /**
     * @brief 未处理预约列表
     * @return
     */

    public String roomNotHandleListUI(){
        List<RoomTimeTable> roomtbList = roomTimeTableService.getRoomTimeTableList(roomtbStatus.unhandle);
        Iterator<RoomTimeTable> ite = roomtbList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getRoomTimeTableID());
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getRoomName());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
       }
       //if (roomtbList != null && roomtbList.size() > 0) {
           request.setAttribute("roomtbList", roomtbList);
      // }
        return "roomNotHandleListUI";
    }

    /**
     * @brief 确认未处理预约-允许预约
     * @return
     */

    public String roomReserveConfirm(){
        roomTimeTableService.confirmUnhandleRoom(roomTimeTable.getRoomTimeTableID(),roomtbStatus.handle);
        logger.info("允许预约"+roomTimeTable.getRoomName() +roomTimeTable.getRoomTime());
        return "toRoomNotHandleListUI";
    }

    public String roomReserveDecline(){
        roomTimeTableService.confirmUnhandleRoom(roomTimeTable.getRoomTimeTableID(),roomtbStatus.finished);
        logger.info("拒绝预约"+roomTimeTable.getRoomName() +roomTimeTable.getRoomTime());
        return "toRoomNotHandleListUI";
    }

    /**
     * @brief 未处理预约删除
     * @return
     */

    public String roomNotHandleDelete() {   //存疑
        roomTimeTableService.RoomTimeTableDeleteById(roomTimeTable.getRoomTimeTableID());
        logger.info("删除未处理预约"+roomTimeTable.getRoomName() +roomTimeTable.getRoomTime());
        return "toRoomNotHandleListUI";
    }

    /**
     * @brief 已处理预约列表
     * @return
     */

    public String roomHandleListUI() {

        List<RoomTimeTable> roomtbList = roomTimeTableService.getRoomTimeTableList(roomtbStatus.handle);
        Iterator<RoomTimeTable> ite = roomtbList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getRoomTimeTableID());
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getRoomName());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
        }
        request.setAttribute("roomtbList", roomtbList);
        return "roomHandleListUI";
    }
    /**
     * @brief 已处理预约删除
     * @return
     */
    public String roomHandleDelete(){
        roomTimeTableService.RoomTimeTableDeleteById(roomTimeTable.getRoomTimeTableID());
        logger.info("强制取消预约"+roomTimeTable.getUser().getUserName()+roomTimeTable.getRoomName()+roomTimeTable.getRoomTime());
        return "toRoomHandleListUI";
    }



    /**
     * @brief 已完成列表
     * @return
     */
    public String roomFinishedListUI() {
        List<RoomTimeTable> roomtbList = roomTimeTableService.getRoomTimeTableList(roomtbStatus.finished);
        Iterator<RoomTimeTable> ite = roomtbList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getRoomTimeTableID());
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getRoomName());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
        }

        request.setAttribute("roomtbList", roomtbList);
        return "roomFinishedListUI";
    }
    /**
     * @brief 已完成预约删除
     * @return
     */
    public String roomFinishedDelete() {
        roomTimeTableService.RoomTimeTableDeleteById(roomTimeTable.getRoomTimeTableID());
        logger.info("已完成预约删除"+roomTimeTable.getUser().getUserName()+roomTimeTable.getRoomName()+roomTimeTable.getRoomTime());
        return "toRoomFinishedListUI";
    }
    long reserveID;
    public String roomReserveUI(){

        return "roomReserveUI";
    }

    public String roomReserve() {
        //roomTimeTable.setRoom(room);
        roomTimeTable.setRoomStatus("已申请");
        System.out.println("预订时间表："+roomTimeTable.getRoomStatus());
        //roomTimeTableService.RoomTimeTableSave(roomTimeTable);
        //roomTimeTableService.save(roomTimeTable);
        reserveID = roomTimeTable.getRoomTimeTableID();
        String roomTimeTableWeek = request.getParameter("roomTimeTableWeek");
        String roomTime = request.getParameter("roomTime");
        String roomName = request.getParameter("roomName");
        User user = (User) session.getAttribute("ulogin");
        System.out.println("用户："+user.getUserName());
        System.out.println("房间"+room.getRoomID());

        roomTimeTable.setUser(user);
        System.out.println(roomTimeTableWeek);
        roomTimeTable.setRoomTimeTableWeek(roomTimeTableWeek);
        roomTimeTable.setRoomName(roomName);
        //roomTimeTable.setUserName(user.getUserName());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 字符串格式转化为日期格式并获取星期数
        try {
            Date new_time = df.parse(roomTime);
            roomTimeTable.setRoomTime(new_time);

        }catch (ParseException e) {
            e.printStackTrace();
        }

        roomTimeTableService.save(roomTimeTable);
        logger.info("预约房间"+roomTimeTable.getUser().getUserName()+roomTimeTable.getRoomName()+roomTimeTable.getRoomTime());
        return "roomListByUserUI";
    }

    public String userReserveInfoUI(){
        User user = (User) session.getAttribute("ulogin");
        List<RoomTimeTable> roomtbList = roomTimeTableService.getRoomTimeTableListByUser(user);
        Iterator<RoomTimeTable> ite = roomtbList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getRoomTimeTableID());
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getRoomName());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
        }
        request.setAttribute("roomtbList", roomtbList);
        return "userReserveInfoUI";
    }

    public void RoomTimeTableSave(RoomTimeTable roomTimeTable){
        roomTimeTableService.save(roomTimeTable);
    }

    @Override
    public RoomTimeTable getModel(){
        return roomTimeTable;
    }

    public RoomTimeTable getRoomTimeTable() {
        return roomTimeTable;
    }

    public void setRoomTimeTable(RoomTimeTable roomTimeTable) {
        this.roomTimeTable = roomTimeTable;
    }

}
