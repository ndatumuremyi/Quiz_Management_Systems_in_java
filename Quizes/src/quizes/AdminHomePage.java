package quizes;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kwizera
 */
public class AdminHomePage extends Application{
   private Stage primarStage;
   BorderPane border;
   VBox logged;
  @Override
    public void start(Stage primaryStage) {
      
        this.primarStage=primaryStage;
       border=new BorderPane();
 Label label1=new Label("Quiz Management System");
 label1.setId("title");
label1.setPadding(new Insets(1,4,15,50));
 border.setTop(label1);
 //border.setCenter(getNav());
 Label logout=new Label("Logout");
logout.setId("logout");
logout.setOnMousePressed(e->{
 new GetUserName().Logout(primarStage);
});
Label Exit=new Label("Close application");
logout.setId("logout");
Exit.setId("Exit");
Exit.setOnMousePressed(e->{
int a= JOptionPane.showConfirmDialog(null, "Do you realy want to close","Closing Prompt",JOptionPane.YES_NO_OPTION);
 if(a==0)
 {
   JOptionPane.showMessageDialog(null, "Closing app..");
   System.exit(0);
 }
});

 Admin admin=new Admin();
 Tab logoutTab=new Tab("Options");
HBox optionpane=new HBox();
HBox.setMargin(logout, new Insets(0, 0, 0, 15));
HBox.setMargin(Exit, new Insets(0, 0, 0, 15));
optionpane.getChildren().addAll(logout,Exit);

 logoutTab.setContent(optionpane);
 admin.AdminTabs.getTabs().add(logoutTab);
TabPane tabs=admin.GetTabs();
border.setCenter(tabs);



                            VBox user=getLoggedinUser();
                          
                            border.setLeft(user);
      

 
 
         border.setId("border");
       
         Scene scene = new Scene(border, 1500, 700);
         
         primaryStage.setTitle("Lgin Form");
        primaryStage.setScene(scene);
      //  primaryStage.setFullScreen(true);
      scene.getStylesheets().add("quizes/LoginForm.css");
        primaryStage.show();
        
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
 
   public void setLoggedinUser(VBox user)
   {
       this.logged=user;
       
   }
    public VBox getLoggedinUser()
   {
       return logged;
   }
}
 

