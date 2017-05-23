package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.AnnouncementService;
import com.czw.entity.Announcement;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
public class AnnouncementServiceImpl extends BaseDaoImpl<Announcement> implements AnnouncementService {

    @Override
    public List<Announcement> anno_findAll(){
        List<Announcement> ListAnno = findall();
        return ListAnno;
    }

    @Override
    public Announcement getAnnoById(long annoID){
        return getById(annoID);
    }

    @Override
    public void annoAdd(Announcement anno){
        save(anno);
    }

    @Override
    public void annoDeleteById(long annoID){
        delete(annoID);
    }
}
