/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConfiguration;

/**
 *
 * @author paterne
 */
public class Courses extends Table{
    
    private String csId;
    private String courseName;
    private String level;
    
    public Courses(){
        super.tableName = "courses";
    }
    public Courses(String csId, String courseName, String level){
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
}