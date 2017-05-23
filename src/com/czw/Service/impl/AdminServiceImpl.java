package com.czw.Service.impl;

import com.czw.Dao.impl.BaseDaoImpl;
import com.czw.Service.AdminService;
import com.czw.entity.Admin;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by chenzhaowen on 2017/5/23.
 */
@Service
@Transactional
public class AdminServiceImpl extends BaseDaoImpl<Admin> implements AdminService {

    Admin admin;
    @Override
    public Admin admin_login(String adminName,String adminPassword){

    }

}
