package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
    private static Connection conn = null;

    private DBConnection() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        } else {
            try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
                if (input == null) {
                    System.out.println("Sorry, unable to find db.properties");
                    return null;
                }

                // load a properties file from class path, inside static method
                Properties prop = new Properties();
                prop.load(input);

                // get the property value and connect to the database
                String url = prop.getProperty("jdbc:mysql://localhost:3306/?user=root");
                String username = prop.getProperty("root");
                String password = prop.getProperty("Haswanth");

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root","root", "Haswanth@123");

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

            return conn;
        }
    }

}
