<%@ page import="Objects.Book" %><%--
  Created by IntelliJ IDEA.
  User: Myles
  Date: 4/15/17
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
    <%

        //Book book1 = (Book)request.getAttribute("name");
        //Book book = (Book)session.getAttribute("name");
        //out.println(book1.getBookName());
        Book searchResults = (Book)request.getAttribute("results");
        out.println(searchResults.toString());
    %>

</body>
</html>
