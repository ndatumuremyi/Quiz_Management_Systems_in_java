/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

/**
 *
 * @author Kwizera
 */
public class GetUserName {
    String UserName;
    Forms form=new Forms();
    public GetUserName(){
          this.UserName=form.getUsername();
    }
    public String getUser(){
        
        return UserName;
    }
 
    
}
