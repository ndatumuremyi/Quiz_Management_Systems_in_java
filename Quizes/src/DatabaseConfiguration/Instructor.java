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
    
    public Instructor(){
        super.tableName = "instructor";
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
    
}
