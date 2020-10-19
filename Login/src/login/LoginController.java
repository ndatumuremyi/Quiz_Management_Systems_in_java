package login;

import java.util.ArrayList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.swing.JOptionPane;

/** Controls the login screen */
public class LoginController {
  @FXML private TextField user;
  @FXML private TextField password;
  @FXML private Button loginButton;
  
  public void initialize() {}
  
  public void initManager(final LoginManager loginManager) {
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        String sessionID = authorize();
        if (sessionID != null) {
          loginManager.authenticated(sessionID);
        }
      }
    });
  }

  /**
   * Check authorization credentials.
   * 
   * If accepted, return a sessionID for the authorized session
   * otherwise, return null.
   */   
  private String authorize() {
    return 
      "open".equals(user.getText()) && "sesame".equals(password.getText()) 
            ? generateSessionID() 
            : "invalid user name or password";
  }
  
 // private static int sessionID = 0;
  ArrayList<String> users=new ArrayList<>();
  String[] names={"kwizera","nkwakuzi","janvier"};
  private static int j=-1;
  int i;
String n=null;
  private String generateSessionID() {
    //sessionID++;
    //return "xyzzy - session " + sessionID;
    for(i=0;i<names.length;i++)
    {   
        users.add(names[i]);
    }
    j++;
    if(j==users.size()){
        JOptionPane.showMessageDialog(null, "sessions ended!");
        System.exit(j);
    }
   return users.get(j);
  }
  
}
