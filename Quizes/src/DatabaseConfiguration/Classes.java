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
public class Classes extends Table{
    
    private String clId;
    private String classLevel;
    private String schoolId;
    private String instructorId;
    private Levels level;
    private Schools school;
    private Instructor instructor;
    
    public Classes(){
        super.tableName = "classes";
        clId = "";
        classLevel = "";
        schoolId = "";
        instructorId = "";
    }
    public Classes(String clId, String classLevel, String schoolId, String instructorId){
        this.clId = clId;
        this.classLevel = classLevel;
        this.schoolId = schoolId;
        this.instructorId = instructorId;
    }
    public String getClId(){
        return this.clId;
    }
    public void setClId(String clId){
        this.clId = clId;
    }
    public String getClassLevel(){
        return this.classLevel;
    }
    public void setClassLevel(String classLevel){
        this.classLevel = classLevel;
    }
    public String getSchoolId(){
        return this.schoolId;
    }
    public void setSchoolId(String schoolId){
        this.schoolId = schoolId;
    }
    public String getInstructorId(){
        return this.instructorId;
    }
    public void setInstructorId(String instructorId){
        this.instructorId = instructorId;
    }
    public Levels getLevel(){
        return this.level;
    }
    public void findLevel(){
        ResultSet output = DataOperations.find(new ConditionalData("levels","LevelName", this.classLevel));
        try {
            while(output.next()){
                level.setInFull(output.getString("InFull"));
                level.setLevelName(output.getString("LevelName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Schools getSchool(){
        return this.school;
    }
    public void findSchool(){
        ResultSet output = DataOperations.find(new ConditionalData("schools","ShId", this.schoolId));
        try {
            while(output.next()){
                school.setCell(output.getString("Cell"));
                school.setDistrict(output.getString("District"));
                school.setHeadMasterId(output.getString("HeadMasterId"));
                school.setProvence(output.getString("Provence"));
                school.setSchoolName(output.getString("SchoolName"));
                school.setSector(output.getString("Sector"));
                school.setShId(output.getString("ShId"));
                school.setType(output.getString("Type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Instructor getInstructor(){
        return this.instructor;
    }
    public void findInstructor(){
        ResultSet output = DataOperations.find(new ConditionalData("instructor","InId", this.instructorId));
        try {
            while(output.next()){
                instructor.setCourse(output.getString("Course"));
                instructor.setDegree(output.getString("Degree"));
                instructor.setFirstName(output.getString("FirstName"));
                instructor.setInsId(output.getString("InsId"));
                instructor.setLastName(output.getString("LastName"));
                instructor.setNationalId(output.getString("NationalId"));
                instructor.setPassword(output.getString("Password"));
                instructor.setSchool(output.getString("School"));
                instructor.setStatus(output.getString("Status"));
                instructor.setUserName(output.getString("UserName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
