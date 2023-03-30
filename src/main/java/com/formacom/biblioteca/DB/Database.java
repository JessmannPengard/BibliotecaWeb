package com.formacom.biblioteca.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String password = "";

        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}