/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paterne
 */
public class Courses extends Table{
    
    private String csId;
    private String courseName;
    private String level;
    
    private Levels cLevel;
    
    public Courses(){
        super.tableName = "courses";
        
        
    }
    public Courses(String csId, String courseName, String level){
        cvalues.put("CsId",csId);
        cvalues.put("CourseName", courseName);
        cvalues.put("Level", level);
        
        
        
        super.tableName = "courses";
        
        this.csId = csId;
        this.courseName = courseName;
        this.level = level;
    }
    public String getCsId(){
        return this.csId;
    }
    public void setCsId(String csId){
        cvalues.put("CsId",csId);
        
        
        this.csId = csId;
    }
    public String getCourseName(){
        return this.courseName;
    } 
    public void setCourseName(String courseName){
        cvalues.put("CourseName", courseName);
        
        
        this.courseName = courseName;
    }
    public String getLevel(){
        return this.level;
    }
    public void setLevel(String level){
        cvalues.put("Level", level);
        
        this.level = level;
    }
    public Levels getCLevel(){
        return this.cLevel;
    }
    public void findCLevel(){
        ResultSet output = DataOperations.find(new ConditionalData("levels", "LevelName", this.level));
        try {
            while(output.next()){
                cLevel.setInFull(output.getString("InFull"));
                cLevel.setLevelName(output.getString("LevelName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
