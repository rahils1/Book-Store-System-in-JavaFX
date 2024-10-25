public class Book {
    private String title, condition, genres;
    //Note: genres is multiple genres that belong to the book, and separated with commas
    private double price;
    public Book() {
        title = condition = genres = "";
        price = 0.0;
    }

    public Book(String title, String condition, String genres, double price) {
        this.title = title;
        this.condition = condition;
        this.genres = genres;
    }
}
