package com.veinik.Lesson7.src.main.resources.univer.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost/univer";
    private static String user = "root";
    private static String pass = "root";

    private static Connection connection;

    public DBConnection() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            if(!connection.isClosed()){
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getDBConnection() {
        return connection;
    }

//    public void closeConnection(){
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}