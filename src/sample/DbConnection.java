package sample;

import java.sql.*;


public class DbConnection {

 private Connection conn;


   public Connection getConnexion(){
       String url = "jdbc:mysql://127.0.0.1:3306/signup";
       String user = "root";
       String password = "AhmadAhmad1";
    try{

        conn = DriverManager.getConnection(url,user,password);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return conn;
   }

}

