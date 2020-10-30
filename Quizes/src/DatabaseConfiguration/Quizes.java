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
public class Quizes extends Table{
    private String quizCode;
    private String type;
    private String classPreparedFor;
    private String attemptDate;
    private String creator;
    
    private Instructor instructor;
    private Classes qClass;
    
    Quizes(){
        defaultData();
        
        
        quizCode = type = classPreparedFor = attemptDate = creator = "";
    }
    Quizes( String quizCode, String type, String classPreparedFor, String attemptDate, String creator){
        defaultData();
        values.add(quizCode);
        values.add(type);
        values.add(classPreparedFor);
        values.add(attemptDate);
        values.add(creator);
        
        this.quizCode = quizCode;
        this.type = type;
        this.classPreparedFor = classPreparedFor;
        this.attemptDate = attemptDate;
        this.creator = creator;
    }
    public String getQuizCode(){
        return this.quizCode;
    }
    public void setQuizCode(String quizCode){
        values.remove(this.quizCode);
        values.add(quizCode);
        
        this.quizCode = quizCode;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        values.remove(this.type);
        values.add(type);
        
        this.type = type;
    }
    public String getClassPreparedFor(){
        return this.classPreparedFor;
    }
    public void setClassPreparedFor(String classPreparedFor){
        values.remove(this.classPreparedFor);
        values.add(classPreparedFor);
        
        this.classPreparedFor = classPreparedFor;
    }
    public String getAttemptDate(){
        return this.attemptDate;
    }
    public void setAttemptDate(String attemptDate){
        values.remove(this.attemptDate);
        values.add(attemptDate);
        
        this.attemptDate = attemptDate;
    }
    public String getCreator(){
        return this.creator;
    }
    public void setCreator(String creator){
        values.remove(this.creator);
        values.add(creator);
        
        this.creator = creator;
    }
    
    
    public Instructor getInstructor(){
        return this.instructor;
    }
    public void findInstructor(){
        ResultSet output = DataOperations.find(new ConditionalData("instructor","InId", this.creator));
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
    public Classes getPreClass (){
        return this.qClass;
    }
    public void findPreClass(){
        ResultSet output = DataOperations.find(new ConditionalData("classes", "ClId", this.classPreparedFor));
        try {
            while(output.next()){
                qClass.setClId(output.getString("ClId"));
                qClass.setClassLevel(output.getString("ClassLevel"));
                qClass.setInstructorId(output.getString("InstructorId"));
                qClass.setSchoolId(output.getString("SchoolId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Quizes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void defaultData(){
        columns.add("QuizCode");
        columns.add("Type");
        columns.add("ClassPreparedFor");
        columns.add("AttemptDate");
        columns.add("Creator");
        
        
        
        super.tableName = "quizes";
    }
    
}
