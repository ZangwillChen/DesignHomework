package com.czw.Service;

import com.czw.Dao.BaseDao;
import com.czw.entity.Announcement;

import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 * @brief 公告业务逻辑接口
 */
public interface AnnouncementService extends BaseDao<Announcement> {


    /*
    * @brief 查询所有公告
    * @return
    * */
    List<Announcement> anno_findAll();


    /*
    * @brief 按ID查询
    * @param annoID
    * @return
    * */
    Announcement getAnnoById(long annoID);

    /*
    * @brief 添加公告
    * @param anno
    * */

    void annoAdd(Announcement anno);

    /*
    * @brief 按ID删除
    * @param annoID
    * */

    void annoDeleteById(long annoID);
}
