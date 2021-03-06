<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="../Js/prototype.lite.js" type="text/javascript"></script>
    <script src="../Js/moo.fx.js" type="text/javascript"></script>
    <script src="../Js/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../Css/skin.css" />
    <script type="text/javascript">
        window.onload = function() {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(toggles, contents, {
                opacity : true,
                duration : 400
            });
            myAccordion.showThisHideOpen(contents[0]);
            for (var i = 0; i < document.getElementsByTagName("a").length; i++) {
                var dl_a = document.getElementsByTagName("a")[i];
                dl_a.onfocus = function() {
                    this.blur();
                }
            }
        }
    </script>
</head>

<body>
<table width="100%" height="280" border="0" cellpadding="0"
       cellspacing="0" bgcolor="#EEF2FB">
    <tr>
        <td width="182" valign="top">
            <div id="container">
                <h1 class="type">
                    <a href="javascript:void(0)">用户管理</a>
                </h1>
                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../Images//menu_top_line.gif" width="182"
                                     height="5" /></td>
                        </tr>
                    </table>
                    <ul class="RM">
                        <li><a href="./user_userInfoUI.action" target="main">个人信息</a></li>
                    </ul>
                </div>

                <h1 class="type">
                    <a href="javascript:void(0)">预约管理</a>
                </h1>
                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../Images//menu_top_line.gif" width="182"
                                     height="5" /></td>
                        </tr>
                    </table>
                    <ul class="RM">
                        <!--<li><a href="./user_userReserveRoomUI.action" target="main">预约教室</a></li>-->
                        <li><a href="./roomttb_roomHandleListUI.action" target="main">预约信息查看</a></li>
                        <li><a href="./roomttb_userReserveInfoUI.action" target="main">我的预约</a></li>
                </div>

                <h1 class="type">
                    <a href="javascript:void(0)">进行预约</a>
                </h1>
                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../Images//menu_top_line.gif" width="182"
                                     height="5" /></td>
                        </tr>
                    </table>
                    <ul class="RM">
                        <li><a href="./room_roomListByUserUI.action" target="main">教室列表</a></li>
                </div>
                <!-- *********** -->
                <h1 class="type">
                    <a href="javascript:void(0)">信息管理</a>
                </h1>
                <div class="content">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td><img src="../Images//menu_top_line.gif" width="182"
                                     height="5" /></td>
                        </tr>
                    </table>
                    <ul class="RM">
                        <li><a href="./useranno_annoListUI.action" target="main">查看公告</a></li>
                    </ul>
                </div>
                <!-- *********** -->

                <!-- *********** -->
            </div>
        </td>
    </tr>
</table>
</body>
</html>
