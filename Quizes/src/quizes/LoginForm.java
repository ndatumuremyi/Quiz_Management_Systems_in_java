package quizes;

import java.sql.SQLException;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginForm extends Application {

    public Button bt = new Button("Close");
    private String loggedInUser; //this valiable store logged in user

    public Stage primaryStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws SQLException {
        this.primaryStage = primaryStage;

        BorderPane allpage = new BorderPane();// border pane to take all layouts of the page 

        Label title = new Label();//head
        title.setId("mainTitle");
        title.setMinWidth(primaryStage.getMinWidth());
        Pane footer = footer();
        footer.getStyleClass().add("footer");
        MainMenu mainmenu = new MainMenu(); //menu
        Forms forms = new Forms();
        allpage.setTop(mainmenu);
        allpage.setLeft(forms.login(primaryStage));
        allpage.setBottom(footer);//seting the positions of all nodes into the borderpane
        allpage.setRight(forms.Signup());
        allpage.setId("border");

        ScrollPane scroll = new ScrollPane(allpage);

        Scene scene = new Scene(scroll, 1500, 700);
        scene.getStylesheets().add("quizes/style.css");//linking to external css file
        primaryStage.setTitle("Lgin Form");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    StackPane footer()// function that provides the description
    {
        StackPane about = new StackPane();
        TextArea description = new TextArea();
        description.setText(description.getText() + "\t\t \t\t In these days the learning procedures has been totally changed\n "
                + "\t\t \t\t Now we are accessing all courses and quizes without the need of face to face meeting \n\n"
                + " \t\t \t\t Through this Application Student can remotely do the quizes assigned by their teachers remotely\n\n  \t\t \t\t You all welcome to this app Whoever you are... ");
        about.getChildren().add(description);
        description.setId("text");
        description.setEditable(false);
        about.setId("banner");

        return about;

    }

    // a function for logingin
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

    public void closewindow() {
        this.primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
