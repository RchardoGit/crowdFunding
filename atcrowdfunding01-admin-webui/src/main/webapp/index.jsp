<%--
  Created by IntelliJ IDEA.
  User: 孔令阳
  Date: 2021/12/5
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>搭建环境，测试页面</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="static/jquery/jquery-3.1.0.js"></script>
    <script src="static/layer/layer.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#btn01").click(function () {

                $.ajax({
                    "url": "send/array.html",
                    "type": "post",
                    "data": {
                        "array":[5,12,8]
                    },
                    "dataType":"text",

                    "success":function(response) {
                        console.log(response);
                    },
                    "error":function (response){
                        console.log(response);
                    }
                });
            });

            $("#btn02").click(function () {
                var student = [5,12,8];
                var studentString = JSON.stringify(student);
                $.ajax({
                    "url": "send/two.html",
                    "type": "post",
                    "data": studentString,
                    "dataType":"text",
                    "contentType":"application/json;charset=UTF-8",
                    "success":function(response) {
                       console.log(response);
                    },
                    "error":function (response){
                        console.log(response);
                    }
                });
            });

            $("#btn03").click(function () {

               layer.msg("layer弹窗");
            });
        });
    </script>
</head>
<body>
    <h1>测试</h1>
    <a href="test/ssm.html">测试SSM整合环境</a>
    <br/>
    <br/>
    <button id="btn01" >testJson</button>
    <br/>
    <br/>
    <button id="btn02" >testJson</button>
    <br/>
    <br/>
    <button id="btn03" >layer弹窗</button>
</body>
</html>
