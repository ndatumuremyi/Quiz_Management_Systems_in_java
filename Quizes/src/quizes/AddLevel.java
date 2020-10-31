/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import DatabaseConfiguration.DataOperations;
import DatabaseConfiguration.Levels;
import java.sql.*;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javax.swing.JOptionPane;


/**
 *
 * @author Kwizera
 */
public class AddLevel 
{
    private final TableView<Levels> LevelTabel=new TableView<>();
 
 
    private final ObservableList<Levels> data= FXCollections.observableArrayList(new DataOperations().selectAll("levels") );
   final Label label = new Label("Add Class Level ");
    
final HBox hb = new HBox();
final VBox vbox = new VBox();
  Group group=new Group();
        Scene scene = new Scene(group);
       
  AddLevel() throws SQLException
  { 
      scene.getStylesheets().add("quizes/LoginForm.css");
        group.setAutoSizeChildren(true);
      
      label.setFont(new Font("Arial", 30)); 
      label.setId("table");
       LevelTabel.setEditable(true);
       TableColumn Name=new TableColumn("Level Name");
       Name.setMinWidth(100);
       Name.setCellValueFactory(new PropertyValueFactory<Level,String>("levelName"));
        TableColumn NameInFull;
        NameInFull = new TableColumn(" Level Name inFull");
       NameInFull.setMinWidth(200);
       NameInFull.setCellValueFactory(new PropertyValueFactory<Level,String>("inFull"));  
       LevelTabel.getColumns().addAll(Name,NameInFull);
       LevelTabel.setItems(data);
     
       final TextField Leveltextfield=new TextField();
       Leveltextfield.setPromptText("Enter the new Level");
       Leveltextfield.setMinWidth(Name.getPrefWidth());
       final TextField Leveldescription=new TextField();
       Leveldescription.setPromptText("Enter the Level Description");
       Leveldescription.setMinWidth(NameInFull.getPrefWidth());
       final Button AddAndSave=new Button("Add And Save");
       AddAndSave.setOnAction(e->{
          // DataOperations dataoperations=new DataOperations();
          // ArrayList<String> Variabels=new ArrayList<>();
           //Variabels.add("LevelName");
          // Variabels.add("InFull");
          // ArrayList<String> Values=new ArrayList<>();
          // Values.add(Leveltextfield.getText());
           //Values.add(Leveldescription.getText());
           Levels Level=new Levels(Leveltextfield.getText(),Leveldescription.getText());
           int ask=JOptionPane.showConfirmDialog(null, "Do you want to add level ?","Confirm!",JOptionPane.YES_NO_OPTION);
           if(ask==0){
           data.add(Level);
           Level.save();
          // dataoperations.insert("levels",Variabels, Values);
           Leveltextfield.clear();
           Leveldescription.clear();
           }
       });
      
      hb.getChildren().addAll(Leveltextfield,Leveldescription,AddAndSave);
      vbox.getChildren().addAll(label,LevelTabel,hb);
      
      
  }
  public Group getTabeldisplayed()
  {
      ((Group) scene.getRoot()).getChildren().addAll(vbox);
    
     return group;
  }

  
}

