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
public class HeadMaster extends Table{
    private String firstName;   
    private String lastName;
    private String nationalId;
    private String sex;
    private String degree;
    private String tel;
    private Schools school;
    
    
    
    
    public HeadMaster(){
        super.tableName = "headmaster";
        valiables.add("FirstName");
        valiables.add("LastName");
        valiables.add("NationalId");
        valiables.add("Sex");
        valiables.add("Degree");
        valiables.add("Tel");
        
    }
    public HeadMaster(String firstName, String lastName, String nationalId, String sex, String degree, String tel){
        
        
        valiables.add("FirstName");
        valiables.add("LastName");
        valiables.add("NationalId");
        valiables.add("Sex");
        valiables.add("Degree");
        valiables.add("Tel");
        
        values.add(firstName);
        values.add(lastName);
        values.add(nationalId);
        values.add(sex);
        values.add(degree);
        values.add(tel);
        
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.sex = sex;
        this.degree = degree;
        this.tel = tel;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setNationalId(String nationalId){
        this.nationalId = nationalId;
    }
    public String getNationalId(){
        return this.nationalId;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }
    public String getDegree(){
        return this.degree;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTel(){
        return this.tel;
    }
    public Schools getSchool(){
        return this.school;
    }
    public void findSchool(){
//        ResultSet output = DataOperations.find(new ConditionalData("schools", "ShId", this.));
    }
    
    
    
}
