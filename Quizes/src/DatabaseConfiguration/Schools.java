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
public class Schools extends Table{
    private String shId;
    private String schoolName;
    private String headMasterId;
    private String provence;
    private String district;
    private String sector;
    private String cell;
    private String type;
    
    private HeadMaster headmaster;
    
    Schools(){
        defaultData();
        
        
    }
    Schools(String shId, String schoolName, String headMasterId, String provence, String district, 
            String sector, String cell, String type){
        defaultData();
        
        this.shId = shId;
        this.schoolName = schoolName;
        this.headMasterId = headMasterId;
        this.provence = provence;
        this.district = district;
        this.sector = sector;
        this.cell = cell;
        this.type = type;
    }
    public String getShId(){
        return this.shId;
    }
    public void setShId(String shId){
        this.shId = shId;
    }
    public String getSchoolName(){
        return this.schoolName;
    }
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    public String getHeadMasterId(){
        return this.headMasterId;
    }
    public void setHeadMasterId(String headMasterId){
        this.headMasterId = headMasterId;
    }
    public String getProvence(){
        return this.provence;
    }
    public void setProvence(String provence){
        this.provence = provence;
    }
    public String getDistrict(){
        return this.district;
    }
    public void setDistrict(String district){
        this.district = district;
    }
    public String getSector(){
        return this.sector;
    }
    public void setSector(String sector){
        this.sector = sector;
    }
    public String getCell(){
        return this.cell;
    }
    public void setCell(String cell){
        this.cell = cell;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public HeadMaster getHeadMaster(){
        return this.headmaster;
    }
    public void findHeadMaster(){
        ResultSet output = DataOperations.find(new ConditionalData("headmaster", "HmId", this.headMasterId));
        try {
            while(output.next()){
                headmaster.setDegree(output.getString("Degree"));
                headmaster.setFirstName(output.getString("FirstName"));
                headmaster.setLastName(output.getString("LastName"));
                headmaster.setNationalId(output.getString("NationalId"));
                headmaster.setSex(output.getString("Sex"));
                headmaster.setTel(output.getString("Tel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Schools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void defaultData(){
        columns.add("ShId");
        columns.add("SchoolName");
        columns.add("HeadMasterId");
        columns.add("Provence");
        columns.add("District");
        columns.add("Sector");
        columns.add("Cell");
        columns.add("Type");
        
        values.add(shId);
        values.add(schoolName);
        values.add(headMasterId);
        values.add(provence);
        values.add(district);
        values.add(sector);
        values.add(cell);
        values.add(type);
        
        super.tableName = "schools";
    }
}
