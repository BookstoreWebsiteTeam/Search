package Servlet;

import Objects.Book;
import Objects.ImportSpreadsheet;
import Objects.Search;
import com.oracle.tools.packager.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;

/**
 * Created by Myles on 4/15/17.
 */
@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String param = request.getParameter("search");

        page = "/SearchResults.jsp";
        Book book;
        Search search = new Search();
        //Long isbn = Long.parseLong(param);
        //book = search.searchByISBN(isbn);

        File file = new File(param);

        //request.setAttribute("results", book);
        PrintWriter out = response.getWriter();
        out.println(file.isFile());
        out.println(param);
        //out.println(book.getBookName());
        //out.println("hello");


        //if(request.getAttribute())
        //getServletContext().getRequestDispatcher(page).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
