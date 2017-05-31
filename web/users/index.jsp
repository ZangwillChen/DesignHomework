<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>教室预约管理中心</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<frameset rows="64,*" frameborder="no" border="0" framespacing="0">
    <!--头部-->
    <frame src="top.jsp" name="top" noresize="noresize" frameborder="0"
           scrolling="no" marginwidth="0" marginheight="0" />
    <!--主体部分-->
    <frameset cols="185,*">
        <!--主体左部分-->
        <frame src="left.jsp" name="left" noresize="noresize" frameborder="0"
               scrolling="no" marginwidth="0" marginheight="0" />
        <!--主体右部分-->
        <frame src="main.jsp" name="main" frameborder="0" scrolling="auto"
               marginwidth="0" marginheight="0" />
    </frameset>
</frameset>
</html>