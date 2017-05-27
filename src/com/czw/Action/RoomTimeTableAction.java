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
    @Autowired
    @Resource
    RoomTimeTableService roomTimeTableService;

    /**
     * @brief 房间申请状态
     * @author zhuguangjin
     *
     */
    public interface roomtbStatus {
        public final String unhandle = "已申请";
        public final String handle = "已处理";
        public final String finished = "已完成";
    }

    /**
     * @brief 未处理预约列表
     * @return
     */

    public String roomNotHandleListUI(){
        List<RoomTimeTable> roomTimeTableList = roomTimeTableService.getAllByStatus(roomtbStatus.unhandle);
        Iterator<RoomTimeTable> ite = roomTimeTableList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getUser().getUserPhone());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
        }
        request.setAttribute("roomTimeTableList",roomTimeTableList);
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

        List<RoomTimeTable> roomTimeTableList = roomTimeTableService.getAllByStatus(roomtbStatus.handle);
        Iterator<RoomTimeTable> ite = roomTimeTableList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getUser().getUserPhone());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
        }
        request.setAttribute("roomTimeTableList",roomTimeTableList);
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
        List<RoomTimeTable> roomTimeTableList = roomTimeTableService.getAllByStatus(roomtbStatus.finished);
        Iterator<RoomTimeTable> ite = roomTimeTableList.iterator();
        while (ite.hasNext()){
            RoomTimeTable str = ite.next();
            System.out.println(str.getUser().getUserName());
            System.out.println(str.getUser().getUserPhone());
            System.out.println(str.getRoomTimeTableWeek());
            System.out.println(str.getRoomTime());
        }
        request.setAttribute("roomTimeTableList",roomTimeTableList);
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

    public RoomTimeTableService getRoomTimeTableService() {
        return roomTimeTableService;
    }

    public void setRoomTimeTableService(RoomTimeTableService roomTimeTableService) {
        this.roomTimeTableService = roomTimeTableService;
    }
}
