package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://172.80.237.53/db_s2_ETU003312?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";  // Correct variable name casing
    private static final String PASSWORD = "hvs3CCHV";

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

