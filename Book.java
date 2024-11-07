import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class Book {
    private String title, condition, genres, author;
    //Note: genres is multiple genres that belong to the book, and separated with commas
    private double price;
    private Image bookImg;
    private Button imgButton;

    public Book() {
        title = condition = genres = author = "";
        price = 0.0;
        imgButton = new Button("Picture");
        imgButton.setOnAction(e->showImage());
    }

    public Book(String title, String condition, String genres, String author, double price) {
        this.title = title;
        this.condition = condition;
        this.genres = genres;
        this.author = author;
    }

    //TODO: Implement show image function
    private void showImage() {}

    public String toString() {
        return title + " - " + String.format("%.2f",price) + " - " + author;
    }
}