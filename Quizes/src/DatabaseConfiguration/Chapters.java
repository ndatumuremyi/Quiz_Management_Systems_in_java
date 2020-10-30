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
public class Chapters extends Table{
    
    private String cpId;
    private String chapterName;
    private String courseId;
    
    private Courses course;
    
    public Chapters(){
        defaultData();
        
        
        cpId = "";
        chapterName = "";
        courseId = "";
    }
    public Chapters(String chapterName, String courseId){
        defaultData();
        
        this.chapterName = chapterName;
        this.courseId = courseId;
    }
    public String getCpId(){
        return cpId;
    }
    public void setCpId(String cpId){
        this.cpId = cpId;
    }
    public String getChapterName(){
        return chapterName;
    }
    public void setChapterName(String chapterName){
        this.chapterName = chapterName;
    }
    public String getCourseId(){
        return courseId;
    }
    public void setCourseId(String courseId){
        this.courseId = courseId;
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
            Logger.getLogger(Chapters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void defaultData(){
        values.add(cpId);
        values.add(cpId);
        values.add(chapterName);
        values.add(courseId);
        
        columns.add("CpId");
        columns.add("CpId");
        columns.add("ChapterName");
        columns.add("CourseId");
        
        super.tableName = "chapters";
    }
}
