package sample;

import java.sql.*;


public class DbConnection {

 private Connection conn;


   public Connection getConnexion(){
       String url = "jdbc:mysql://127.0.0.1:3306/signup";
       String user = "root";
       String password = "";
    try{

        conn = DriverManager.getConnection(url,user,password);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return conn;
   }



//   public ResultSet CheckLogin( String a , String b){
//        DbConnection connectNow = new DbConnection();
//        Connection conn = connectNow.getConnexion();
//        ResultSet res = null;
//        String sqlVerified = "SELECT COUNT(1) FROM usersaccounts WHERE UserName = '" + a + "' AND Password = '" + b + "';";
//
//        try{
//            Statement stmt=conn.createStatement();
//           res = stmt.executeQuery(sqlVerified);
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//       return res;
 // }

}

