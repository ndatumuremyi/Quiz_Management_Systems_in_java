/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConfiguration;
import java.sql.*;
/**
 *
 * @author Kwizera
 */
public class Connections {

    public static Statement getcon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz_Management_System","root","");
            Statement statement=connection.createStatement();
            
            return  statement;
        }
        
        catch (ClassNotFoundException | SQLException ex){
            System.out.println("fail to connect to database");
        }
        return null;
        
    }
    
}
