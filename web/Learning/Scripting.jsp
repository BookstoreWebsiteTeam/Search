<%--
  Created by IntelliJ IDEA.
  User: Myles
  Date: 4/7/17
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scripting</title>
</head>
<body>

<%
    for (int i = 0; i < 10; i++) {
        out.println(i);
    %>
        <strong>Hello</strong>
        <br/>
    <%
            if(i != 5)
            {
                out.println("<strong>Hello</strong><br/>");
            }
            else
            {
                out.println("<strong>Hello World</strong><br/>");
            }
    }

%>
</body>
</html>
