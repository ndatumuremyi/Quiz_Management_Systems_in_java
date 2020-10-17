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
public class QuizQuestions extends Table{
    
    private String questionId;
    private String answerId;
    private String quizCode;
    QuizQuestions(){
        super.tableName = "quizquestions";
        questionId = answerId = quizCode = "";
    }
    QuizQuestions(String questionId, String answerId, String quizCode){
        this.questionId = questionId;
        this.answerId = answerId;
        this.quizCode = quizCode;
    }
    public String getQuestionId(){
        return this.questionId;
    }
    public void setQuestionId(String questionId){
        this.questionId = questionId;
    }
    public String getAnswerId(){
        return this.answerId;
    }
    public void setAnswerId(String answerId){
        this.answerId = answerId;
    }
    public String getQuizCode(){
        return this.quizCode;
    }
    public void setQuizCode(String quizCode){
        this.quizCode = quizCode;
    }
}
