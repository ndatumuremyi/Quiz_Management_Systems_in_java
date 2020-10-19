/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes.Project;
import java.sql.*;
import static java.lang.Class.forName;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kwizera
 */
public class Connections {
    public static Connection getcon(){
        
    try{
       Class.forName("com.mysql.jdbc.Driver");

        Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Quiz_Management_System","root","");
        return conn;
    }   catch (Exception ex) {
           return null;
        }
    
    }
    
}
