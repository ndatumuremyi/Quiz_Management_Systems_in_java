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
public class Marks extends Table{
    
    private String mkId;
    private String studentReg;
    private String quizCode;
    private String courseId;
    private String marks;
    private String workedAt;
    
    private Courses course;
    private Students student;
    private Quizes quiz;
    
    public Marks(){
        defaultData();
        
        
        mkId = studentReg = quizCode = courseId = marks = workedAt = "";
    }
    public Marks(String mkId, String studentReg, String quizCode,String courseId, String marks, String workedAt){
        defaultData();
        values.add(mkId);
        values.add(studentReg);
        values.add(quizCode);
        values.add(courseId);
        values.add(marks);
        values.add(workedAt);
        
        this.mkId = mkId;
        this.studentReg = studentReg;
        this.quizCode = quizCode;
        this.courseId = courseId;
        this.marks = marks;
        this.workedAt = workedAt;
    }
    public String getMkId(){
        return this.mkId;
    }
    public void setMkId(String mkId){
        values.remove(this.mkId);
        values.add(mkId);
        
        this.mkId = mkId;
    }
    public String getStudentReg(){
        return this.studentReg;
    }
    public void setStudentReg(String studentReg){
        values.remove(this.studentReg);
        values.add(studentReg);
        
        this.studentReg = studentReg;
    }
    public String getQuizCode(){
        return this.quizCode;
    }
    public void setQuizCode(String quizCode){
        values.remove(this.quizCode);
        values.add(quizCode);
        
        this.quizCode = quizCode;
    }
    public String getCourseId(){
        return this.courseId;
    }
    public void setCourseId(String courseId){
        values.remove(this.courseId);
        values.add(courseId);
        
        this.courseId = courseId;
    }
    public String getMarks(){
        return this.marks;
    }
    public void setMarks(String marks){
        values.remove(this.marks);
        values.add(marks);
        
        this.marks = marks;
    }
    public String getWorkedAt(){
        return this.workedAt;
    }
    public void setWorkedAt(String workedAt){
        values.remove(this.workedAt);
        values.add(workedAt);
        
        this.workedAt = workedAt;
    }
    
    
    
    public Courses getCourse(){
        return this.course;
    }
    public void findCourse(){
        ResultSet output = DataOperations.find(new ConditionalData("courses", "CsId", this.courseId));
      
        try {
            while(output.next()){
                course.setCourseName(output.getString("CourseName"));
                course.setCsId(output.getString("CsId"));
                course.setLevel(output.getString("Level"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Quizes getQuiz(){
        return this.quiz;
    }
    public void findQuiz(){
        ResultSet output = DataOperations.find(new ConditionalData("quizes","QuizCode", this.quizCode));
        try {
            while(output.next()){
                quiz.setAttemptDate(output.getString("AttemptDate"));
                quiz.setClassPreparedFor(output.getString("ClassPreparedFor"));
                quiz.setCreator(output.getString("Creator"));
                quiz.setQuizCode(output.getString("QuizCode"));
                quiz.setType(output.getString("Type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Students getStudent(){
        return this.student;
    }
    public void findStudent(){
        ResultSet output = DataOperations.find(new ConditionalData("Students","RegNo", this.studentReg));
        try {
            while(output.next()){
                student.setAddress(output.getString("Address"));
                student.setAge(output.getString("Age"));
                student.setFirstName(output.getString("FirstName"));
                student.setLastName(output.getString("LastName"));
                student.setPassword(output.getString("Password"));
                student.setRegNo(output.getString("RegNo"));
                student.setSex(output.getString("Sex"));
                student.setStatus(output.getString("Status"));
                student.setStudentClass(output.getString("StudentClass"));
                student.setStudentSchool(output.getString("StudentSchool"));
                student.setUserName(output.getString("UserName"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void defaultData(){
        columns.add("MkId");
        columns.add("StudentReg");
        columns.add("QuizCode");
        columns.add("CourseId");
        columns.add("Marks");
        columns.add("WorkedAt");
        
        
        super.tableName = "marks";
    }
}
