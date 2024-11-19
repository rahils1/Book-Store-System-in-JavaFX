public class Book {
    private int bookid;
    private String title, condition, genres, author;
    private double price;

    public Book() {
        title = condition = genres = author = "";
        price = 0.0;
    }

    public Book(String title, String condition, String genres, String author, double price) {
        this.title = title;
        this.condition = condition;
        this.genres = genres;
        this.author = author;
        this.price = price;
    }

    public String toString() {return title + " - " + String.format("%.2f",price) + " - " + author;}
}