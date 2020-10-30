/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import DatabaseConfiguration.*;
import DatabaseConfiguration.HeadMaster;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
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
public class HeadMasterPane extends VBox {

    DataOperations operations = new DataOperations();

    TabPane headMasterTabs = new TabPane();
    ArrayList<TableColumn> columns = new ArrayList<>();
    TableView<HeadMaster> headMasterTable = new TableView<>();
    ObservableList<HeadMaster> headMasters = FXCollections.observableArrayList(operations.selectAll("headmaster"));
    
    TextField firstName = new TextField();
    TextField lastName = new TextField();
    TextField nationalId = new TextField();
    TextField sex = new TextField();
    TextField degree = new TextField();
    TextField tel = new TextField();
    
    
    Button save = new Button("Save and add New");
    
    HBox addPane = new HBox();
    
    HeadMasterPane() {
        firstName.setPromptText("Enter FistName");
        lastName.setPromptText("Enter LastName");
        nationalId.setPromptText("Enter National Id");
        sex.setPromptText("Enter Sex");
        degree.setPromptText("enter Degree");
        tel.setPromptText("Enter telephone number");

        for (String i : HeadMaster.getValiables()) {
            TableColumn<HeadMaster, String> column = new TableColumn<>(i);
            column.setCellValueFactory(new PropertyValueFactory<>(i));
            columns.add(column);
        }

        
        headMasterTable.setEditable(true);

        columns.forEach((column) -> {
            headMasterTable.getColumns().add(column);
        });
        headMasterTable.setItems(headMasters);
        
        addPane.getChildren().addAll(firstName, lastName, nationalId, degree, sex, tel, save);
        addSelf();
        
        save.setOnAction(ev ->{
            HeadMaster headMaster = new HeadMaster();
            
            headMaster.setFirstName(firstName.getText());
            headMaster.setLastName(lastName.getText());
            headMaster.setNationalId(nationalId.getText());
            headMaster.setDegree(degree.getText());
            headMaster.setSex(sex.getText());
            headMaster.setTel(tel.getText());
            
            headMaster.save();
            headMasters.add(headMaster);
        });
        
        
        
    }
    private void addSelf(){
        
        getChildren().add(headMasterTable);
        getChildren().add(addPane);
        
    }
    
}
