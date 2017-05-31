<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%> <%@ taglib prefix="s" uri="/struts-tags"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../Css/skin.css" />
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <!-- 头部开始 -->
    <tr>
        <td width="17" valign="top" background="../Images//mail_left_bg.gif">
            <img src="../Images//left_top_right.gif" width="17" height="29" />
        </td>
        <td valign="top" background="../Images//content_bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0"
                   cellspacing="0" background="./../Images//content_bg.gif">
                <tr>
                    <td height="31"><div class="title1">用户列表</div></td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="../Images//mail_right_bg.gif"><img
                src="../Images//nav_right_bg.gif" width="16" height="29" /></td>
    </tr>
    <!-- 中间部分开始 -->
    <tr>
        <!--第一行左边框-->
        <td valign="middle" background="../Images//mail_left_bg.gif">&nbsp;</td>
        <!--第一行中间内容-->
        <td valign="top" bgcolor="#F7F8F9">
            <table width="100%" border="0" align="center" cellpadding="0"
                   cellspacing="0">
                <!-- 空白行-->
                <tr>
                    <td colspan="2" valign="top">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td valign="top">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <table>
                            <tr>
                                <td width="100" align="center"><img
                                        src="../Images//mime.gif" /></td>
                                <td valign="bottom"><h3 style="letter-spacing: 1px;">在这里，您可以查看待处理预约列表！</h3></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <!-- 一条线 -->
                <tr>
                    <td height="40" colspan="4">
                        <table width="100%" height="1" border="0" cellpadding="0"
                               cellspacing="0" bgcolor="#CCCCCC">
                            <tr>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <!-- 产品列表开始 -->
                <tr height="340" valign="top">
                    <td width="2%">&nbsp;</td>
                    <td width="96%">
                        <table width="100%">
                            <tr>
                                <td colspan="2">
                                    <table class="defaultlist">
                                        <col width="10%">
                                        <col width="15%">
                                        <col width="15%">
                                        <col width="15%">
                                        <col width="15%">
                                        <col width="15%">
                                        <col width="15%">
                                        <tr class="title">
                                            <td>时间表ID</td>
                                            <td>借教室人</td>
                                            <td>教室</td>
                                            <td>周次</td>
                                            <td>时间</td>
                                            <td>相关操作</td>
                                        </tr>
                                        <!-- 遍历开始 -->
                                        <s:iterator value="#request.roomtbList" var="roomtb">
                                            <tr>
                                                <td><s:property value="#roomtb.roomTimeTableID" /></td>
                                                <td><s:property value="#roomtb.user.userName" /></td>
                                                <td><s:property value="#roomtb.room.roomName" /></td>
                                                <td><s:property value="#roomtb.roomTimeTableWeek" /></td>
                                                <td><s:property value="#roomtb.roomTime" /></td>
                                                <td>
                                                    <a href="<%=path%>/admin/roomttable_roomHandleDelete.action?roomTimeTableID=<s:property value=" #roomtb.roomTimeTableID"/>"
                                                       onclick="javascript: return confirm('需要删除已处理预约吗？');">删除</a></td>
                                            </tr>
                                        </s:iterator>
                                        <!-- 遍历结束 -->
                                    </table> <!-- 其他功能超链接 -->
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="2%">&nbsp;</td>
                </tr>
                <!-- 产品列表结束 -->
                <tr>
                    <td height="20" colspan="4">
                        <table width="100%" height="1" border="0" cellpadding="0"
                               cellspacing="0" bgcolor="#CCCCCC">
                            <tr>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="2%">&nbsp;</td>
                    <td width="51%" class="left_txt"><img
                            src="../Images//icon_mail.gif" width="16" height="11">
                        服务邮箱：<br /> <img
                                src="../Images//icon_phone.gif" width="17" height="14">
                        服务电话：<a href="http://www.mycodes.net/" target="_blank"></a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </td>
        <td background="../Images//mail_right_bg.gif">&nbsp;</td>
    </tr>
    <!-- 底部部分 -->
    <tr>
        <td valign="bottom" background="../Images//mail_left_bg.gif"><img
                src="../Images//buttom_left.gif" width="17" height="17" /></td>
        <td background="../Images//buttom_bgs.gif"><img
                src="../Images//buttom_bgs.gif" width="17" height="17"></td>
        <td valign="bottom" background="../Images//mail_right_bg.gif"><img
                src="../Images//buttom_right.gif" width="16" height="17" /></td>
    </tr>
</table>
</body>
</html>