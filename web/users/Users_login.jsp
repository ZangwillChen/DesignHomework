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
        <span class="title_con">教室预约管理系统</span>
    </div>
</div>

<div id="content">
    <div align="center">
        <div class="con">
            <div class="con_title">
                <span class="con_title_sp">欢迎登录教室预约管理系统</span>
            </div>
            <div class="con_panel">
                <s:form action="user_logon" method="post">
                    <div class="con_input">
                        <span>用户名：</span><input type="text" name="userName"
                                                placeholder="工号/学号" />
                    </div>
                    <div class="con_input">
                        <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password"
                                                                       name="userPassword" placeholder="密码" />
                    </div>
                    <input type="submit" value="登    录" class="submit-btn" />

                </s:form>
            </div>
        </div>
    </div>
</div>

<div style="text-align: center;">©2017. All rights reserved. </div>
</body>
</html>
