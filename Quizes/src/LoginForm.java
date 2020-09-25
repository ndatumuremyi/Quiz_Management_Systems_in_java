
 import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Checkbox;
import java.util.Optional;

 import javafx.application.Application;
 import javafx.event.ActionEvent;
 import javafx.event.EventHandler;
import javafx.geometry.HPos;

 import javafx.geometry.Insets;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
import javafx.scene.control.Alert;

 import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

 import javafx.scene.control.Label;
 import javafx.scene.control.PasswordField;
 import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
 
 public class LoginForm extends Application {
    public Button bt=new Button("Close",new ImageView("image/close Jframe.png"));
  private String loggedInUser;
 public  Label student=new Label("Student");
public Label instructor=new Label("Instructor");
 private final Label admin=new Label("Admin");
 private Stage primaryStage=new Stage();
     @Override
     public void start(Stage primaryStage) {
     this.primaryStage=primaryStage;
      
        BorderPane border=new BorderPane();
 Label label1=new Label("Quiz Management System");
 label1.setId("title");
  label1.setTextFill(Color.rgb(255, 255, 255));
label1.setPadding(new Insets(1,4,15,50));
 border.setTop(label1);
 border.setCenter(getNav());
 //border.setBottom(getBanner());
   border.setId("border");
       
         Scene scene = new Scene(border, 1500, 700);
         scene.getStylesheets().add("LoginForm.css");
         primaryStage.setTitle("Lgin Form");
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true);
          //primaryStage.setFullScreenExitHint("out");
        primaryStage.show();
    }
 private   HBox getNav()
    {
     HBox hBox = new HBox(15);
 hBox.setPadding(new Insets(15, 15, 15, 15));
 

Label[] Users = {student,instructor ,admin};
for (Label user: Users) {
    user.setId("labels");
 HBox.setMargin(user, new Insets(0, 0, 0, 15));
 hBox.getChildren().add(user);
    }

bt.setOnMousePressed(e->Close(primaryStage));
 
hBox.getChildren().add(bt);
hBox.setId("nav");
bt.setTextFill(Color.RED);
bt.setAlignment(Pos.TOP_RIGHT);
bt.setId("close");
 student.setOnMouseClicked(e->login(student));
  instructor.setOnMouseClicked(e->login(instructor));
   admin.setOnMouseClicked(e->login(admin));
 

         return hBox;
         
     }
 HBox getBanner(){
        HBox pn=new HBox();
         
       ImageView imageView = new ImageView(new Image("image/banner.png"));
        pn.setBackground(Background.EMPTY);
        pn.getChildren().add(imageView);
        pn.setId("banner");
        
      
        return pn;
 }
   public Label login(Label lb)
  
     {
        Stage st=new Stage();
        
      GridPane pane=new GridPane();
      pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    pane.setHgap(5.5);
   pane.setVgap(5.5);
      Label username=new Label("UserName");
   TextField tx1=new TextField();
    tx1.setPromptText("Enter the user name");
   
      Label password=new Label("Password");
      PasswordField pass=new PasswordField();
      pass.setPromptText("Enter the password");
      //Label showpassword=new Label("Show password");
     //CheckBox show=new CheckBox();
      
      Button submit=new Button("Submit");

      pane.setPrefSize(700,400);
      
      GridPane.setHalignment(submit, HPos.RIGHT);
    /*show.setOnAction(e->{
  
        if(show.isSelected())
        {
         if(show.isSelected()){
            
           pass.setPromptText(pass.getText());
           pass.setText("");
           pass.setDisable(true);
           
            
        }
        else
        {
           pass.setText(pass.getPromptText());
           pass.setPromptText(""); 
           pass.setDisable(false);
        }
        }
    });
  try{
    Connection con=Connections.getcon();
    }
    catch(Exception ex)
    {
        
    } */
     submit.setOnAction(e->{
         if(lb==admin)
         {
      
         if(tx1.getText().equals("Admin")&& pass.getText().equals("admin"))
       {
      
 AdminHomePage adminpage=new AdminHomePage();   
 
 Stage stage=new Stage();
 adminpage.start(stage);
 setLoggedInUser(tx1.getText());
 primaryStage.close();
       }
          else{
        
     JOptionPane.showMessageDialog(null, "User name or password incorect !");
   
          }  
        
        st.close();
     
         }
     });
     
  if(lb==admin){
     pane.add(username,0,0);
      pane.add(tx1,1,0);
       pane.add(password,0,1);
        pane.add(pass,1,1);
      //  pane.add(showpassword,0,2);
       // pane.add(show,1,2);
        pane.add(submit, 0, 2);
  }
  else
  {
      Label createacount=new Label("Don't have acount ?");
       Label create=new Label("Signup");
       create.setId("signup");
       create.setTextFill(Color.BURLYWOOD);
    pane.add(username,0,0);
      pane.add(tx1,1,0);
       pane.add(password,0,1);
        pane.add(pass,1,1);
      //  pane.add(showpassword,0,2);
        //pane.add(show,1,2);
        pane.add(submit, 2, 2);
        pane.add(createacount,0,3);
        pane.add(create,1,3);
         create.setOnMousePressed(e->{
             Signup signup=new Signup();
             Stage stage=new Stage();
             signup.start(stage);
         });
  }
       Scene scene = new Scene(pane, 400, 250);
       
        boolean add = scene.getStylesheets().add("LoginForm.css");
         st.setTitle("Lgin Form");
         st.setScene(scene);
       st.centerOnScreen();
         st.show();
        return lb; 
     }
   public void Close(Stage st)
   {
       
   
       JOptionPane.showMessageDialog(null, "App is closed !");
           st.close();  
       }
       
         
   
       
           
       
   
   
  public void setLoggedInUser(String user) {
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
