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
public class Chapters extends Table{
    
    private String cpId;
    private String chapterName;
    private String courseId;
    
    public Chapters(){
        super.tableName = "chapters";
        cpId = "";
        chapterName = "";
        courseId = "";
    }
    public Chapters(String chapterName, String courseId){
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
}
