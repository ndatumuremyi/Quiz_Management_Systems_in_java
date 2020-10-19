package quizes;




import quizes.Project.Connections;
import java.awt.HeadlessException;
import java.sql.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
 
public class Add_Instructor extends Application{
 
    private final TableView<Instructor> table = new TableView<>();
    private final ObservableList<Instructor> data =
            FXCollections.observableArrayList(
            );
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    
    @Override
    public void start(Stage stage) {
        Group gr=new Group();
        Scene scene = new Scene(gr);
        scene.getStylesheets().add("quizes/LoginForm.css");
        gr.setAutoSizeChildren(true);
        stage.setTitle("Add an Instructor");
         stage.setWidth(700);
        stage.setHeight(1000);
        final Label label = new Label("Add Instructor");
        label.setFont(new Font("Arial", 30));
        
         label.setId("table");
        table.setEditable(true);
 
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Instructor, String>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Instructor, String>("lastName"));
 
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Instructor, String>("email"));
  TableColumn coursecol = new TableColumn("Course");
        coursecol.setMinWidth(100);
        coursecol.setCellValueFactory(
                new PropertyValueFactory<Instructor, String>("course"));
  TableColumn yearCol = new TableColumn("Year Level");
        yearCol.setMinWidth(50);
        yearCol.setCellValueFactory(
                new PropertyValueFactory<Instructor, String>("year"));
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,coursecol,yearCol);
 
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");
        final TextField addCourse=new TextField();
        addCourse.setPromptText("Course");
        addCourse.setMaxWidth(coursecol.getPrefWidth());
         final TextField addYear=new TextField();
        addYear.setPromptText("Year");
        addYear.setMaxWidth(yearCol.getPrefWidth());
        
        final Button addButton = new Button("Add"); 
    
        addButton.setOnAction((ActionEvent e) -> {
            boolean b=true;
            if(!isValid(addEmail.getText()))
            {
                b=false;
                JOptionPane.showMessageDialog(null, "Email is not Valid !");
            }
            if(addFirstName.getText().equals("")||addLastName.getText().length()<1|| 
                    addEmail.getText()==null || addCourse.getText()==null||addYear.getText()==null )
            {
                b=false;
                JOptionPane.showMessageDialog(null, "Please fill all the Fields !");
            }
            if(b==true){
                try{
                    
                    Connection con=Connections.getcon();
                    
                    Statement st= con.createStatement();
                    st.executeUpdate("INSERT INTO `instructors`(`FName`, `LName`, `Email`, `Course`, `Class`,`Phone_number`) VALUES"
                            + "('"+addFirstName.getText()+"','"+addLastName.getText()+"','"+addEmail.getText()+"','"+addCourse.getText()+"','"+addYear.getText()+"','0788722091')");
                    
                    JOptionPane.showMessageDialog(null, "inserted!");
                    
                }
                catch( HeadlessException | SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                data.add(new Instructor(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText(),
                        addCourse.getText(),
                        addYear.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
                addCourse.clear();
                addYear.clear();

            }
        });
 
        hb.getChildren().addAll(addFirstName, addLastName, addEmail,addCourse,addYear,addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        
        
        stage.show();
    }
 
  public static  class Instructor {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
 private final SimpleStringProperty course;
 private final SimpleStringProperty year;
        private Instructor(String fName, String lName, String email,String course,String year) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.course=new SimpleStringProperty(course);
            this.year=new SimpleStringProperty(year);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String em) {
            email.set(em);
        }
        
        public String getCourse() {
            return course.get();
        }
 
        public void setCourse(String courses) {
            course.set(courses);
        }
        
        public String getYear() {
            return year.get();
        }
 
        public void setYear(String y) {
            year.set(y);
        }
        
    }
  static boolean isValid(String email) {
      boolean result=true;
      try{
          InternetAddress emailAddress=new InternetAddress(email);
          emailAddress.validate();
      }
      catch(AddressException ex)
      {
          result=false;
      }
      return result;
   }

}
 
