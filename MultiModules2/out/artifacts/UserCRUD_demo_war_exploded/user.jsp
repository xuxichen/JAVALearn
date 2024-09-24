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

    <title>用户信息管理系统</title>
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
        text-align: center;
      }
    </style>
    <script type="text/javascript">

      function delUser(id) {
        if (confirm("您确定要删除吗？")) {
          location.href = "${pageContext.request.contextPath}/userdelete?id="+id;
        }
      }

      function delSelectUser() {
        if(confirm("您确定要删除选中条目吗？")){
          var flag = false;
          //判断是否有选中条目
          var cbs = document.getElementsByName("uid");
          for (var i = 0; i < cbs.length; i++) {
            if(cbs[i].checked){
              //有一个条目选中了
              flag = true;
              break;
            }
          }

          if(flag){//有条目被选中
            //表单提交
            document.getElementById("form").submit();
          }
        }
      }
      function selectAll() {
        //2.获取下边列表中所有的cb
        var cbs = document.getElementsByName("uid");
        //3.遍历
        for (var i = 0; i < cbs.length; i++) {
          //4.设置这些cbs[i]的checked状态 = headcheck.checked
          cbs[i].checked = document.getElementById("headcheck").checked;
        }
      }
    </script>
  </head>
  <body>
  <div class="container">
    <h1 align="center">用户信息列表</h1>

    <div style="float: left;">
      <form class="form-inline" action="${pageContext.request.contextPath}/userList" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="page" value="1">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="pageSize" value=6>

        <div class="form-group">
          <label for="exampleInputName2">姓名</label>
          <input type="text"name="name" class="form-control" id="exampleInputName2" placeholder="李四" value="${name}">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail2">籍贯</label>
          <input type="text" name="address" class="form-control" id="exampleInputaddressl2" placeholder="广州" value="${address}">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail2">邮箱</label>
          <input type="email" name="email" class="form-control" id="exampleInputEmail2" placeholder="lisi@126.com" value="${email}">
        </div>
        <button type="submit" class="btn btn-default">查阅</button>
      </form>
    </div>
    <div style="float: right; margin: 5px">
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/adduser.jsp">添加联系人</a>
      <button class="btn btn-primary" onclick="delSelectUser()">删除选中</button>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/userdelselect" method="post">
    <table border="1" class="table table-bordered table-hover">
      <tr class="success">
        <th><input type="checkbox" id="headcheck" onclick="selectAll()"></th>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>籍贯</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
          <th><input type="checkbox" name="uid" value="${user.id}"></th>
          <td>${currentPage*6 + status.count}</td>
          <td>${user.name}</td>
          <td>${user.gender}</td>
          <td>${user.age}</td>
          <td>${user.address}</td>
          <td>${user.qq}</td>
          <td>${user.email}</td>
          <td>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/userfind?id=${user.id}">修改</a>&nbsp;
            <a class="btn btn-default btn-sm" href="javascript:delUser(${user.id});">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    </form>
    <nav aria-label="Page navigation">
      <ul class="pagination">
        <c:if test="${currentPage>1}">
          <li>
            <a href="${pageContext.request.contextPath}/userList?page=${currentPage-1}&pageSize=6&email=${email}&name=${name}&address=${address}" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
        </c:if>

        <c:forEach begin="1" end="${totalPage}" varStatus="s">
          <li <c:if test="${currentPage==s.index}">class="active"</c:if> ><a href="${pageContext.request.contextPath}/userList?page=${s.index}&pageSize=6&email=${email}&name=${name}&address=${address}">${s.index}</a></li>
        </c:forEach>
        <c:if test="${currentPage<totalPage-1}">
          <li>
            <a href="${pageContext.request.contextPath}/userList?page=${currentPage+1}&pageSize=6&email=${email}&name=${name}&address=${address}" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </c:if>

        <span style="font-size: 25px; margin-left: 10px">
            共${userNumber}条记录， 共${totalPage}页
        </span>
      </ul>
    </nav>
    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissable" role="alert">
      <button type="button" class="close" data-dismiss="alert">
        <span></span>
      </button>
      <strong>${deletefailId} current ${currentPage}</strong>
    </div>
  </div>
  </body>
</html>
