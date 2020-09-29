/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

/**
 *
 * @author Kwizera
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class Quizes extends Application{
    @Override
    public void start(Stage window){
        MainMenu mainMenu = new MainMenu();
        
        BorderPane pane = new BorderPane();
        pane.setTop(mainMenu);
        
        pane.setBottom(new Label("hello"));
        Scene scene = new Scene(pane);
        window.setTitle("quiz main");
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
        // TODO code application logic here
    }
    
}
