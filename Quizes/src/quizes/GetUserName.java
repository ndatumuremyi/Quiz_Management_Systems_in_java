/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kwizera
 */
public class GetUserName {
    Stage stage;
    String UserName;
 VBox user=new VBox();
 /* Method to set the loggedin person and add it 
  to a vbox laout called users such that for ever user who loggs in is set*/
    public void setLoggedinUser(String Loggedin)
    {
        this.UserName=Loggedin;
        VBox vbox=new VBox();
        vbox.getChildren().add(new Label(Loggedin));
        user.getChildren().add(vbox);
    }
    /* Method to return  the loggedin person so that it will be used to the dissplay method*/
   public VBox getLoggedinUser()
   {
       return user;
   }
   /* Method to display the loggedin person and and icon*/
   public VBox DisplayLoggedin()
   {
       VBox loggeduser=new VBox();
       loggeduser.getChildren().addAll(new ImageView("quizes/image/user.png"),getLoggedinUser());
     
       return loggeduser;
   }
   public void Logout(Stage stage)
   {
        int a= JOptionPane.showConfirmDialog(null, "Do you realy want to logout","Logout",JOptionPane.YES_NO_OPTION);
  if(a==0)
  {
      JOptionPane.showMessageDialog(null, "you are loging out !");
 
    stage.close();
      LoginForm back=new LoginForm();
      Stage st=new Stage();
      try {
          back.start(st);
      } catch (SQLException ex) {
          Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
   }
 
    
}
