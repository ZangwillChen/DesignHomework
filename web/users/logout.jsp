<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>您已经退出系统</title>
    <link href="../Css/logout.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id=content>
    <div align="center" >
        <div id=Logout>
            <div id=con>
                <div id=AwokeMsg>
                    <img id=LogoutImg src="../Images//logout.gif" border=0> 您已退出系统
                </div>
                <div id=LogoutOperate>
                    <img src="../Images//logout2.gif" border=0> <a
                        href="${pageContext.request.contextPath}/users/Users_login.jsp">重新进入系统</a>
                    <img src="../Images//logout3.gif" border=0> <a
                        href="javascript: window.open('','_self');window.close();">关闭当前窗口</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>