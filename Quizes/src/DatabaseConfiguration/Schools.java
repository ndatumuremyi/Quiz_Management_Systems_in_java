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
public class Schools extends Table{
    private String shId;
    private String schoolName;
    private String headMasterId;
    private String provence;
    private String district;
    private String sector;
    private String cell;
    private String type;
    
    Schools(){
        super.tableName = "schools";
    }
    Schools(String shId, String schoolName, String headMasterId, String provence, String district, 
            String sector, String cell, String type){
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
}
