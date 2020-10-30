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
        super.tableName = "chapters";
        
        
        cpId = "";
        chapterName = "";
        courseId = "";
    }
    public Chapters(String cpId, String chapterName, String courseId){
        cvalues.put("CpId", cpId);
        cvalues.put("ChapterName", chapterName);
        cvalues.put("CourseId", courseId);
        
        super.tableName = "chapters";
        
        this.cpId = cpId;
        this.chapterName = chapterName;
        this.courseId = courseId;
    }
    public String getCpId(){
        return cpId;
    }
    public void setCpId(String cpId){
        cvalues.put("CpId", cpId);
        
        
        this.cpId = cpId;
    }
    public String getChapterName(){
        return chapterName;
    }
    public void setChapterName(String chapterName){
        cvalues.put("ChapterName", chapterName);
        
        
        this.chapterName = chapterName;
    }
    public String getCourseId(){
        return courseId;
    }
    public void setCourseId(String courseId){
        cvalues.put("CourseId", courseId);
        
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
    
}
