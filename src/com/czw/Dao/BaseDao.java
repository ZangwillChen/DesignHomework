package com.czw.Dao;

import java.util.List;
/**
 * Created by chenzhaowen on 2017/5/22.
 */
public interface BaseDao<T> {
    /*
    * @保存实体
    * @param entity
    */

    public void save(T entity);

    /*
    * @删除实体
    * @param id
     */

    public void delete(long id);

    /*
    * @更新实体
    * @param entity
     */

    public void update(T entity);

    /*
    * @按id查询
    * @param id
    * @return
     */

    public T getById(long id);

    /*
    * @按多个id查询
    * @param id
    * @return
     */

    public List<T> getByIds(Long[] ids);

    /*
    * @查询所有
    * @return
     */

    public List<T> findall();


}
