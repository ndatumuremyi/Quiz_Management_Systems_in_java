

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
 
 public class LoginForm extends Application {
    public Button bt=new Button("Close",new ImageView("image/close Jframe.png"));
  private String loggedInUser;

 private Stage primaryStage=new Stage();
     @Override
     public void start(Stage primaryStage) 
     {
     this.primaryStage=primaryStage;
      
        BorderPane allpage=new BorderPane();// border pane to take all layouts of the page 
 Label label1=new Label("Quiz Management System");//head
 label1.setId("title");
 label1.setMinWidth(primaryStage.getMinWidth());
  label1.setTextFill(Color.rgb(255, 255, 255));
label1.setPadding(new Insets(1,4,15,50));
 allpage.setTop(label1);
 allpage.setLeft(login());
allpage.setBottom(getBanner());//seting the positions of all nodes into the borderpane
 allpage.setRight(Signup());
   allpage.setId("border");
       
         Scene scene = new Scene(allpage, 1500, 700);
         scene.getStylesheets().add("LoginForm.css");//linking to external css file
         primaryStage.setTitle("Lgin Form");
        primaryStage.setScene(scene);
       
        primaryStage.show();
    }

 StackPane getBanner()// function that provides the description
 {
        StackPane about=new StackPane();
         TextArea description=new TextArea();
         description.setText(description.getText()+"\t\t \t\t In these days the learning procedures has been totally changed\n "
                 + "\t\t \t\t Now we are accessing all courses and quizes without the need of face to face meeting \n\n"
                 + " \t\t \t\t Through this Application Student can remotely do the quizes assigned by their teachers remotely\n\n  \t\t \t\t You all welcome to this app Whoever you are... ");
        about.getChildren().add(description);
        description.setId("text");
description.setEditable(false);
        about.setId("banner");
        
        
     
        
        return about;
 }
   GridPane login() // a function for logingin 
  
     {
        
      
      GridPane loginpane=new GridPane();
      loginpane.setAlignment(Pos.CENTER);
   loginpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    loginpane.setHgap(5.5);
   loginpane.setVgap(5.5);
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

      loginpane.setPrefSize(700,400);
      
      GridPane.setHalignment(submit, HPos.RIGHT);
   
     submit.setOnAction(e->//handeling the event after clicking login
     {
         if(as.getValue().equals("Admin"))//checking whether the user is admin and what to see if 
         {
         if(email.getText().equals("Admin")&& passwordfield.getText().equals("admin"))//default user name and password
       {
      
 AdminHomePage adminpage=new AdminHomePage();   //creating the object of AdminHome page 
 
 Stage stage=new Stage();
 adminpage.start(stage);
 setLoggedInUser(email.getText());//calling setloggedinuser and pass through the user name while loging in
 primaryStage.close();
       }
          else{
        
     JOptionPane.showMessageDialog(null, "User name or password incorect !");//when error in authentiction found
   
          }  
        
        
         }
         
     });
     loginpane.add(new Label("Login here"),0,0);//positioning the nodes in a grid pane
     loginpane.add(username,0,1);
      loginpane.add(email,1,1);
       loginpane.add(password,0,2);
        loginpane.add(passwordfield,1,2);

        loginpane.add(user, 0, 3);

           loginpane.add(as, 1, 3);
                 loginpane.add(submit, 2, 3);
  
         return loginpane;
  
         
     }
   GridPane Signup()//signup function
   {
       
          GridPane signuppane=new GridPane();
      signuppane.setAlignment(Pos.CENTER);
    signuppane.setPadding(new Insets(11.5, 12.5, 13.5,5));
    signuppane.setHgap(5.5);
   signuppane.setVgap(5.5);
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

     signuppane.setPrefSize(700,400);
      
      GridPane.setHalignment(sign, HPos.RIGHT);
      Label regist =new Label("Register here:");
      regist.setTextFill(Color.DARKCYAN);
        signuppane.add(regist,1,0);
  signuppane.add(Fname,0,1);
      signuppane.add(Fnamefield,1,1);
      signuppane.add(Lname, 2, 1);
      signuppane.add(Lnamefield, 3, 1);
      signuppane.add(Email, 0, 2);
      signuppane.add(Emailfield, 1, 2);
      signuppane.add(gender, 2, 2);
      signuppane.add(select,3,2);
      signuppane.add(user, 0, 3);
      signuppane.add(signup_as, 1, 3);
      
      signup_as.setOnAction(new EventHandler() //what to see according to your status
      {
              @Override
              public void handle(Event e) {
                  if(signup_as.getValue().equals("Instructor"))//if your are instructor you have to fill as follow
                  {
                      signuppane.add(PhoneNumber, 0, 4);
                      signuppane.add(PhoneNumberfield, 1, 4);
                      signuppane.add(Course, 2, 4);
                      signuppane.add(coursefield, 3, 4);
                      signuppane.add(level, 0, 5);
                      signuppane.add(levelfield, 1, 5);
                      signuppane.add(Password, 2, 5);
                      signuppane.add(passwordfield, 3, 5);
                      signuppane.add(Password2, 0, 6);
                      signuppane.add(verify, 1, 6);
                      signuppane.add(sign, 2, 6);
                      signuppane.requestLayout();
                  }       }
          });
     
      
      return signuppane;
   }

       
           
       
   
   
  public void setLoggedInUser(String user)//returns the person that loggedin
  {
       loggedInUser = user;
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Successful login");
       alert.setHeaderText("Successful login");
       String s = user + " logged in!";
       alert.setContentText(s);
       alert.show();
  }
  
     public static void main(String[] args) {
        launch(args);
    }
 }
     /**
      * @param args the command line arguments
      */
