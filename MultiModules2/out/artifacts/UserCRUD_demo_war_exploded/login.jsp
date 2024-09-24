<%--
  Created by IntelliJ IDEA.
  User: xuxc19
  Date: 2021/4/20
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登陆</title>

    <%--1、导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->

    <%--    2、jQuery导入--%>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.6.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">

    </style>
    <script type="text/javascript">
        // 切换验证码
        function refreshCode() {
            var vcodeimg = document.getElementById('vcode');
            vcodeimg.src = "${pageContext.request.contextPath}/CheckCodeServlet?time=" + new Date().getTime()
        }
        window.onload = function () {

        }

    </script>
</head>
<body>
<div class="container" style="width: 500px;">

    <h1 align="center">管理员登陆</h1>

    <form action="${pageContext.request.contextPath}/loginServlet" method="post" style="align-items: center">
        <div class="form-group">
            <label for="exampleInputEmail1">用户名</label>
            <input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
        </div>
        <div class="form-inline">
            <label for="exampleInputCheckCode">验证码</label>
            <input type="text" name="checkcode" class="form-control" id="exampleInputCheckCode" placeholder="请输入验证码" style="width: 150px;">
            <a href="javascript:refreshCode();">
                <img id="vcode" title="看不清请刷新" src="${pageContext.request.contextPath}/CheckCodeServlet">
            </a>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> 记住我
            </label>
        </div>
        <div class="form-group" style="text-align: center;">
            <input  type="submit" class="btn btn-primary" value="登陆">
        </div>

    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissable" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span></span>
        </button>
        <strong>${login_msg != null?login_msg:cc_error}</strong>
    </div>
</div>
</body>
</html>
