import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        Connection connection = Database.getConnection();

        if (connection != null) {
            try {

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT 'Hello, " + name + "!' AS Greeting");

                if (resultSet.next()) {
                    System.out.println(resultSet.getString("Greeting"));
                }

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection to the database failed.");
        }
        scanner.close();
    }
}