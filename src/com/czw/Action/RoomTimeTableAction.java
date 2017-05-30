package com.czw.Action;

import com.czw.Service.RoomTimeTableService;
import com.czw.entity.RoomTimeTable;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
@Scope("prototype")
@Controller("RoomTimeTableAction")
public class RoomTimeTableAction extends BaseAction implements ModelDriven<RoomTimeTable> {

    private static final long serialVersionUID = 1L;

    RoomTimeTable roomTimeTable =new RoomTimeTable();
    @Resource
    RoomTimeTableService roomTimeTableService;

    /**
     * @brief 房间申请状态
     * @author zhuguangjin
     *
     */
    public interface roomtbStatus {
        public final String unhandle = "unhandle";
        public final String handle = "handle";
        public final String finished = "finished";
    }

    /**
     * @brief 未处理预约列表
     * @return
     */

    public String roomNotHandleListUI(){
        List<RoomTimeTable> roomtbList = roomTimeTableService.getAllByStatus(roomtbStatus.unhandle);
        Iterator<RoomTimeTable> ite = roomtbList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getRoomTimeTableID());
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getRoom().getRoomName());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
       }
       if (roomtbList != null && roomtbList.size() > 0) {
           session.setAttribute("roomTimeTableList", roomtbList);
       }
        return "roomNotHandleListUI";
    }

    /**
     * @brief 确认未处理预约-允许预约
     * @return
     */

    public String roomReserveConfirm(){
        roomTimeTableService.confirmUnhanleRoom(roomTimeTable.getRoomTimeTableID(),roomtbStatus.handle);
        return "toRoomNotHandleListUI";
    }

    /**
     * @brief 未处理预约删除
     * @return
     */

    public String roomNotHandleDelete() {   //存疑
        roomTimeTableService.RoomTimeTableDeleteById(roomTimeTable.getRoomTimeTableID());
        return "toRoomNotHandleListUI";
    }

    /**
     * @brief 已处理预约列表
     * @return
     */

    public String roomHandleListUI() {

        List<RoomTimeTable> roomtbList = roomTimeTableService.getAllByStatus(roomtbStatus.handle);
        request.setAttribute("roomTimeTableList", roomtbList);
        return "roomTimeTableListUI";
    }
    /**
     * @brief 已处理预约删除
     * @return
     */
    public String roomHandleDelete(){
        roomTimeTableService.RoomTimeTableDeleteById(roomTimeTable.getRoomTimeTableID());
        return "toRoomHandleListUI";
    }



    /**
     * @brief 已完成列表
     * @return
     */
    public String roomFinishedListUI() {
        List<RoomTimeTable> roomtbList = roomTimeTableService.getAllByStatus(roomtbStatus.finished);
        Iterator<RoomTimeTable> ite = roomtbList.iterator();

        request.setAttribute("roomTimeTableList", roomtbList);
        return "roomFinishedListUI";
    }
    /**
     * @brief 已完成预约删除
     * @return
     */
    public String roomFinishedDelete() {
        roomTimeTableService.RoomTimeTableDeleteById(roomTimeTable.getRoomTimeTableID());
        return "toRoomFinishedListUI";
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
