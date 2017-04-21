package Objects;
import Exceptions.BookNotFoundException;
import com.sun.tools.javac.util.ArrayUtils;

import java.io.File;
import java.util.*;

/**
 * Created by Myles on 3/29/17.
 */
public class Search {

    private ImportSpreadsheet books = new ImportSpreadsheet();
    private TreeMap<Long, Book> isbnList;
    private TreeMap<Integer, ArrayList<Book>> courseList;
    private TreeMap<String, Book> titleList;

    public Search() {
    }

    public Book searchByISBN(Long isbn) {
        File file = new File("books.bks");
        BooksDatabase booksDatabase = new BooksDatabase(file);
        //books.setBookSpreadsheet(file);
        books.setBookList(booksDatabase.getBooks());
        isbnList = books.importToISBNList();
        Book book = isbnList.get(isbn);
        return book;
    }


    public ArrayList<Book> searchByCourseNumber(int crn) {
        File file = new File("books.bks");
        BooksDatabase booksDatabase = new BooksDatabase(file);
        books.setBookList(booksDatabase.getBooks());
        courseList = books.importToCourseList();
        ArrayList<Book> books = courseList.get(crn);
        return books;
    }

    public Book serverSearch(String isbn) {
        Long isbn1 = Long.parseLong(isbn);
        Book book = searchByISBN(isbn1);
        return book;
    }

    public TreeMap<String, Book> searchByTitle(String search)
    {
        File file = new File("books.bks");
        BooksDatabase booksDatabase = new BooksDatabase(file);
        books.setBookList(booksDatabase.getBooks());
        titleList = books.importToTitleList();
        TreeMap<String, Book> searchResults = new TreeMap<>();
        Set set = titleList.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            //System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            if(mentry.getKey().toString().toLowerCase().contains(search.toLowerCase()))
            {
                searchResults.put((String) mentry.getKey(), (Book)mentry.getValue());
            }
        }

        return searchResults;
    }

    public ArrayList<Book> populateKeywordSearch(String message)
    {
        ArrayList<Book> searchResults = new ArrayList<>();
        TreeMap<String, Book> titles = searchByTitle(message);
        boolean isDigit = true;
        char[] chars = message.toCharArray();
        Character[] isbnconvert = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            isbnconvert[i] = new Character(chars[i]);
        }

        for (int i = 0; i < isbnconvert.length; i++) {
            if(!Character.isDigit(isbnconvert[i]))
            {
                isDigit = false;
            }
        }
        if (isDigit) {
            Book book = searchByISBN(Long.parseLong(message));
            searchResults.add(book);
        }
        Set set = titles.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            searchResults.add((Book) mentry.getValue());
        }

        searchResults = deleteDuplicates(searchResults);
        return searchResults;
    }

    public ArrayList<Book> deleteDuplicates(ArrayList<Book> books)
    {
        TreeMap<Long, Book> check = new TreeMap<>();
        ArrayList<Book> results = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            check.put(books.get(i).getIsbn(), books.get(i));
        }
        Set set = check.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator.next();
            Book book = (Book) entry.getValue();
            results.add(book);
        }
        return results;
    }

    public static void main(String[] args) {
        Search search = new Search();
        /*TreeMap<String, Book> titleList = search.searchByTitle("agift");
        Set set = titleList.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.println("key is: " + mentry.getKey() + " & Value is: " + mentry.getValue());
        }*/
        /*Book book = search.searchByISBN(9780132492676L);
        System.out.println(book.getBookName());
        BooksDatabase booksDatabase = new BooksDatabase(new File("books.bks"));
        book.setBookName("123");
        booksDatabase.deleteBook(book);
        book = search.searchByISBN(9780132492676L);
        System.out.println(book.getBookName());*/



        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIsbn());
        }*/


    }

}
