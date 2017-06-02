<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/Css/skin.css" />

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/data/laydate.js"></script>

    <script type="text/javascript">
        function getvalue() {
            var form = document.getElementById("myform");
            var inputbn = document.getElementById("roomTimeTableWeek");
            var inputrt = document.getElementById("roomTime");

            form.method = "post";
            form.action = "/users/roomttb_roomReserve";
            form.submit();
        }
    </script>

</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <!-- 头部开始 -->
    <tr>
        <td width="17" valign="top"
            background="${pageContext.request.contextPath}/Images//mail_left_bg.gif">
            <img
                    src="${pageContext.request.contextPath}/Images//left_top_right.gif"
                    width="17" height="29" />
        </td>
        <td valign="top"
            background="${pageContext.request.contextPath}/Images//content_bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0"
                   cellspacing="0"
                   background="${pageContext.request.contextPath}/Images//content_bg.gif">
                <tr>
                    <td height="31"><div class="title1">实验室查询</div></td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top"
            background="${pageContext.request.contextPath}/Images//mail_right_bg.gif"><img
                src="${pageContext.request.contextPath}/Images//nav_right_bg.gif"
                width="16" height="29" /></td>
    </tr>
    <!-- 中间部分开始 -->
    <tr>
        <!--第一行左边框-->
        <td valign="middle"
            background="${pageContext.request.contextPath}/Images//mail_left_bg.gif">&nbsp;</td>
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
                                        src="${pageContext.request.contextPath}/Images//mime.gif" /></td>
                                <td valign="bottom"><h3 style="letter-spacing: 1px;">在这里，您可以预约教室！</h3></td>
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
                                    <s:form action="roomttb_roomReserve" method="POST">
                                        房间名称：<input id="roomName" class="text" type="text" name="roomName"/>
                                        课程节数：<input id="courseTime" class="text" type="text" name="roomTimeTableWeek" />
                                        预约时间: <input type="text" class="text" id="roomTime" name="roomTime" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td colspan="3"><input class="btn" type="submit"
                                                                   value="提交申请" /></td>
                                            <td>&nbsp;</td>
                                        </tr>
                                    </s:form>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="2%">&nbsp;</td>
                </tr>
                                        <!-- 遍历结束 -->
                                    </table> <!-- 其他功能超链接 -->
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
                            src="${pageContext.request.contextPath}/Images//icon_mail.gif"
                            width="16" height="11"> 服务邮箱：<br /> <img
                            src="${pageContext.request.contextPath}/Images//icon_phone.gif"
                            width="17" height="14"> 服务电话：<a
                            href="http://www.mycodes.net/" target="_blank"></a></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </td>
        <td
                background="${pageContext.request.contextPath}/Images//mail_right_bg.gif">&nbsp;</td>
    </tr>
    <!-- 底部部分 -->
    <tr>
        <td valign="bottom"
            background="${pageContext.request.contextPath}/Images//mail_left_bg.gif"><img
                src="${pageContext.request.contextPath}/Images//buttom_left.gif"
                width="17" height="17" /></td>
        <td
                background="${pageContext.request.contextPath}/Images//buttom_bgs.gif"><img
                src="${pageContext.request.contextPath}/Images//buttom_bgs.gif"
                width="17" height="17"></td>
        <td valign="bottom"
            background="${pageContext.request.contextPath}/Images//mail_right_bg.gif"><img
                src="${pageContext.request.contextPath}/Images//buttom_right.gif"
                width="16" height="17" /></td>
    </tr>
</table>

<!-- js -->
<script type="text/javascript">
    !function() {
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({
            elem : '#roomTime'
        });//绑定元素
    }();

    //日期范围限制
    var start = {
        elem : '#start',
        format : 'YYYY-MM-DD',
        min : laydate.now(), //设定最小日期为当前日期
        max : '2099-06-16', //最大日期
        istime : true,
        istoday : false,
        choose : function(datas) {
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };

    var end = {
        elem : '#end',
        format : 'YYYY-MM-DD',
        min : laydate.now(),
        max : '2099-06-16',
        istime : true,
        istoday : false,
        choose : function(datas) {
            start.max = datas; //结束日选好后，充值开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);

    //自定义日期格式
    laydate({
        elem : '#test1',
        format : 'YYYY年MM月DD日',
        festival : true, //显示节日
        choose : function(datas) { //选择日期完毕的回调
            alert('得到：' + datas);
        }
    });

    //日期范围限定在昨天到明天
    laydate({
        elem : '#hello3',
        min : laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
        max : laydate.now(+1)
        //+1代表明天，+2代表后天，以此类推
    });
</script>
</body>
</html>