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
    public Students(){
        super.tableName = "students";
    }
    public Students(String regNo, String firstName, String lastName, String studentClass, String sex, String age,
            String studentSchool, String address, String userName, String password, String status){
        
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
        this.regNo = regNo;
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
    public String getStudentClass(){
        return this.studentClass;
    }
    public void setStudentClass(String studentClass){
        this.studentClass = studentClass;
    }
    public String getSex(){
        return this.sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        this.age = age;
    }
    public String getStudentSchool(){
        return this.studentSchool;
    }
    public void setStudentSchool(String studentSchool){
        this.studentSchool = studentSchool;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
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
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
