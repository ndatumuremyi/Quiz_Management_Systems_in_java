/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import DatabaseConfiguration.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kwizera
 */
public final class Admin {

    DataOperations operations = new DataOperations();

    TabPane AdminTabs = new TabPane();
    TabPane InstaTabPane = new TabPane();
    Tab InstructorTab = new Tab("Instructor");
    Tab StudentTab = new Tab("Student");
    Tab HeadMasterTab = new Tab("HeadMaster");
    Tab LevelsTab = new Tab("School Levels");
    Tab schoolsTab = new Tab("Schools");

    Label Students = new Label("Student Description");
    Label addStudent = new Label("Add_Student");
    Label updateStudent = new Label("update_Student");
    Label deleteStudent = new Label("Delete_Student");
    Label Headmasters = new Label("HeadMaster Description");
    Label addHeadmaster = new Label("Add_HeadMaster");
    Label updateHeadMaster = new Label("update_HeadMaster");
    Label deleteHeadmaster = new Label("Delete_HeadMaster");
    Tab instructor = new Tab("Instructor Description");
    Tab addinstructor = new Tab("Add_Instructor");
    Tab updateinstructor = new Tab("update_instructor");
    Tab deleteInst = new Tab("Delete_instructor");
    MenuBar AdminMenu = new MenuBar();
    // file menu
    Menu fileMenu = new Menu("file");

    //file menu items
    MenuItem exit = new MenuItem("Exit");
    MenuItem logout = new MenuItem("Logout");
    // view menu
    Menu viewMenu = new Menu("view");

    // view menu items
    MenuItem zoomIn = new MenuItem("zoom in");
    MenuItem zoomOut = new MenuItem("zoom out ");
    MenuItem Manage = new MenuItem("Manage Users");
    // help menu
    Menu help = new Menu("help");

    // about us 
    Menu aboutUs = new Menu("about Us");

    public Admin() {
        Tab[] InstMenu = {instructor, addinstructor, updateinstructor, deleteInst};

        for (Tab menu : InstMenu) {
            menu.setId("menu");

            InstaTabPane.getTabs().add(menu);
        }
        InstructorTab.setContent(InstaTabPane);
        Label[] StudentMenu = {Students, addStudent, updateStudent, deleteStudent};
        HBox Studenthbox = new HBox();
        for (Label menu : StudentMenu) {
            menu.setId("menu");
            HBox.setMargin(menu, new Insets(0, 0, 0, 15));
            Studenthbox.getChildren().add(menu);

        }
        StudentTab.setContent(Studenthbox);

//        Label[] HeadmasterMenu = {Headmasters, addHeadmaster, updateHeadMaster, deleteHeadmaster};
        HBox headMasterBody = new HBox();
//        for (Label menu : HeadmasterMenu) {
//            menu.setId("menu");
//
//            HBox.setMargin(menu, new Insets(0, 0, 0, 15));
//            headMasterBody.getChildren().add(menu);
//
//        }

        headMasterBody.getChildren().add(new HeadMasterPane());
        HeadMasterTab.setContent(headMasterBody);

        try {
            LevelsTab.setContent(new AddLevel().getTabeldisplayed());
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        schoolsTab.setContent(new SchoolPane());
        AdminTabs.getTabs().addAll(HeadMasterTab, InstructorTab, StudentTab, LevelsTab, schoolsTab);
        InstMenu[1].setContent(new Add_Instructor().AddInst());

        addItems();
        AdminMenu.getMenus().addAll(viewMenu, aboutUs, help, fileMenu);

    }

    public TabPane GetTabs() {
        return AdminTabs;
    }

    public MenuBar GetMenuBar(Stage stage, BorderPane borderpane) {

        logout.setOnAction((ActionEvent e) -> {
            new GetUserName().Logout(stage);
        });
        exit.setOnAction(e
                -> {
            int a = JOptionPane.showConfirmDialog(null, "Do you realy want to close", "Closing Prompt", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                JOptionPane.showMessageDialog(null, "Closing app..");
                System.exit(0);
            }

        }
        );
        Manage.setOnAction(e -> borderpane.setCenter(GetTabs()));
        return AdminMenu;
    }

    public void addItems() {

        fileMenu.getItems().addAll(exit, logout);
        viewMenu.getItems().add(Manage);

    }

}

//        AdminTabs.getTabs().addAll(HeadMasterTab, InstructorTab, StudentTab);
//        addinstructor.setOnMousePressed((MouseEvent e) -> {
//            Add_Instructor inst = new Add_Instructor();
//            Stage instStage = new Stage();
//            instStage.setX(350);
//            instStage.setY(160);
//            instStage.setWidth(500);
//            instStage.setWidth(700);
//            inst.start(instStage);
//        });
//
//        addItems();
//        AdminMenu.getMenus().addAll(viewMenu, aboutUs, help, fileMenu);
//
//    }
//
//    public TabPane GetTabs() {
//        return AdminTabs;
//    }
//
//    public MenuBar GetMenuBar(Stage stage, BorderPane borderpane) {
//
//        logout.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                new GetUserName().Logout(stage);
//            }
//        });
//        exit.setOnAction(e
//                -> {
//            int a = JOptionPane.showConfirmDialog(null, "Do you realy want to close", "Closing Prompt", JOptionPane.YES_NO_OPTION);
//            if (a == 0) {
//                JOptionPane.showMessageDialog(null, "Closing app..");
//                System.exit(0);
//            }
//
//        }
//        );
//        Manage.setOnAction(e -> borderpane.setCenter(GetTabs()));
//        return AdminMenu;
//    }
//
//    public void addItems() {
//
//        fileMenu.getItems().addAll(exit, logout);
//        viewMenu.getItems().add(Manage);
//
//    }
//
//}
