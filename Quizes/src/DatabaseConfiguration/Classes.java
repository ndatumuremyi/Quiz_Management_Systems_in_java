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
public class Classes extends Table{
    
    private String clId;
    private String courseLevel;
    private String schoolId;
    private String instructorId;
    
    public Classes(){
        super.tableName = "classes";
        clId = "";
        courseLevel = "";
        schoolId = "";
        instructorId = "";
    }
    public Classes(String clId, String courseLevel, String schoolId, String instructorId){
        this.clId = clId;
        this.courseLevel = courseLevel;
        this.schoolId = schoolId;
        this.instructorId = instructorId;
    }
    public String getClId(){
        return this.clId;
    }
    public void setClId(String clId){
        this.clId = clId;
    }
    public String getCourseLevel(){
        return this.courseLevel;
    }
    public void setCourseLevel(String courseLevel){
        this.courseLevel = courseLevel;
    }
    public String getSchoolId(){
        return this.schoolId;
    }
    public void setSchoolId(String schoolId){
        this.schoolId = schoolId;
    }
    public String setInstructorId(){
        return this.instructorId;
    }
    public void getInstructorId(String instructorId){
        this.instructorId = instructorId;
    }
    
}
