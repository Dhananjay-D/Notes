//Write a Java program to search and display details of book(s) authored by a
//particular author from a “BOOKS” table. Assume an appropriate structure and attributes for
//the table.
//
//The task involves creating a Java program to search and display details of books
//authored by a specific author from a "BOOKS" table, assuming an appropriate structure and
//attributes for the table.
//
//The Java program utilizes JDBC (Java Database Connectivity) to interact with the database.
//It begins by establishing a connection to the database using the DriverManager class. The
//assumed "BOOKS" table likely includes fields such as bookID, title, author, publisher, and
//publicationYear.The program constructs a SQL query to retrieve book details based on the
// specified author. It utilizes a PreparedStatement to safely set the author parameter in the
//query. Upon execution, the ResultSet is processed to retrieve and display book details,
//including book ID, title, author, publisher, and publication year.

import java.sql.*;
import java.util.Scanner;

public class TW8 {
    public static void main(String[] args) {
        String JDBCurl = "jdbc:mysql://localhost:3306/tw8_maargale";
        String username = "root";
        String password = "Ganes@h123";

        try (Scanner sc = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(JDBCurl, username, password)) {

            System.out.println("Enter the author name:");
            String author = sc.nextLine();

            String selectQuery = "SELECT book_name, author_name FROM books WHERE author_name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, author);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("author_name") + " and " + resultSet.getString("book_name"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


//    MYSQL code to create database :
//create database tw8_maargale;
//        use tw8_margale
//        CREATE TABLE books (
//        book_name VARCHAR(255),
//        author_name VARCHAR(255)
//        );
//        insert into books values("G1","Ganesh");
//        insert into books values("D1","Ganesh");
//        insert into books values("G2","Ganesh");