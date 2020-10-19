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
public class Quizes extends Table{
    private String quizCode;
    private String type;
    private String classPreparedFor;
    private String attemptDate;
    private String creator;
    
    Quizes(){
        super.tableName = "quizes";
        quizCode = type = classPreparedFor = attemptDate = creator = "";
    }
    Quizes( String quizCode, String type, String classPreparedFor, String attemptDate, String creator){
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
        this.quizCode = quizCode;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getClassPreparedFor(){
        return this.classPreparedFor;
    }
    public void setClassPreparedFor(String classPreparedFor){
        this.classPreparedFor = classPreparedFor;
    }
    public String getAttemptDate(){
        return this.attemptDate;
    }
    public void setAttemptDate(String attemptDate){
        this.attemptDate = attemptDate;
    }
    public String getCreator(){
        return this.creator;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
}
