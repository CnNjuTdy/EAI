<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caosh
  Date: 2017/6/11
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link id="bs-css" href="../css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="../css/charisma-app.css" rel="stylesheet">
    <link href='../bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='../bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='../bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='../bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='../bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='../bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='../css/jquery.noty.css' rel='stylesheet'>
    <link href='../css/noty_theme_default.css' rel='stylesheet'>
    <link href='../css/elfinder.min.css' rel='stylesheet'>
    <link href='../css/elfinder.theme.css' rel='stylesheet'>
    <link href='../css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='../css/uploadify.css' rel='stylesheet'>
    <link href='../css/animate.min.css' rel='stylesheet'>
</head>
<body>
<%--<form action="wonder" method="post">--%>
<!--<h1 align="center">机构列表</h1>-->
<%--<tr></tr>--%>
<h3 align="center">${datalist.get(0).mName}</h3>
<table class="table table-striped table-bordered responsive">
    <!--<tr>-->
    <!--<td colspan="2" align="center">-->
    <!--<input type="submit" value="学生">&nbsp;&nbsp;-->
    <!--<input type="button" value="审核班级" size="10" onclick="showNotAccessClasses()">-->
    <!--</td>-->
    <!--</tr>-->

    <tr>

        <%--<a>${data.get(0).mName}</a>--%>
        <th class="center">影院名称</th>
        <th class="center">放映日期</th>
        <th class="center">开始时间</th>
        <th class="center">结束时间</th>
        <th class="center">格瓦拉场次</th>
        <th class="center">格瓦拉价格</th>
        <th class="center">淘宝场次</th>
        <th class="center">淘宝价格</th>


    </tr>



    <%--<a>${data.size()}</a>--%>
    <%--<%! int i=0 %>--%>
    <c:forEach items="${datalist}" var="list">
        <tr class="center">
            <td class="center">${list.cName}</td>
            <td class="center">${list.date}</td>
            <td class="center">${list.start}</td>
            <td class="center">${list.end}</td>
            <td class="center">${list.gewala_th}</td>
            <td class="center">
                <c:if test="${list.gewala_price==-1}">
                    无
                </c:if>
                <c:if test="${list.gewala_price!=-1}">
                    ${list.gewala_price}
                </c:if>
            </td>
            <td class="center">${list.taobao_th}</td>
            <td class="center"> <c:if test="${list.taobao_price==-1}">
                无
            </c:if>
                <c:if test="${list.taobao_price!=-1}">
                    ${list.taobao_price}
                </c:if></td>
                <%--机构名：${list.name}&nbsp;&nbsp;&nbsp;&nbsp;--%>

                <%--<h4>会员级别：${list.level}</h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--<h4></h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
        </tr>
    </c:forEach>


</table>


<%--<table class="table table-striped table-bordered responsive">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th class="center">会员ID</th>--%>
<%--<th class="center">会员名称</th>--%>
<%--<th class="center">会员等级</th>--%>
<%--<th class="center">会员余额</th>--%>
<%--<th class="center">查看账单</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>


<%--<s:iterator id="item" value="memberList">--%>
<%--<tr><form action="HotelManager.action">--%>
<%--<td class="center"> <s:property value="#item.mid"></s:property></td>--%>
<%--<td class="center"><s:property value="#item.name"></s:property></td>--%>
<%--<td class="center"><s:property value="#item.level"></s:property></td>--%>
<%--<td class="center"><s:property value="#item.balance"></s:property></td>--%>
<%--<input type="hidden" name="member.mid" value=<s:property value='#item.mid'/>>--%>
<%--<td class="center"> <s:submit value="查看账单" cssClass="btn btn-default" method="ShowSingleMember"></s:submit></td>--%>
<%--</form>--%>
<%--</tr>--%>


<%--</s:iterator>--%>






<%--</tbody>--%>
<%--</table>--%>


<%--</form>--%>
</body>
</html>
