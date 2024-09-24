<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: xuxc19
  Date: 2021/4/16
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%--
  内置对象
  在jsp页面中不需要创建，直接使用的对象有9个
      变量名               真实类型
  * pageContext           PageContext
  * request               HttpServletRequest
  * session               HttpSession
  * application           ServletContext
  * response              HttpServletResponse
  * page                  OBject
  * out                   jspWriter
  * config                ServletConfig
  * exception             Throwable
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<%@include file="top.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<html>
  <head>
    <title>home</title>
  </head>
  <body>
    <h3>主体信息</h3>
    <%
      response
    %>
  </body>
</html>
