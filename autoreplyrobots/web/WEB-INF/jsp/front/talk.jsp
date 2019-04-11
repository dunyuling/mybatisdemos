<%--
  Created by IntelliJ IDEA.
  User: liux
  Date: 19-4-11
  Time: 下午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" commandContent="text/html; charset=UTF-8"/>
    <title>微信公众号</title>
    <!--讨论区滚动条begin-->
    <link href="<%= basePath %>css/jscrollpane1.css" rel="stylesheet" type="text/css" />
    <script src="<%= basePath %>js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
    <!-- the mousewheel plugin -->
    <script src="<%= basePath %>js/jquery.mousewheel.js" type="text/javascript" charset="utf-8"></script>
    <!-- the jScrollPane script -->
    <script src="<%= basePath %>js/jquery.jscrollpane.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%= basePath %>js/scroll-startstop.events.jquery.js" type="text/javascript" charset="utf-8"></script>
    <!--讨论区滚动条end-->
    <script src="<%= basePath %>js/talk.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<input type="hidden" value="<%= basePath %>" id="basePath"/>
<br/>
<div class="talk">
    <div class="talk_title"><span>正在与公众号对话</span></div>
    <div class="talk_record">
        <div id="jp-container" class="jp-container">

        </div>
    </div>

    <div class="talk_word">
        &nbsp;
        <input class="add_face" id="facial" type="button" title="添加表情" value=""/>
        <input id="command" class="messages emotion"/>
        <input class="talk_send" onclick="send();" type="button" title="发送" value="发送"/>
    </div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
</body>
</html>
