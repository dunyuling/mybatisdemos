﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" commandContent="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" commandContent="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title>内容列表页面</title>
    <input type="hidden" value="<%=basePath%>" id="basePath"/>
    <link href="<%=basePath %>css/all.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath%>js/command.js" type="text/javascript" charset="utf-8"></script>
</head>
<body style="background: #e1e9eb;">
<form action="<%=basePath %>command/list.do" id="mainForm" method="post">
    <div class="right">
        <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
        <div class="rightCont">
            <p class="g_title fix">内容列表
                <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="#" id="deleteBatch">删 除</a>
            </p>
            <table class="tab1">
                <tbody>
                <tr>
                    <td width="90" align="right">指令：</td>
                    <td>
                        <input name="name" type="text" class="allInput" value="${name}"/>
                    </td>
                    <td width="90" align="right">描述：</td>
                    <td>
                        <input name="description" type="text" class="allInput" value="${description}"/>
                    </td>
                    <td width="85" align="right"><input type="submit" class="tabSub" value="查 询"/></td>
                </tr>
                </tbody>
            </table>
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th><input type="checkbox" id="command_checkbox_all"/></th>
                        <th>序号</th>
                        <th>指令</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${commands}" var="command" varStatus="status">
                        <tr id="tr_${command.id}"
                            <c:if test="${status.index % 2 != 0}">style="background-color:#ECF6EE;"</c:if>>
                            <td><input id="command_checkbox_${command.id}" name="command_checkbox" type="checkbox" value="${command.id}"/></td>
                            <td>${status.index + 1}</td>
                            <td>${command.name}</td>
                            <td>${command.description}</td>
                            <td>
                                <a href="#" id="deleteOne_${command.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class='page fix'>
                    共 <b>${commands.size()}</b> 条
                    <a href='###' class='first'>首页</a>
                    <a href='###' class='pre'>上一页</a>
                    当前第<span>1/1</span>页
                    <a href='###' class='next'>下一页</a>
                    <a href='###' class='last'>末页</a>
                    跳至&nbsp;<input type='text' value='1' class='allInput w28'/>&nbsp;页&nbsp;
                    <a href='###' class='go'>GO</a>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>