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
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DataOperations {
    
    static Statement statement = Connections.getConnection();
    
    String values = "";
    String columns ="";
    public boolean insert(String tableName, HashMap<String, String> cvalues){
        String query="insert into "+tableName+"(";
        
        cvalues.forEach((key, value)->{
            columns += key +",";
            values += value + "\",\"";
        });
        columns = columns.substring(0, columns.length()-1);
        values = values.substring(0, values.length()-2);
        query += columns + ")values(\""+ values + ");";
        
        System.out.println(query);
        
        columns = values = "";
        if(executeSet(query)){
            return true;
        }
        else{
            return false;
        }
        
        
        
        
    }
    public boolean insert(String tableName, ArrayList<String> valiables,ArrayList<String> values){
        /*
    **********************************************************************************************************************
    **********************************************************************************************************************
    
                instert that in TableName with data stored in values arrayList in specified column in valiables array
    
    **********************************************************************************************************************
    **********************************************************************************************************************
    */
        String query="insert into "+tableName+"(";
        for(String variable : valiables){
                query += variable+',';
            }
            query = query.substring(0, query.length()-1)+ ")values(\"";
            for(String value : values){
                query +=value +"\",\"";
            }
            query = query.substring(0, query.length()-2)+ ");";
            if(executeSet(query)){
                return true;
            }
            else{
                return false;
            }
        
    }
    
    
 
   
    public ArrayList selectAll(String tableName){
        /*
        **********************************************************************************************************************
        **********************************************************************************************************************

                    it take tableName then return all data in table then return array with corresponding object type

        **********************************************************************************************************************
        **********************************************************************************************************************
        */

        
        
        
        
        String query = "select * from "+ tableName +";";
        ResultSet output = executeGet(query);
//        ResultSetMetaData metaData = output.getMetaData();
        
        switch (tableName) {
            case "answers":
            {
                
                ArrayList<Answers> result = new ArrayList<>();
                try {
                    while(output.next()){
                        Answers answer = new Answers();
                        
                        answer.setAnsId(output.getString("AnsId"));
                        answer.setAnswer(output.getString("Answer"));
                        answer.setIsItCorrect(output.getString("IsItCorrect"));
                        answer.setQuestionId(output.getString("QuestionId"));
                        
                        result.add(answer);
                    }
                    
                    
                    return result;
                } catch (SQLException ex) {
                    Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            case "questions":
            {
                ArrayList<Questions> result = new ArrayList<>();
                try {
                    while(output.next()){
                        Questions questions = new Questions();
                        
                        questions.setBelongInChap(output.getString("BelongInChap"));
                        questions.setCreatedOn(output.getString("CreatedOn"));
                        questions.setPreparedByIns(output.getString("PreparedByIns"));
                        questions.setPreparedForLevel(output.getString("PreparedForLevel"));
                        questions.setQtId(output.getString("QtId"));
                        
                        result.add(questions);
                        return result;
                    }
                }
                catch( SQLException ex){
                    ex.printStackTrace(System.out);
                    return null;
                }
                
            }
            case "headmaster":
            {
                
                ArrayList<HeadMaster> result;
                try {
                    result = new ArrayList<>();
                    while(output.next()){
                        HeadMaster headmaster = new HeadMaster();
                        
                        headmaster.setHmId(output.getString("HmId"));
                        headmaster.setDegree(output.getString("Degree"));
                        headmaster.setFirstName(output.getString("FirstName"));
                        headmaster.setLastName(output.getString("LastName"));
                        headmaster.setNationalId(output.getString("NationalId"));
                        headmaster.setSex(output.getString("Sex"));
                        headmaster.setTel(output.getString("Tel"));
                        
                        result.add(headmaster);
                    }
                    return result;
                } catch (SQLException ex) {
                    Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            case "schools":
            {
                ArrayList<Schools> result = new ArrayList<>();
            try {
                while(output.next()){
                    Schools school =new Schools();
                    
                    school.setCell(output.getString("Cell"));
                    school.setDistrict(output.getString("District"));
                    school.setHeadMasterId(output.getString("HeadMasterId"));
                    school.setProvence(output.getString("Provence"));
                    school.setSchoolName(output.getString("SchoolName"));
                    school.setSector(output.getString("Sector"));
                    school.setShId(output.getString("ShId"));
                    school.setType(output.getString("Type"));
                    
                    
                    result.add(school);
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            }
            case "levels":
            {
                ArrayList<Levels> result ;
            try {
                result = new ArrayList<>();
                while(output.next()){
                    Levels level = new Levels();
                    
                    level.setInFull(output.getString("InFull"));
                    level.setLevelName(output.getString("LevelName"));
                    
                    result.add(level);
                    
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            case "quizquestions":
            {
                ArrayList<QuizQuestions> result = new ArrayList<>();
            try {
                while(output.next()){
                    QuizQuestions quizQ = new QuizQuestions();
                    
                    quizQ.setAnswerId(output.getString("AnswerId"));
                    quizQ.setQuestionId(output.getString("QuestionId"));
                    quizQ.setQuizCode(output.getString("QuizCode"));
                    
                    result.add(quizQ);
                    
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            case "marks":
            {
                ArrayList<Marks> result = new ArrayList<>();
            try {
                Marks mark;
                while(output.next()){
                    mark  = new Marks();
                    mark.setCourseId(output.getString("CourseId"));
                    mark.setMarks(output.getString("Marks"));
                    mark.setMkId(output.getString("MkId"));
                    mark.setQuizCode(output.getString("QuizCode"));
                    mark.setStudentReg(output.getString("StudentReg"));
                    mark.setWorkedAt(output.getString("WorkedAt"));
                    
                    result.add(mark);
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            case "instructor":
            {
                ArrayList<Instructor> result = new ArrayList<>();
            try {
                while(output.next()){
                    Instructor instructor = new Instructor();
                    
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
                    
                    result.add(instructor);
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            case "students":
            {
                ArrayList<Students> result = new ArrayList<>();
            try {
                while(output.next()){
                    Students student = new Students();
                    
                    student.setAddress(output.getString("Address"));
                    student.setAge(output.getString("Age"));
                    student.setFirstName(output.getString("FirstName"));
                    student.setLastName(output.getString("LastName"));
                    student.setPassword(output.getString("Password"));
                    student.setRegNo(output.getString("RegNo"));
                    student.setSex(output.getString("Sex"));
                    student.setStatus(output.getString("Status"));
                    student.setStudentClass(output.getString("StudentClass"));
                    student.setStudentSchool(output.getString("StudentSchool"));
                    student.setUserName(output.getString("UserName"));
                    
                    result.add(student);
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            case "chapters":
            {
                ArrayList<Chapters> result = new ArrayList<>();
            try {
                while(output.next()){
                    Chapters chapter = new Chapters();
                    
                    chapter.setChapterName(output.getString("ChapterName"));
                    chapter.setCourseId(output.getString("CourseId"));
                    chapter.setCpId(output.getString("CpId"));
                    
                    result.add(chapter);
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            case "courses":
            {
                ArrayList<Courses> result = new ArrayList<>();
            try {
                while(output.next()){
                    Courses course = new Courses();
                    
                    course.setCourseName(output.getString("CourseName"));
                    course.setCsId(output.getString("CsId"));
                    course.setLevel(output.getString("Level"));
                    
                    result.add(course);
                }
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            }
            default:
            {
                return null;
            }
        }
        
        
        
        
    }
    public boolean executeSet(String query){
        try{
            System.out.println(query);
            statement.executeUpdate(query);
            return true;
        }
        catch (SQLException ex){
            System.out.println(ex);
              //  ex.printStackTrace(System.out);
                
            return false;
        }
    }
    ResultSet executeGet(String query){
        /*
        ***************************************************************************************************************************
        ***************************************************************************************************************************
        
                 this table query then return it result
        
        ***************************************************************************************************************************
        ***************************************************************************************************************************
        */
        ResultSet output = null;
        try{
            output = statement.executeQuery(query);
        }
        catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        
        return output;
    }
    
    
    
    public ResultSet select(String tableName, String... columns){
        /*
        **********************************************************************************************************************
        **********************************************************************************************************************

                    it take tableName and column to return  then  return array with corresponding object type

        **********************************************************************************************************************
        **********************************************************************************************************************
        */
        String query = "select ";
        
        for(String column : columns){
           query += column + ",";
        }
        query = query.substring(0, query.length() - 1);
        query += "from "+tableName + ";";
        try {
            ResultSet output = statement.executeQuery(query);
            return output;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println("fail to get data \n" + query);
            return null;
        }
    }
    
    
    public static ResultSet find(ConditionalData... datas){
        
        String query = "select * from ";
        String tables = "";
        String conditions = "";
        
        for(ConditionalData data : datas){
            tables += data.getTableName() +",";
            conditions += data.getTableName()+'.'+data.getColumnName()+"=\""+data.getValue()+"\" or ";
        }
        tables = tables.substring(0, tables.length()-1);
        conditions = conditions.substring(0, conditions.length()-3);
        query += tables + " where " + conditions +";";
        
        try {
            ResultSet output = statement.executeQuery(query);
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(DataOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public String lowerFC(String string){
        return string.substring(0,1).toLowerCase() + string.substring(1);
    }
            
        
    
}
