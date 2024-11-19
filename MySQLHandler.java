import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/sparky_book_service";
    private static final String USER = "root";
    private static final String PASSWORD = "ENTER YOUR ROOT PASSWORD HERE";

    public static Connection getConnection() throws SQLException {return DriverManager.getConnection(URL, USER, PASSWORD);}
}
