<%@ page import="Objects.Search" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Objects.Book" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ObjectInputStream" %>
<%@ page import="java.io.File" %>
<%@ page import="Objects.ObjectIO" %>
<%@ page import="Objects.BooksDatabase" %><%--
  Created by IntelliJ IDEA.
  User: Myles
  Date: 4/15/17
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookstore Homepage</title>
</head>
<body>

	<img src="Kennesaw_State_University.png" width="200" height="100">
    <form name="searchForm" action="/Controller" method="post">
		<input name="search" type="text" value="" size="50"/>
        <input type="submit" name="Click" value="Submit" >

	</form>
	</br>
	<%
		try {
			InputStream in = application.getResourceAsStream("/WEB-INF/books.bks");

			ObjectInputStream object = new ObjectInputStream(in);
			ArrayList<Book> books =  (ArrayList<Book>) object.readObject();

			File file = new File("books1.bks");
			BooksDatabase booksDatabase = new BooksDatabase(file);
			ArrayList<Book> books1 = booksDatabase.getBooks();
			for (int i = 0; i < books1.size(); i++) {
				out.println(books1.get(i).getIsbn());
			}


		}
		catch (NullPointerException ex)
		{
		    out.println(ex.getMessage());
		}
	%>
	
	<a href="/Controller?page=SearchResults"> Search Results</a>
</body>
</html>
