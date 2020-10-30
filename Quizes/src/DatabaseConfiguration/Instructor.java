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
public class Instructor extends Table{
    
    private String inId;
    private String firstName;
    private String lastName;
    private String course;
    private String nationalId;
    private String school;
    private String userName;
    private String password;
    private String degree;
    private String status;
    
    private Courses iCourse;
    private Schools iSchool;
    
    public Instructor(){
        defaultData();
        
        
        inId = "";
        firstName = "";
        lastName = "";
        course = "";
        nationalId = "";
        school = "";
        userName = "";
        password = "";
        degree = "";
        status = "";
        
    }
    public Instructor(String insId, String firstName, String lastName, String course, String nationalId, String school,
            String userName, String password, String degree, String status){
        defaultData();
        
        this.inId = insId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.nationalId = nationalId;
        this.school = school;
        this.userName = userName;
        this.password = password;
        this.degree = degree;
        this.status = status;
    }
    public String getInId (){
        return this.inId;
    }
    public void setInsId (String insId){
        this.inId = insId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getCourse(){
        return this.course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public String getNationalId(){
        return this.nationalId;
    }
    public void setNationalId(String nationalId){
        this.nationalId = nationalId;
    }
    public String getSchool(){
        return this.school;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getDegree(){
        return this.degree;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
        
    public Schools getISchool(){
        return this.iSchool;
    }
    public void findISchool(){
        ResultSet output = DataOperations.find(new ConditionalData("schools", "ShId", this.school));
        try {
            while(output.next()){
                iSchool.setCell(output.getString("Cell"));
                iSchool.setDistrict(output.getString("District"));
                iSchool.setHeadMasterId(output.getString("HeadMasterId"));
                iSchool.setProvence(output.getString("Provence"));
                iSchool.setSchoolName(output.getString("SchoolName"));
                iSchool.setSector(output.getString("Sector"));
                iSchool.setShId(output.getString("ShId"));
                iSchool.setType(output.getString("Type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Courses getICourse(){
        return this.iCourse;
    }
    public void findICourse(){
        ResultSet output = DataOperations.find(new ConditionalData("courses", "CsId", this.course));
        try {
            while(output.next()){
                iCourse.setCourseName(output.getString("CourseName"));
                iCourse.setCsId(output.getString("CsId"));
                iCourse.setLevel(output.getString("Level"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void defaultData(){
        
        columns.add("InId");
        columns.add("FirstName");
        columns.add("LastName");
        columns.add("Course");
        columns.add("NationalId");
        columns.add("School");
        columns.add("UserName");
        columns.add("Password");
        columns.add("Degree");
        columns.add("Status");
        
        values.add(inId);
        values.add(firstName);
        values.add(lastName);
        values.add(course);
        values.add(nationalId);
        values.add(school);
        values.add( userName);
        values.add( password);
        values.add( degree);
        values.add( status);
        
        super.tableName = "instructor";
    }
    
}
