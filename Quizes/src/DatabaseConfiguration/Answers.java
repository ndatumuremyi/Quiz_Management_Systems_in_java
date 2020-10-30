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
public class Answers extends Table {
    private String ansId;
    private String questionId;
    private String answer;
    private String isItCorrect;
    
    private Questions question;
    
    public Answers(String ansId, String questionId, String answer, String isItCorrect){
        defaultData();
        this.ansId = ansId;
        this.answer = answer;
        this.questionId = questionId;
        this.isItCorrect =isItCorrect;
        
        values.add(ansId);
        values.add(questionId);
        values.add(answer);
        values.add(isItCorrect);
        
    }

    Answers() {
        defaultData();
                
        questionId = null;
        answer = null;
        isItCorrect = null;
    }
    
    public void setAnsId(String ansId){
        values.remove(this.ansId);
        values.add(ansId);
        
        this.ansId = ansId;
    }
    public String getAnsId(){
        return ansId;
    }
    public String getQuestionId(){
        return questionId;
    }       
    public void setQuestionId(String questionId){
        values.remove(this.questionId);
        values.add(questionId);
        
        this.questionId = questionId;
    }
    public void setAnswer(String answer){
        values.remove(this.answer);
        values.add(answer);
        
        this.answer = answer;
    }
    public String getAnswer(){
        return answer;
    }
    public String getIsItCorrect(){
        return isItCorrect;
    }
    public void setIsItCorrect(String isItCorrect){
        values.remove(this.isItCorrect);
        values.add(isItCorrect);
        
        this.isItCorrect = isItCorrect;
    }
    public Questions getQuestion(){
        return question;
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
    private void defaultData(){
        columns.add("AnsId");
        columns.add("QuestionId");
        columns.add("Answer");
        columns.add("IsItCorrect");
        
        
        super.tableName = "answers";
    }
}
