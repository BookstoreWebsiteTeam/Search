<%--
  Created by IntelliJ IDEA.
  User: Myles
  Date: 4/15/17
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <form name="searchForm" action="/Controller" method="post">
		<input name="search" type="text" value="" size="50"/>
        <input type="submit" name="Click" value="Submit" >

	</form>
	<a href="/Controller?page=SearchResults"> Search Results</a>
</body>
</html>
