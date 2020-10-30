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
public class Students extends Table{
    private String regNo;
    private String firstName;
    private String lastName;
    private String studentClass;
    private String sex;
    private String age;
    private String studentSchool;
    private String address;
    private String userName;
    private String password;
    private String status;
    
    private Schools school;
    private Classes sClass;
    
    public Students(){
        super.tableName = "students";
        
        
    }
    public Students(String regNo, String firstName, String lastName, String studentClass, String sex, String age,
            String studentSchool, String address, String userName, String password, String status){
        cvalues.put("RegNo", regNo);
        cvalues.put("FirstName", firstName);
        cvalues.put("LastName", lastName);
        cvalues.put("StudentClass", studentClass);
        cvalues.put("Sex", sex);
        cvalues.put("Age", age);
        cvalues.put("StudentSchool", studentSchool);
        cvalues.put("Address", address);
        cvalues.put("UserName", userName);
        cvalues.put("Password", password);
        cvalues.put("Status", status);
        
        
        
        super.tableName = "students";
        
        this.regNo = regNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentClass = studentClass;
        this.sex = sex;
        this.age = age;
        this.studentSchool = studentSchool;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }
    public String getRegNo(){
        return this.regNo;
    }
    public void setRegNo(String regNo){
        cvalues.put("RegNo", regNo);
        
        
        this.regNo = regNo;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        cvalues.put("FirstName", firstName);
        
        
        this.firstName = firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        cvalues.put("LastName", lastName);
        
        
        this.lastName = lastName;
    }
    public String getStudentClass(){
        return this.studentClass;
    }
    public void setStudentClass(String studentClass){
        cvalues.put("StudentClass", studentClass);
        
        
        this.studentClass = studentClass;
    }
    public String getSex(){
        return this.sex;
    }
    public void setSex(String sex){
        cvalues.put("Sex", sex);
        
        
        this.sex = sex;
    }
    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        cvalues.put("Age", age);
        
        
        this.age = age;
    }
    public String getStudentSchool(){
        return this.studentSchool;
    }
    public void setStudentSchool(String studentSchool){
        cvalues.put("StudentSchool", studentSchool);
        
        
        this.studentSchool = studentSchool;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        cvalues.put("Address", address);
        
        
        this.address = address;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        cvalues.put("UserName", userName);
        
        
        this.userName = userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        cvalues.put("Password", password);
       
        this.password = password;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        cvalues.put("Status", status);
        
        this.status = status;
    }
    
    public Classes getSClass(){
        return this.sClass;
    }
    public void findSClass(){
        ResultSet output = DataOperations.find(new ConditionalData("classes", "ClId", this.studentClass));
        try {
            while(output.next()){
                sClass.setClId(output.getString("ClId"));
                sClass.setClassLevel(output.getString("ClassLevel"));
                sClass.setInstructorId(output.getString("InstructorId"));
                sClass.setSchoolId(output.getString("SchoolId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quizes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Schools getSchool(){
        return this.school;
    }
    public void findSchool(){
        ResultSet output = DataOperations.find(new ConditionalData("schools","ShId", this.studentSchool));
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
 
}
