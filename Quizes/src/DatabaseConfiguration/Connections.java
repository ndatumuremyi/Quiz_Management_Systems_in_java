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

    public static Statement getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/qms", "scott", "tiger");
            Statement statement = connection.createStatement();
            
            return statement;
        }
        
        catch (ClassNotFoundException | SQLException ex){
            System.out.println("fail to connect to database");
        }
        return null;
        
    }
    
}
