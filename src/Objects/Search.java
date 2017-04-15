package Objects;
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

    public Book searchByISBN(Long isbn)
    {
        File file = new File("books.csv");
        books.setBookSpreadsheet(file);
        ArrayList<Book> bookList = books.importSpreadSheet();
        isbnList = books.importToISBNList();
        Book book = isbnList.get(isbn);
        return book;
    }

    public ArrayList<Book> searchByCourseNumber(int crn)
    {
        File file = new File("books.csv");
        books.setBookSpreadsheet(file);
        books.importSpreadSheet();
        courseList = books.importToCourseList();
        ArrayList<Book> books = courseList.get(crn);
        return books;
    }

    public Book serverSearch(String isbn)
    {
        Long isbn1 = Long.parseLong(isbn);
        Book book = searchByISBN(isbn1);
        return book;
    }

    public TreeMap<String, Book> searchByTitle(String search)
    {
        File file = new File("books.csv");
        books.setBookSpreadsheet(file);
        books.importSpreadSheet();
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

    public static void main(String[] args) {
        Search search = new Search();
        TreeMap<String, Book> titleList = search.searchByTitle("agift");
        Set set = titleList.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.println("key is: " + mentry.getKey() /*+ " & Value is: " + mentry.getValue()*/);
        }
    }

}
