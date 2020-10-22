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
import javafx.scene.input.MouseEvent;
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
 border.setTop(label1);
 border.setCenter(getNav());

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
private   HBox getNav()
    {
     HBox hBox = new HBox(15);
 hBox.setPadding(new Insets(15, 15, 15, 15));
 
 Label student=new Label("Student Description");
Label instructor=new Label("Instructor Description");
Label addinstructor=new Label("Add_Instructor");
Label updateinstructor=new Label("update_instructor");
Label delete=new Label("Delete_instructor");
Label logout=new Label("Logout");
logout.setId("logout");
Label[] Menu = {instructor ,addinstructor,updateinstructor,delete,student,logout};
for (Label menu: Menu) {
    menu.setId("menu");
 HBox.setMargin(menu, new Insets(0, 0, 0, 15));
 hBox.getChildren().add(menu);
    }
//hBox.getChildren().add(bt);
hBox.setId("nav");
logout.setOnMousePressed(e->{
 new GetUserName().Logout(primarStage);
});
 addinstructor.setOnMousePressed((MouseEvent e) -> {
     Add_Instructor inst=new Add_Instructor();
     Stage instStage=new Stage();
     instStage.setX(350);
     instStage.setY(160);
     instStage.setWidth(500);
     instStage.setWidth(700);
     inst.start(instStage);
     });
return hBox;
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
 

