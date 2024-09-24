<%--
  Created by IntelliJ IDEA.
  User: xuxc19
  Date: 2021/4/19
  Time: 下午3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>添加联系人</title>
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

      td th{
        align-items: center;
        text-align: center;
      }
    </style>
  </head>
  <body>
  <div class="container">
    <h1 align="center">修改用户信息</h1>

    <form action="${pageContext.request.contextPath}/userupdate" method="post">

      <!--  隐藏域 提交id-->
      <input type="hidden" name="id" value="${user.id}">

      <div class="form-group">
        <label for="name">姓名</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" value="${user.name}">
      </div>
      <div class="form-group">
        <label>性别</label>
        <input type="radio" name="gender" value="男" <c:if test="${user.gender == '男'}">checked='checked'</c:if> > 男
        <input type="radio" name="gender" value="女" <c:if test="${user.gender == '女'}">checked='checked'</c:if> > 女
      </div>
      <div class="form-group">
        <label for="age">年龄</label>
        <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" value="${user.age}">
      </div>
      <div class="form-group">
        <label for="address">籍贯</label>
        <select name="address" id="address" class="form-control" >
          <option value="陕西" <c:if test="${'陕西' == user.address}">selected</c:if> >陕西</option>
          <option value="北京" <c:if test="${'北京' == user.address}">selected</c:if> >北京</option>
          <option value="上海" <c:if test="${'上海' == user.address}">selected</c:if> >上海</option>
          <option value="广州" <c:if test="${'广州' == user.address}">selected</c:if> >广州</option>
          <option value="汕头" <c:if test="${'汕头' == user.address}">selected</c:if> >汕头</option>
        </select>

      </div>
      <div class="form-group">
        <label for="qq">QQ</label>
        <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ" value="${user.qq}">
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱" value="${user.email}">
      </div>
      <div class="form-inline" style="text-align: center;">
        <input class="btn btn-primary" type="submit" value="提交" style="margin: 15px;">
        <input class="btn btn-default" type="reset" value="重置" style="margin: 15px;">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/userList?page=1&pageSize=6" style="margin: 15px;">返回</a>
      </div>
    </form>

  </div>
  </body>
</html>
