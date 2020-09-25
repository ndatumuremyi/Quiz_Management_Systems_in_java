/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Kwizera
 */
public class Signup extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     LoginForm lg=new LoginForm();
      
   
          GridPane pane=new GridPane();
      pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    pane.setHgap(5.5);
   pane.setVgap(5.5);
      Label Fname=new Label("First name");
   TextField tx1=new TextField();
    tx1.setPromptText("Enter the first name");
      Label Lname=new Label("Sur name");
   TextField tx2=new TextField();
    tx2.setPromptText("Enter the Last name");
    Label gender=new Label("Gender");
    ComboBox gend=new ComboBox();
    ObservableList<String> options =FXCollections.observableArrayList("Male","Female","Other");
    gend.setItems(options);
      Label Email=new Label("Email");
   TextField tx3=new TextField();
    tx3.setPromptText("Enter your email address");
      Label PhoneNumber=new Label("Phone number");
   TextField tx4=new TextField();
    tx4.setPromptText("Enter the phone number");
    Label Course=new Label("Course");
    TextField tx5=new TextField();
    tx5.setPromptText("Enter the Course");
     Label level=new Label("Level");
    TextField tx6=new TextField();
    tx5.setPromptText("Enter the Level");
     Label Password=new Label("Password");
      PasswordField password=new PasswordField();
      password.setPromptText("Enter the password");
     Label Password2=new Label("Verify Password");
      PasswordField verify=new PasswordField();
      verify.setPromptText("Enter the password");
       Button sign=new Button("Submit");

     pane.setPrefSize(700,400);
      
      GridPane.setHalignment(sign, HPos.RIGHT);
      
      pane.add(Fname,0,0);
      pane.add(tx1,1,0);
      pane.add(Lname, 2, 0);
      pane.add(tx2, 3, 0);
      pane.add(Email, 0, 1);
      pane.add(tx3, 1, 1);
      pane.add(gender, 2, 1);
      pane.add(gend,3,1);
      pane.add(PhoneNumber, 0, 2);
      pane.add(tx4, 1, 2);
      pane.add(Course, 2, 2);
      pane.add(tx5, 3, 2);
      pane.add(level, 0, 3);
      pane.add(tx6, 1, 3);
      pane.add(Password, 2, 3);
      pane.add(password, 3, 3);
      pane.add(Password2, 0, 4);
      pane.add(verify, 1, 4);
      pane.add(sign, 2, 4);
      
        Scene scene = new Scene(pane, 400, 250);
          primaryStage.setScene(scene);
       primaryStage.centerOnScreen();
         primaryStage.show();
      
     }
        
      
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
