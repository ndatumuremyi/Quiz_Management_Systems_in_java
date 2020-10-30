/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConfiguration;

import java.util.ArrayList;

/**
 *
 * @author paterne
 */
public class Table {
    String tableName;
    DataOperations operation = new DataOperations();
    ArrayList<String> columns = new ArrayList<>();
    ArrayList<String> values = new ArrayList<>();

    
    public void save(){
        if(values.size()==columns.size() ){
            
            if(operation.insert(tableName, columns, values)){
                System.out.println("well inserted");
            }
            else{
                System.out.println("fail to insert");
            }
            
        }
        else{
            System.out.print("Error found");
        }
    }
    
    public static void select(){
        
    }
    
}
