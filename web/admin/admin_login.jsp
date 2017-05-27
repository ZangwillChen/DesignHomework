<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../Css/xgxt_login.css" />
    <title>用户登录</title>
</head>
<body>

<div id="header">
    <div class="header_title">
        <span class="title_con">实验室预约管理系统</span>
    </div>
</div>

<div id="content">
    <div align="center">
        <div class="con">
            <div class="con_title">
                <span class="con_title_sp">欢迎登录后台管理系统</span>
            </div>
            <div class="con_panel">
                <form action="admin_logon" method="post">
                    <div class="con_input">
                        <span>用户名：</span><input type="text" name="admin.adminName"
                                                placeholder="工号" />
                    </div>
                    <div class="con_input">
                        <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password"
                                                                       name="admin.adminPassword" placeholder="密码" />
                    </div>
                    <input type="submit" value="登    录" class="submit-btn" />

                </form>
            </div>
        </div>
    </div>
</div>

<div style="text-align: center;">©2016. All rights reserved. </div>
</body>
</html>
