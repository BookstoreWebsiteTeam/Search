<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expressions</title>
</head>
    <body>
        <%= new java.util.Date() %>
        <br/></br>
        <%= 25 * 10%>
        <br/></br>
        Is 25 greater than 50? <%= 25 > 50%>

        <%
            if(25 > 50)
                    {
                        out.println("hi");
                    }
            else
                    {
                        out.println("false");
                    }
        %>
    </body>
</html>