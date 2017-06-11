<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caosh
  Date: 2017/6/11
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="wonder" method="post">--%>
    <!--<h1 align="center">机构列表</h1>-->
    <tr><br><br></tr>
    <table align="center" border="0">
        <!--<tr>-->
        <!--<td colspan="2" align="center">-->
        <!--<input type="submit" value="学生">&nbsp;&nbsp;-->
        <!--<input type="button" value="审核班级" size="10" onclick="showNotAccessClasses()">-->
        <!--</td>-->
        <!--</tr>-->
        <tr><br><br></tr>
        <tr>
            <%--<a>${data.get(0).mName}</a>--%>
            <br>
            <a>影院名称</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>放映日期</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a>开始时间</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>结束时间</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a>格瓦拉场次</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>格瓦拉价格</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a>淘宝场次</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>淘宝价格</a>
            <br>
        </tr>

        <tr>
            <%--<a>${data.size()}</a>--%>
            <td><c:forEach items="${datalist}" var="list">
                <a>${list.cName}</a>&nbsp;
                <a>${list.date}</a>&nbsp;
                <a>${list.start}</a>&nbsp;
                <a>${list.end}</a>&nbsp;
                <a>${list.gewala_th}</a>&nbsp;
                <a><font color="red" size="10px">${list.gewala_price}</a>&nbsp;
                <a>${list.taobao_th}</a>&nbsp;
                <a><font color="red" size="10px">${list.taobao_price}</a>&nbsp;
                <%--机构名：${list.name}&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <br>
                <%--<h4>会员级别：${list.level}</h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--<h4></h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
            </c:forEach></td>

    </table>
<%--</form>--%>
</body>
</html>
