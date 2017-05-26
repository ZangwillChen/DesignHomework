package com.czw.Action;

import com.czw.Service.RoomTimeTableService;
import com.czw.entity.RoomTimeTable;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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


}
