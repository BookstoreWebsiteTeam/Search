<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Myles
  Date: 4/15/17
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parameter</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        out.println(name);
    %>
</body>
</html>
