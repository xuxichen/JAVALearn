<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jstl.domain.user" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: xuxc19
  Date: 2021/4/16
  Time: 下午7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <%
        ArrayList<user> users = new ArrayList<user>();
        users.add(new user("张三", 29, new Date(92, 3, 23)));
        users.add(new user("李四", 24, new Date(97, 5, 03)));
        request.setAttribute("list", users);
    %>

    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>出生日期</th>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <c:if test="${status.index/2==0}">
                <tr style="background-color: green">
                    <td>${status.index}</td>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.birStr}</td>
                </tr>
            </c:if>
            <c:if test="${status.index%2!=0}">
                <tr style="background-color: red">
                    <td>${status.index}</td>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.birStr}</td>
                </tr>
            </c:if>
        </c:forEach>

    </table>
</body>
</html>
