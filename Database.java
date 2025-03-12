import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // JDBC URL, username, and password for your database
    private static final String URL = "jdbc:mysql://localhost:3306/javaTest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "MySql1234";

    // Static method to get a database connection
    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected successfully to the database.");
            return connection;
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return null;
        }
    }
}
