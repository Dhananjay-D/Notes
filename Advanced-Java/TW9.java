//  Program to demonstrate transaction processing. Assume an appropriate database/table

package tw9;

import java.sql.*;
public class TW9 {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            
            connection.setAutoCommit(false);

            try {
                
                Savepoint savepoint = connection.setSavepoint();

                
                insertTransaction(connection, 1, 100);
                insertTransaction(connection, 2, 200);

               
                connection.commit();
                System.out.println("Transaction committed successfully.");

                
                Savepoint savepoint2 = connection.setSavepoint();

                
                insertTransaction(connection, 3, 300);
                insertTransaction(connection, 4, 400);

                
                connection.rollback(savepoint2);
                System.out.println("Rollback to Savepoint 2.");

                
                connection.commit();
                System.out.println("Transaction committed after rollback.");

            } catch (SQLException e) {
                
                connection.rollback();
                System.err.println("Transaction rolled back due to an exception.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertTransaction(Connection connection, int id, int amount) throws SQLException {
        String insertQuery = "INSERT INTO transactions (id, amount) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, amount);
            preparedStatement.executeUpdate();
            System.out.println("Inserted transaction with id=" + id + " and amount=" + amount);
        }
    }
    
}


//MYsql code  :
//create database java9;
//
//        use java9;
//
//        CREATE TABLE data(
//        ID INT,
//        AMT INT
//        )
//
//        select * from data;