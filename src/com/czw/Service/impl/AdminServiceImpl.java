package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.AdminService;
import com.czw.entity.Admin;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
@Service
@Transactional
public class AdminServiceImpl extends BaseDaoImpl<Admin> implements AdminService {

    Admin admin;
    @Override
    public Admin admin_login(String adminName,String adminPassword){

        Session session = getSession();
        Query query = session.createQuery("FROM Admin admin WHERE admin.adminName=? AND admin.adminPassword=?");
        query.setParameter(0,adminName);
        query.setParameter(1,adminPassword);
        admin = (Admin) query.uniqueResult();
        return admin;
    }

    @Override
    public List<Admin> admin_findAll(){
        List<Admin> AdminList = findall();
        return AdminList;
    }

    @Override
    public void admin_delete(long adminID){
        delete(adminID);
    }

    @Override
    public void admin_add(Admin admin){
        save(admin);
    }

    @Override
    public Admin admin_edit_getById(long adminID){
        Admin editAdmin = getById(adminID);
        if (editAdmin != null){
            return editAdmin;
        }
        return null;
    }

    @Override
    public void admin_edit_update(Admin a){
        update(a);
    }
}
