<%--
  Created by IntelliJ IDEA.
  User: 孔令阳
  Date: 2021/12/5
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/login.css">
    <script src="static/jquery/jquery-3.1.0.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <script src="static/layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                // 返回上一步
                window.history.back();
            });
        });
    </script>
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container" align="center">
    <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 尚筹网系统信息</h2>
    <h3>${requestScope.exception.message}</h3>
    <button id="btn" style="width: 150px" class="btn btn-md btn-success btn-block">点击返回上一步</button>
</div>

</body>
</html>