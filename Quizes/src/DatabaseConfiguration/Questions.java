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
public class Questions extends Table{
    
    private String qtId;
    private String preparedByIns;
    private String belongInChap;
    private String preparedForLevel;
    private String createdOn;
    
    Questions(){
        super.tableName = "questions";
        qtId =  preparedByIns = belongInChap = preparedForLevel = createdOn = "";
    }
    Questions(String qtId, String preparedByIns, String belongInChap, String preparedForLevel, String createdOn){
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
        this.qtId = qtId;
    }
    public String getPreparedByIns(){
        return this.preparedByIns;
    }
    public void setPreparedByIns(String preparedByIns){
        this.preparedByIns = preparedByIns;
    }
    public String getBelongInChap(){
        return this.belongInChap;
    }
    public void setBelongInChap(String belongInChap){
        this.belongInChap = belongInChap;
    }
    public String getPreparedForLevel(){
        return this.preparedForLevel;
    }
    public void setPreparedForLevel(String preparedForLevel){
        this.preparedForLevel = preparedForLevel;
    }
    public String getCreatedOn(){
        return this.createdOn;
    }
    public void setCreatedOn(String createdOn){
        this.createdOn = createdOn;
    }
}
