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
        defaultData();
        
        
        qtId =  preparedByIns = belongInChap = preparedForLevel = createdOn = "";
    }
    Questions(String qtId, String preparedByIns, String belongInChap, String preparedForLevel, String createdOn){
        defaultData();
        values.add(qtId);
        values.add(question);
        values.add(preparedByIns);
        values.add(belongInChap);
        values.add(preparedForLevel);
        values.add(createdOn);
        
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
        values.remove(this.qtId);
        values.add(qtId);
        
        this.qtId = qtId;
    }
    public String getQuestion(){
        return this.question;
    }
    public void setQuestion(String question){
        values.remove(this.question);
        values.add(question);
        
        this.question = question;
    }
    public String getPreparedByIns(){
        return this.preparedByIns;
    }
    public void setPreparedByIns(String preparedByIns){
        values.remove(this.preparedByIns);
        values.add(preparedByIns);
        
        this.preparedByIns = preparedByIns;
    }
    public String getBelongInChap(){
        return this.belongInChap;
    }
    public void setBelongInChap(String belongInChap){
        values.remove(this.belongInChap);
        values.add(belongInChap);
        
        this.belongInChap = belongInChap;
    }
    public String getPreparedForLevel(){
        return this.preparedForLevel;
    }
    public void setPreparedForLevel(String preparedForLevel){
        values.remove(this.preparedForLevel);
        values.add(preparedForLevel);
        
        this.preparedForLevel = preparedForLevel;
    }
    public String getCreatedOn(){
        return this.createdOn;
    }
    public void setCreatedOn(String createdOn){
        values.remove(this.createdOn);
        values.add(createdOn);
        
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
    private void defaultData(){
        columns.add("QtId");
        columns.add("Question");
        columns.add("PreparedByIns");
        columns.add("BelongInChap");
        columns.add("PreparedForLevel");
        columns.add("CreatedOn");
        
        
        
        super.tableName = "questions";
    }
}
