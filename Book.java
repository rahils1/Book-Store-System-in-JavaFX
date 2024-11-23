public class Book {
    private int bookID;
    private String title, condition, genres, author;
    private double price;

    public Book(String title, String condition, String genres, String author, double price, int bookID) {
        this.title = title;
        this.condition = condition;
        this.genres = genres;
        this.author = author;
        this.price = price;
        this.bookID = bookID;
    }

    public String getTitle() {return title;
    }
    public String toString() {return title + " - " + String.format("%.2f",price) + " - " + author + " - " + condition + " - " + genres + " - Book ID:" + bookID;}
}