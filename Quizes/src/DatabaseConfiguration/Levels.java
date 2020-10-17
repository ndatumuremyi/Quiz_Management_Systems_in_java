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
        this.levelName = levelName;
        this.inFull = inFull;
    }
    public String getLvId(){
        return this.lvId ;
    }
    public String getLevelName(){
        return this.levelName;
    }
    public void setLevelName(String levelName){
        this.levelName = levelName;
    }
    public String getInFull(){
        return this.inFull;
    }
    public void setInFull(String inFull){
        this.inFull = inFull;
    }
    
}
