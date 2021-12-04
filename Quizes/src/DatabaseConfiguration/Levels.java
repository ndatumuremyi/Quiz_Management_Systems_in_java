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
public class Levels extends Table{
    private String lvId;
    private String levelName;
    private String inFull;
    
    public Levels(){
        super.tableName = "levels";
        
        
        levelName = "";
        inFull = "";
    }
    public Levels(String levelName, String inFull){
        cvalues.put("LevelName", levelName);
        cvalues.put("InFull", inFull);
             
        super.tableName = "levels";
        
        this.levelName = levelName;
        this.inFull = inFull;
    }
    public String getLvId(){
        return this.lvId ;
    }
    public void setLvId(String lvId){

        this.lvId = lvId;
    }
    public String getLevelName(){
        return this.levelName;
    }
    public void setLevelName(String levelName){
        cvalues.put("LevelName", levelName);
        
        
        this.levelName = levelName;
    }
    public String getInFull(){
        return this.inFull;
    }
    public void setInFull(String inFull){
        cvalues.put("InFull", inFull);
        
        this.inFull = inFull;
    }
    
}
