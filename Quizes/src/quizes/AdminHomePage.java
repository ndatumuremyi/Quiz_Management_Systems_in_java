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
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
 
 //border.setCenter(getNav());
  VBox user=getLoggedinUser();
  HBox hbox=new HBox();
  Admin admin=new Admin();
 
//TabPane tabs=admin.GetTabs();

  MenuBar AdminMenu=admin.GetMenuBar(primarStage,border);
  hbox.getChildren().add(user);
  hbox.getChildren().add(AdminMenu);
hbox.getStyleClass().add("adminmenu");

border.setRight(hbox);
VBox topmenu=new VBox();
topmenu.getChildren().addAll(label1,hbox);
border.setTop(topmenu);



 
//border.setCenter(tabs);

border.setLeft(user);
       border.setId("border");
       
         Scene scene = new Scene(border, 1500, 700);
         
         primaryStage.setTitle("Lgin Form");
        primaryStage.setScene(scene);
      //  primaryStage.setFullScreen(true);
      scene.getStylesheets().add("quizes/LoginForm.css");
      scene.getStylesheets().add("quizes/style.css");
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
 

