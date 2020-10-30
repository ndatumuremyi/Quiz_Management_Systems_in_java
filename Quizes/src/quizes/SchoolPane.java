/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import DatabaseConfiguration.*;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author paterne
 */
public class SchoolPane extends VBox{
    DataOperations operations = new DataOperations();
    
    TableView<Schools> schoolTable = new TableView();
    ObservableList<Schools> schools = FXCollections.observableArrayList(operations.selectAll("schools"));
    ObservableList<String> headMastersNames = FXCollections.observableArrayList();
    ArrayList<HeadMaster> headMasters= new ArrayList<>(operations.selectAll("headmaster"));
    HashMap<String, String> corresponding = new HashMap<>();
    
    TextField shId = new TextField();
    TextField schoolName = new TextField();
    ComboBox<String> headMasterName = new ComboBox<>();
    TextField provence = new TextField();
    TextField district = new TextField();
    TextField sector = new TextField();
    TextField cell = new TextField();
    TextField type = new TextField();
    
    Button save = new Button("Save and add New");
    
    HBox addPane = new HBox();
    
    SchoolPane(){
        shId.setPromptText("Enter School id");
        schoolName.setPromptText("Enter SchoolName");
        headMasters.forEach((headMaster) ->{
            String names = headMaster.getFirstName()+" "+ headMaster.getLastName();
            headMastersNames.add(names);
            corresponding.put(names, headMaster.getHmId());
            
        });
        
        headMasterName.setItems(headMastersNames);
        provence.setPromptText("Enter Provence");
        district.setPromptText("Enter District");
        sector.setPromptText("Enter sector");
        cell.setPromptText("Enter Cell");
        type.setPromptText("Enter type");
        
        addSelf();
        
        for(String valiable : Schools.getValiables()){
            TableColumn<Schools, String> column = new TableColumn<>(valiable);
            column.setCellValueFactory(new PropertyValueFactory<>(valiable));
            
            schoolTable.getColumns().add(column);
        }
        schoolTable.setEditable(true);
        schoolTable.setItems(schools);
        
        save.setOnAction(ev ->{
            Schools school = new Schools();
            
            school.setCell(cell.getText());
            school.setDistrict(district.getText());
            school.setHeadMasterId(corresponding.get(headMasterName.getValue()));
            school.setProvence(provence.getText());
            school.setSchoolName(schoolName.getText());
            school.setSector(sector.getText());
            school.setShId(shId.getText());
            school.setType(type.getText());
            
            school.save();
            schools.add(school);
        });
        
        
    }
    private void addSelf(){
         addPane.getChildren().addAll(cell, district, provence, schoolName, sector, shId, type, headMasterName, save);
         getChildren().addAll(schoolTable, addPane);
         
        }
    
}
