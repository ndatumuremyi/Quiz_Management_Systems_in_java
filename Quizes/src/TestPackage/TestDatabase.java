/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

/**
 *
 * @author paterne
 */
import DatabaseConfiguration.DataOperations;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import DatabaseConfiguration.HeadMaster;
import java.util.ArrayList;
import javafx.scene.control.Button;


public class TestDatabase extends Application{
    @Override
    public void start(Stage stage){
        BorderPane pane = new BorderPane();
        Button btn = new Button("insert");
        //HeadMaster headMaster = new HeadMaster("serge", "Nm", "144121121", "M", "A1", "0786634007");
        ArrayList<HeadMaster> array = new ArrayList<>();
        DataOperations data = new DataOperations();
        array = data.selectAll("headmaster");
        System.out.println(array.get(0).getFirstName());
        btn.setOnAction(ev->{
            //headMaster.save();
        });
        pane.setCenter(btn);
        Scene scene = new Scene(pane);
        stage.setTitle("data");
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String args[]){
        launch();
    }
}
