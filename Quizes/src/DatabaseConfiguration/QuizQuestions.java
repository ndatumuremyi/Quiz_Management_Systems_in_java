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
public class QuizQuestions extends Table{
    
    private String questionId;
    private String answerId;
    private String quizCode;
    
    private Questions question;
    private Answers answer;
    private Quizes quiz;
    
    QuizQuestions(){
        defaultData();
        
        
        questionId = answerId = quizCode = "";
    }
    QuizQuestions(String questionId, String answerId, String quizCode){
        defaultData();
        
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
    
    
    
    
    public Questions getQuestion(){
        return this.question;
    }
    public void findQuestion(){
        ResultSet output = DataOperations.find(new ConditionalData("Questions", "QtId", this.questionId));
        try {
            while(output.next()){
                question.setBelongInChap(output.getString("BelongInChap"));
                question.setCreatedOn(output.getString("CreatedOn"));
                question.setPreparedByIns(output.getString("prepatedByIns"));
                question.setPreparedForLevel(output.getString("PreparedForLevel"));
                question.setQtId(output.getString("QtId"));
                question.setQuestion(output.getString("Question"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Answers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Answers getAnswer(){
        return this.answer;
    }
    public void findAnswer(){
//        ResultSet output = DataOperations.find(new ConditionalData("answers"))
    }
    public Quizes getQuiz(){
        return this.quiz;
    }
    public void findQuiz(){
        ResultSet output = DataOperations.find(new ConditionalData("quizes", "QzId", this.questionId));
        try {
            while(output.next()){
                quiz.setAttemptDate(output.getString("AttemptDate"));
                quiz.setClassPreparedFor(output.getString("ClassPreparedFor"));
                quiz.setCreator(output.getString("Creator"));
                quiz.setQuizCode(output.getString("QuizCode"));
                quiz.setType(output.getString("Type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizQuestions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void defaultData(){
        columns.add("QuestionId");
        columns.add("AnswerId");
        columns.add("QuizCode");
        
        values.add(questionId);
        values.add(answerId);
        values.add(quizCode);
        
        super.tableName = "quizquestions";
    }
}
