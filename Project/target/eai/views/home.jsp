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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Examples</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link href="" rel="stylesheet">
    <style type="text/css">
        #box{
            width: 550px;
            margin: 30px auto;
            font-family: 'Microsoft YaHei';
            font-size: 14px;
            /*text-align: center;*/
        }
        input{
            margin-left: 30px;
            width: 390px;
            border: 1px solid #e2e2e2;
            height: 40px;
            float: left;
            /*background-image: url(images/search.jpg);*/
            background-repeat: no-repeat;
            background-size: 25px;
            background-position:5px center;
            padding:0 0 0 20px;
        }
        #search{
            width: 85px;
            height: 40px;
            float: left;
            background: black;
            color: white;
            text-align: center;
            line-height: 39px;
            cursor: pointer;
        }

        #head_image{
            /*margin-left: 630px;*/
            margin-top: 70px;
            text-align: center;
        }

        #film_list{
            margin-top: 18px;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="head_image">
    <img src="../resources/icons/film.png" width="180" height="180"/>
</div>

<div id="box">
    <input type="text" name="search" placeholder="请输入关键字">
    <div id="search">搜索</div>
</div>
<br>
<br>

<div id="film_list">
    <a id="wonder" href="/movie/getPlan.html?movieName=神奇女侠">神奇女侠</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a id="pirates" href="/movie/getPlan.html?movieName=加勒比海盗5：死无对证">加勒比海盗5：死无对证</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a id="mummy" href="/movie/getPlan.html?movieName=新木乃伊">新木乃伊</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <!--<a href="">摔跤吧！爸爸</a>&nbsp;&nbsp;&nbsp;-->
<%--<a>aaaaaaa</a>--%>
</div>

<script>
//    function wonder() {
//        window.location.href = "wonder";
//    }
</script>
</body>
</html>
