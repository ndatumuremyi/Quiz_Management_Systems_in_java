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
        defaultData();
        
        
    }
    public Courses(String csId, String courseName, String level){
        defaultData();
        
        this.csId = csId;
        this.courseName = courseName;
        this.level = level;
    }
    public String getCsId(){
        return this.csId;
    }
    public void setCsId(String csId){
        this.csId = csId;
    }
    public String getCourseName(){
        return this.courseName;
    } 
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getLevel(){
        return this.level;
    }
    public void setLevel(String level){
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
    private void defaultData(){
        columns.add("CsId");
        columns.add("CourseName");
        columns.add("Level");
        
        values.add(csId);
        values.add(courseName);
        values.add(level);
        
        super.tableName = "courses";
    }
}
