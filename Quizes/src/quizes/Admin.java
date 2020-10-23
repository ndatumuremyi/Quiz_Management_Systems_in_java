/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Kwizera
 */
public class Admin
{
    TabPane AdminTabs=new TabPane();
    Tab InstructorTab=new Tab("Instructor");
    Tab StudentTab = new Tab("Student");
    Tab HeadMasterTab=new Tab("HeadMaster");
    
Label instructor=new Label("Instructor Description");
Label addinstructor=new Label("Add_Instructor");
Label updateinstructor=new Label("update_instructor");
Label deleteInst=new Label("Delete_instructor");
Label Students=new Label("Student Description");
Label addStudent=new Label("Add_Student");
Label updateStudent=new Label("update_Student");
Label deleteStudent=new Label("Delete_Student");
Label Headmasters=new Label("HeadMaster Description");
Label addHeadmaster=new Label("Add_HeadMaster");
Label updateHeadMaster=new Label("update_Student");
Label deleteHeadmaster=new Label("Delete_HeadMaster");
    public Admin()
    {
        Label[] InstMenu = {instructor ,addinstructor,updateinstructor,deleteInst};
       HBox InstHbox=new HBox();
for (Label menu: InstMenu) 
{
    menu.setId("menu");
    HBox.setMargin(menu, new Insets(0, 0, 0, 15));
    InstHbox.getChildren().add(menu);
 
    }
InstructorTab.setContent(InstHbox);
     Label[] StudentMenu = {Students ,addStudent,updateStudent,deleteStudent};
      HBox Studenthbox=new HBox();  
for (Label menu: StudentMenu) {
    menu.setId("menu");
    HBox.setMargin(menu, new Insets(0, 0, 0, 15));
    Studenthbox.getChildren().add(menu);

    }
 StudentTab.setContent(Studenthbox);
    Label[] HeadmasterMenu = {Headmasters ,addHeadmaster,updateHeadMaster,deleteHeadmaster};
      HBox hb=new HBox();    
for (Label menu:HeadmasterMenu ) {
    menu.setId("menu");
  
    HBox.setMargin(menu, new Insets(0, 0, 0, 15));
 hb.getChildren().add(menu);
 
    }  
HeadMasterTab.setContent(hb);
AdminTabs.getTabs().addAll(HeadMasterTab,InstructorTab,StudentTab);
addinstructor.setOnMousePressed((MouseEvent e) -> {
     Add_Instructor inst=new Add_Instructor();
     Stage instStage=new Stage();
     instStage.setX(350);
     instStage.setY(160);
     instStage.setWidth(500);
     instStage.setWidth(700);
     inst.start(instStage);
     });
    }
    
    public TabPane GetTabs()
    {
       return  AdminTabs;
    }
}
