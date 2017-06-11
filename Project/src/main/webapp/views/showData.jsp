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
</head>
<body>
<%--<form action="wonder" method="post">--%>
    <!--<h1 align="center">机构列表</h1>-->
    <%--<tr></tr>--%>
    <table align="center" border="0">
        <!--<tr>-->
        <!--<td colspan="2" align="center">-->
        <!--<input type="submit" value="学生">&nbsp;&nbsp;-->
        <!--<input type="button" value="审核班级" size="10" onclick="showNotAccessClasses()">-->
        <!--</td>-->
        <!--</tr>-->
        <tr><td style="font-weight:bold;text-align: center;font-size: large">
        ${datalist.get(0).mName}<br>
        </td>
        </tr>
        <tr>
            <td style="font-weight:bold;text-align: center">
            <%--<a>${data.get(0).mName}</a>--%>
            <a>影院名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>放映日期&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a>开始时间</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>结束时间</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a>格瓦拉场次</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>格瓦拉价格</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a>淘宝场次</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>淘宝价格</a>
            <br>
            </td>
        </tr>

        <tr>
            <td>
            <%--<a>${data.size()}</a>--%>
                <%--<%! int i=0 %>--%>
                <c:forEach items="${datalist}" var="list">
                <a>${list.cName}</a>
                    <c:if test="${list.cName=='UME国际影城(玄武门店)'}">
                        &nbsp;
                    </c:if>
                    <c:if test="${list.cName=='金逸影城(大观店)'}">
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${list.cName=='卢米埃影城(紫峰店)'}">
                        &nbsp;&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${list.cName=='和平影视娱乐城'}">
                        &nbsp;&nbsp;&nbsp;
                    </c:if>

                <a>${list.date}&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>${list.start}&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>${list.end}&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>${list.gewala_th}&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>
                    <c:if test="${list.gewala_price==-1}">
                        无&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                    <c:if test="${list.gewala_price!=-1}">
                        ${list.gewala_price}&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:if>
               </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a>${list.taobao_th}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a> <c:if test="${list.taobao_price==-1}">
                    无&nbsp;&nbsp;&nbsp;&nbsp;
                </c:if>
                    <c:if test="${list.taobao_price!=-1}">
                        ${list.taobao_price}
                    </c:if></a>
                <%--机构名：${list.name}&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <br>
                <%--<h4>会员级别：${list.level}</h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--<h4></h4>&nbsp;&nbsp;&nbsp;&nbsp;--%>
            </c:forEach>
            </td>
        </tr>
    </table>
<%--</form>--%>
</body>
</html>
