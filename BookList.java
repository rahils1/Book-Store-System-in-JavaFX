import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books;
    private ListView<Book> bookList;

    public BookList() {
        books = new ArrayList<Book>();
        bookList = new ListView<Book>();
    }

    public void setBookList() {bookList.setItems(FXCollections.observableList(books));}
}
