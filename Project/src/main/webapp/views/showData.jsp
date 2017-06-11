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
            <td><c:forEach items="${data}" var="list">
                <a>${list.toString()}
                <%--机构名：${list.name}&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <br>
                <%--<h4>会员级别：${list.level}</h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--<h4></h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
            </c:forEach></td>

    </table>
<%--</form>--%>
</body>
</html>
