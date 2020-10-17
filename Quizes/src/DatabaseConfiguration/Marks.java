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
public class Marks extends Table{
    
    private String mkId;
    private String studentReg;
    private String quizCode;
    private String courseId;
    private String marks;
    private String workedAt;
    
    public Marks(){
        super.tableName = "marks";
        mkId = studentReg = quizCode = courseId = marks = workedAt = "";
    }
    public Marks(String mkId, String studentReg, String quizCode,String courseId, String marks, String workedAt){
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
        this.mkId = mkId;
    }
    public String getStudentReg(){
        return this.studentReg;
    }
    public void setStudentReg(String studentReg){
        this.studentReg = studentReg;
    }
    public String getQuizCode(){
        return this.quizCode;
    }
    public void setQuizCode(String quizCode){
        this.quizCode = quizCode;
    }
    public String getCourseId(){
        return this.courseId;
    }
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    public String getMarks(){
        return this.marks;
    }
    public void setMarks(String marks){
        this.marks = marks;
    }
    public String getWorkedAt(){
        return this.workedAt;
    }
    public void setWorkedAt(String workedAt){
        this.workedAt = workedAt;
    }
}
