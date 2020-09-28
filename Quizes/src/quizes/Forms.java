/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

/**
 *
 * @author paterne
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
 
public class Forms {
    String[] classes = {"S1","S2","S3","S4MPC","S5MPC","S6MPC"};
 
 
    VBox login()  {
      /* **********************************************************************************************************
    *********************************************************************************************************
   
    
    
    start of login form
    
    
    
    *********************************************************************************************************
    *********************************************************************************************************
    */ 
    VBox loginPane = new VBox();
    loginPane.getStyleClass().add("vbox");
    loginPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    
    Label username=new Label("Email");
    TextField email=new TextField();
    email.setPromptText("Enter your email");
   
    Label password=new Label("Password");
    PasswordField passwordfield=new PasswordField();
    passwordfield.setPromptText("Enter the password");
    Label user=new Label("Login as ");
    ComboBox as=new ComboBox();//combobox to choose the loging person
    as.getItems().addAll("Admin","Instructor","Student");
    as.setValue("Admin");//setting the value as admin defaultly
    Button submit=new Button("Login..");

    loginPane.setPrefSize(700,400);
      
    GridPane.setHalignment(submit, HPos.RIGHT);
    
    //handeling the event after clicking login
    submit.setOnAction(e->{
        //checking whether the user is admin and what to see if
         if(as.getValue().equals("Admin"))
             {
                 //default user name and password
                 if(email.getText().equals("Admin")&& passwordfield.getText().equals("admin"))
                    {
                    
      
                         AdminHomePage adminpage=new AdminHomePage();   //creating the object of AdminHome page 
 
                        Stage stage=new Stage();
                        adminpage.start(stage);
 //                       LoginForm.setLoggedInUser(email.getText());//calling setloggedinuser and pass through the user name while loging in
 //                         primaryStage.close();
                    }
                else{
        
                        JOptionPane.showMessageDialog(null, "User name or password incorect !");//when error in authentiction found
   
                }  
        
        
            }
         
    });
     Label loginHere = new Label("Login here");
     loginHere.getStyleClass().add("title");
     loginPane.getChildren().addAll(loginHere, username, email, password, passwordfield,
             user, as, submit);//positioning the nodes in a grid pane
     
  
         return loginPane;
 

  
         

     /* **********************************************************************************************************
    *********************************************************************************************************
   
    
    
    end of login form
    
    
    
    *********************************************************************************************************
    *********************************************************************************************************
    */ 
    
    
    
}
    VBox Signup()//signup function
   {
     /* **********************************************************************************************************
    *********************************************************************************************************
   
    
    
    start of signup form
    
    
    
    *********************************************************************************************************
    *********************************************************************************************************
    */ 
   
       
        VBox signUpPane=new VBox();
        signUpPane.getStyleClass().add("vbox");
      
        signUpPane.setPadding(new Insets(11.5, 12.5, 13.5,5));
    
        Label Fname=new Label("First name");
        TextField Fnamefield=new TextField();
        Fnamefield.setPromptText("Enter the first name");
        Label Lname=new Label("Sur name");
        TextField Lnamefield=new TextField();
        Lnamefield.setPromptText("Enter the Last name");
        Label gender=new Label("Gender");
        ComboBox select=new ComboBox();
        ObservableList<String> options =FXCollections.observableArrayList("Male","Female","Other");
        select.setItems(options);
        select.setValue("Male");
        Label Email=new Label("Email");
        TextField Emailfield=new TextField();
        Emailfield.setPromptText("Enter your email address");
        Label user=new Label("Signup as ");
        ComboBox signup_as=new ComboBox();
        signup_as.getItems().addAll("Admin","Instructor","Student");// choosing your status
        signup_as.setValue("Admin");
     
        

        signUpPane.setPrefSize(700,400);
      
        //GridPane.setHalignment(sign, HPos.RIGHT);
        Label register =new Label("Register here:");
        register.getStyleClass().add("title");
        signUpPane.getChildren().addAll(register,Fname, Fnamefield, Lname, Lnamefield, Email, Emailfield, gender,
                select, user,signup_as);
        
        VBox instructorForm = instructorForms();
        VBox studentForm = studentForms();
  
      
        signup_as.setOnAction(new EventHandler() //what to see according to your status
            {
                @Override
                 public void handle(Event e) {
                    if(signup_as.getValue().equals("Instructor"))//if your are instructor you have to fill as follow
                        {
                            signUpPane.getChildren().remove(studentForm);
                            
                            signUpPane.getChildren().add(instructorForm);
                                                  
                            signUpPane.requestLayout();
                        }
                    else if(signup_as.getValue().equals("Student")){
                        signUpPane.getChildren().remove(instructorForm);
                        signUpPane.getChildren().add(studentForm);
                        
                    }
                    else{
                        signUpPane.getChildren().remove(studentForm);
                        signUpPane.getChildren().remove(instructorForm);
                    }
                 }
            });
     
      
      return signUpPane;
      /* **********************************************************************************************************
    *********************************************************************************************************
   
    
    
    start of login form
    
    
    
    *********************************************************************************************************
    *********************************************************************************************************
    */ 
   }
    // instrictor addition forms
    VBox instructorForms(){
        
        /* **********************************************************************************************************
    
    instrictor addition forms
    
    *********************************************************************************************************
    */ 
        
        Label PhoneNumber=new Label("Phone number");
        TextField PhoneNumberfield=new TextField();
        PhoneNumberfield.setPromptText("Enter the phone number");
        Label Course=new Label("Course");
        TextField coursefield=new TextField();
        coursefield.setPromptText("Enter the Course");
        Label level=new Label("Level");
        TextField levelfield=new TextField();
        levelfield.setPromptText("Enter the Level");
        Label Password=new Label("Password");
        PasswordField passwordfield=new PasswordField();
        passwordfield.setPromptText("Enter the password");
        Label Password2=new Label("Verify Password");
        PasswordField verify=new PasswordField();
        verify.setPromptText("Enter the password");
        Button sign=new Button("Submit");
        
        VBox insPane = new VBox();
        
        insPane.getChildren().addAll(PhoneNumber, PhoneNumberfield, Course, coursefield,
                              level, levelfield, Password, passwordfield, Password2, verify, sign);
    
         return insPane;
         
              /* **********************************************************************************************************
    
             end of instrictor addition forms
    
    *********************************************************************************************************
    */ 
}
VBox studentForms(){
    
         /* **********************************************************************************************************
    
        student addition forms
    
    *********************************************************************************************************
    */ 
    Label stdClass = new Label("class you study in");
     TextField stdClassField = new TextField();
     ComboBox years=new ComboBox();//combobox to choose the loging person
     
     years.getItems().addAll((Object[]) classes);
     years.setValue("S1");
     Button submit = new Button("submit");
    VBox studentPane = new VBox(stdClass, stdClassField, years, submit);
    return studentPane;
     /* **********************************************************************************************************
    
       end of student addition forms
    
    *********************************************************************************************************
    */ 
}
    
    
}
