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
public class Answers extends Table {
    private String ansId;
    private String questionId;
    private String answer;
    private String isItCorrect; 
    
    public Answers(String questionId, String answer, String isItCorrect){
        this.answer = answer;
        this.questionId = questionId;
        this.isItCorrect =isItCorrect;
        super.tableName = "answers";
    }

    Answers() {
        questionId = null;
        answer = null;
        isItCorrect = null;
    }
    
    public void setAnsId(String ansId){
        this.ansId = ansId;
    }
    public String getAnsId(){
        return ansId;
    }
    public String getQuestionId(){
        return questionId;
    }       
    public void setQuestionId(String questionId){
        this.questionId = questionId;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return answer;
    }
    public String getIsItCorrect(){
        return isItCorrect;
    }
    public void setIsItCorrect(String isItCorrect){
        this.isItCorrect = isItCorrect;
    }
}
