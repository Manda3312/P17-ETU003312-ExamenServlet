package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/ETU003309?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";  // Correct variable name casing
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // Confirm the connection
        System.out.println("Connected to database successfully!");

        return conn;
    }
}

