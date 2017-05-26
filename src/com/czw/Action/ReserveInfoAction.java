package com.czw.Action;

import com.czw.Service.ReserveInfoService;
import com.czw.entity.ReserveInfo;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by chenzhaowen on 2017/5/26.
 */
@Scope("prototype")
@Controller("ReserveInfoAction")
public class ReserveInfoAction extends BaseAction implements ModelDriven<ReserveInfo> {

    private static final long serialVersionUID = 1L;

    ReserveInfo reserveInfo = new ReserveInfo();

    @Resource
    ReserveInfoService reserveInfoService;


}
