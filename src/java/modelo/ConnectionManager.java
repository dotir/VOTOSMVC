/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LAB-USR-CAQP-C0203
 */
public class ConnectionManager {
    private static String url="jdbc:mysql://localhost/mvcVoto";
    private static String user="root";
    private static String password="";
    private static Connection conn;

    public static Connection getConn() {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("Conected");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
}
