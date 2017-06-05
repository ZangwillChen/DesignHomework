<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../Css/skin.css" />
</head>
<body>
<table cellpadding="0" width="100%" height="64" background="../Images//top_top_bg.gif">
    <tr valign="top">
        <td width="70%"><a href="javascript:void(0)"><img style="border:none" /></a></td>
        <td width="20%" style="padding-top:13px;font:15px Arial,SimSun,sans-serif;color:#FFF">用户：<b>${userName}</b> 您好，感谢登陆！</td>
        <td style="padding-top:10px;" align="center"><a href="${pageContext.request.contextPath}/users/main.jsp" target="main"><img style="border:none" src="../Images//index.gif" /></a></td>
        <td style="padding-top:10px;" align="center"><a href="${pageContext.request.contextPath}/users/logout.jsp" target="_parent"> <img style="border:none" src="../Images//out.gif"/></a></td>
    </tr>
</table>
</body>
</html>