import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/sparky_book_service";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {connection = DriverManager.getConnection(URL, USER, PASSWORD);} catch (SQLException _) {}
        return connection;
    }
}
