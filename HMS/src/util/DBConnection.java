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

    public static void main(String[] args) {
        try (Connection testConnection = getConnection()) {
            if (testConnection != null) {
                System.out.println("Database connection successful!");

                // Example of another query start
                String query1 = "SELECT * FROM Patient ";
                try (Statement statement = testConnection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query1)) {

                    System.out.println("Patient Details are as follows:");

                    // Process the result set
                    while (resultSet.next()) {
                        // Access the data from the result set
                        int column1 = resultSet.getInt("patientID");
                        String column2 = resultSet.getString("firstName");
                        String column3 = resultSet.getString("lastName");
                        // Process the data as needed
                        System.out.println("Patient ID: " + column1 + ", FirstName: " + column2 + ", LastsName: " + column3);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // Example of another query start
                //NOTE : All query condition will come under if (testConnection != null) as this is main if condtion in which
                // our Database connection successful! message is printed
            }

            // If nothing works inside main if condition then print this below else statement
            else {
                System.out.println("Failed to establish a database connection.");
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }
    }
}
