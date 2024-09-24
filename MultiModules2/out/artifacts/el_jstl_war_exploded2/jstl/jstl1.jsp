<%@ page import="java.util.ArrayList" %><%--
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
    <title>jstl标签</title>
</head>
<body>

<%--
    c:if 标签
        1、属性。
            *test 必须属性 接受布尔表达式
            *如果表达式为true，则显示if标签体内容


--%>
    <c:if test="true">
        我是真
    </c:if>

    <%
        ArrayList<String> strings = new ArrayList<>();
        strings.add("adds");
        strings.add("cdsd");
        request.setAttribute("list", strings);
    %>
    <c:if test="${not empty list}">
        <c:forEach items="${list}" var="ite">
            <h1>${ite}</h1>
        </c:forEach>
    </c:if>

    <%
        request.setAttribute("number", 4);
    %>
    <c:choose>
        <c:when test="${number == 4}">
            <h1>这是第四个</h1>
        </c:when>
        <c:otherwise>
            <h1>这是其他</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
