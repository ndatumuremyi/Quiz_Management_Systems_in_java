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
public class Questions extends Table{
    
    private String qtId;
    private String question;
    private String preparedByIns;
    private String belongInChap;
    private String preparedForLevel;
    private String createdOn;
    
    private Levels level;
    private Instructor instructor;
    private Chapters chapter;
    
    Questions(){
        super.tableName = "questions";
        
        
        qtId =  preparedByIns = belongInChap = preparedForLevel = createdOn = "";
    }
    Questions(String qtId,String question, String preparedByIns, String belongInChap, String preparedForLevel, String createdOn){
        cvalues.put("QtId", qtId);
        cvalues.put("Question", question);
        cvalues.put("PreparedByIns", preparedByIns);
        cvalues.put("BelongInChap", belongInChap);
        cvalues.put("PreparedForLevel", preparedForLevel);
        cvalues.put("CreatedOn", createdOn);
        
        
        
        super.tableName = "questions";
        
        this.qtId = qtId;
        this.preparedByIns = preparedByIns;
        this.belongInChap = belongInChap;
        this.preparedForLevel = preparedForLevel;
        this.createdOn = createdOn;
    }
    public String getQtId(){
        return this.qtId;
    }
    public void setQtId(String qtId){
        cvalues.put("QtId", qtId);
        
        
        this.qtId = qtId;
    }
    public String getQuestion(){
        return this.question;
    }
    public void setQuestion(String question){
        cvalues.put("Question", question);
        
        
        this.question = question;
    }
    public String getPreparedByIns(){
        return this.preparedByIns;
    }
    public void setPreparedByIns(String preparedByIns){
        cvalues.put("PreparedByIns", preparedByIns);
        
        
        this.preparedByIns = preparedByIns;
    }
    public String getBelongInChap(){
        return this.belongInChap;
    }
    public void setBelongInChap(String belongInChap){
        cvalues.put("BelongInChap", belongInChap);
        
        
        this.belongInChap = belongInChap;
    }
    public String getPreparedForLevel(){
        return this.preparedForLevel;
    }
    public void setPreparedForLevel(String preparedForLevel){
        cvalues.put("PreparedForLevel", preparedForLevel);
       
        
        this.preparedForLevel = preparedForLevel;
    }
    public String getCreatedOn(){
        return this.createdOn;
    }
    public void setCreatedOn(String createdOn){
        cvalues.put("CreatedOn", createdOn);
        
        this.createdOn = createdOn;
    }
    
    
    public Levels getLevel(){
        return this.level;
    }
    public void findLevel(){
        ResultSet output = DataOperations.find(new ConditionalData("levels", "LevelName", this.preparedForLevel));
        try {
            while(output.next()){
                level.setInFull(output.getString("InFull"));
                level.setLevelName(output.getString("LevelName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Instructor getInstructor(){
        return this.instructor;
    }
    public void findInstructor(){
        ResultSet output = DataOperations.find(new ConditionalData("Instructor","InsId" ,this.preparedByIns));
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
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Chapters getChapter(){
        return this.chapter;
    }
    public void findChapter(){
        ResultSet output = DataOperations.find(new ConditionalData("chapters", "CpId",this.belongInChap));
        try {
            while(output.next()){
                chapter.setChapterName(output.getString("ChapterName"));
                chapter.setCourseId(output.getString("CourseId"));
                chapter.setCpId(output.getString("CpId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
