<%--
  Created by IntelliJ IDEA.
  User: Myles
  Date: 4/6/17
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriplet</title>
</head>
<body>
<%
    int age = 12;
    out.println("My age is: " + age);
%>

<%
    if(15 > 10)
    {
        out.println("15 is greater than 10");
    }
    out.println("<br/>");
    for (int i = 0; i < 10; i++) {
        out.println("<br/>");
        out.println("We love JSP" + i);
    }
%>
</body>
</html>
