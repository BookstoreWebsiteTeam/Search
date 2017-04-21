package Objects;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Myles on 3/29/17.
 */
public class ObjectIO {

    private File objectFile;
    private Object object;

    public ObjectIO(File objectFile) {
        this.objectFile = objectFile;
    }

    public File getObjectFile() {
        return objectFile;
    }

    public void setObjectFile(File objectFile) {
        this.objectFile = objectFile;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void writeObject(Object object) {
        OutputStream file = null;
        try {
            file = new FileOutputStream(getObjectFile());
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(object);
            } finally {
                output.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObject() {
        //use buffering
        Object object = new Object();
        try {
            InputStream file = new FileInputStream(getObjectFile());
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            //deserialize the List
            try {
                object = input.readObject();
            } finally {
                input.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public ArrayList<Book> reimport()
    {
        ObjectIO objectIO = new ObjectIO(new File("books.bks"));
        ArrayList<Book> readBooks = (ArrayList<Book>) objectIO.readObject();
        return readBooks;
    }

    public OutputStream inputToOutput(InputStream in) throws IOException {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };
        IOUtils.copy(in, out);
        return out;
    }

    public static void main(String[] args) {
        ImportSpreadsheet importBooks = new ImportSpreadsheet(new File("books.csv"));
        ArrayList<Book> bookArrayList = importBooks.importSpreadSheet();
        ObjectIO objectIO = new ObjectIO(new File("books.bks"));
        objectIO.writeObject(bookArrayList);
        ArrayList<Book> readBooks = (ArrayList<Book>) objectIO.readObject();
        /*for (int i = 0; i < readBooks.size(); i++) {
            for (int j = 0; j < readBooks.get(i).getAuthor().length; j++) {
                System.out.println("Author: " + readBooks.get(i).getAuthor()[j].toString() + " ");
            }
            //System.out.println();
        }*/
    }
}
