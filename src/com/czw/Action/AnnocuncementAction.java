package com.czw.Action;

import com.czw.Service.AnnouncementService;
import com.czw.entity.Announcement;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/26.
 * @brief 公告Action类
 */

@Scope("prototype")
@Controller("AnncouncementAction")
public class AnnocuncementAction extends BaseAction implements ModelDriven<Announcement>{

    private static final long serialVersionUID = 1L;

    Announcement anno = new Announcement();
    @Autowired
    @Resource
    private AnnouncementService announcementService;

    /**
     * @brief 公告列表
     * @return
     */
    public String annoListUI() {
        List<Announcement> annoList = announcementService.anno_findAll();
        session.setAttribute("annoList", annoList);
        return "annoListUI";

    }

    /**
     * @brief 查看公告
     * @return
     */

    public String annoSeeUI() {
        Announcement annoSee = announcementService.getAnnoById(anno.getAnnoID());
        session.setAttribute("annoSee",annoSee);
        return "annoSeeUI";
    }
    /**
     * @brief 公告添加页面
     * @return
     */
    public String annoAddUI() {
        return "annoAddUI";
    }

    /**
     * @brief 公告添加
     * @return
     */
    public String annoAdd(){
        announcementService.annoAdd(anno);
        return "toAnnoListUI";
    }

    public String annoDelete(){
        announcementService.annoDeleteById(anno.getAnnoID());
        return "toAnnoListUI";
    }

    @Override
    public Announcement getModel(){
        return anno;
    }

    public AnnouncementService getAnnouncementService(){
        return announcementService;
    }

    public void setAnnouncementService(AnnouncementService annoService){
        announcementService = annoService;
    }

}
