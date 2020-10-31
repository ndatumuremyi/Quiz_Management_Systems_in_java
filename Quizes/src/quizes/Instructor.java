/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author THERESE
 */
public class Instructor extends Application {
     int i = 0;
    @Override
    public void start(Stage primaryStage){
        
        BorderPane panee = new BorderPane();
        
        MenuBar menuBar = new MenuBar();
        Menu home = new Menu("Home");
        Menu uploadedAnswers = new Menu("Students Uploaded Answers");
        menuBar.getMenus().addAll(home,uploadedAnswers);
        menuBar.setId("menubar");
        MenuItem quizManagement= new MenuItem("Quiz Management");  
        home.getItems().add(quizManagement);
        MenuItem newUploadedAnswers= new MenuItem("New Uploaded Answers");  
        uploadedAnswers.getItems().add(newUploadedAnswers);
        MenuItem pastUploadedAnswers= new MenuItem("Past Uploaded Answers");  
        uploadedAnswers.getItems().add(pastUploadedAnswers);
        HBox hbMenubar = new HBox();
        hbMenubar.getChildren().add(menuBar);
         panee.setLeft(hbMenubar);
          Menu settings = new Menu("Settings");
        Menu exit = new Menu("Exit");
         MenuBar menuBarr = new MenuBar();
        menuBarr.getMenus().addAll(settings,exit);
        HBox hbbMenubarr = new HBox();
         hbbMenubarr.getChildren().add(menuBarr);
         panee.setRight(hbbMenubarr);
        settings.setId("settings");
        panee.setId("background");
        Label label = new Label("Quiz Management System");
        
        
        
        
        
        label.setId("lab");
        panee.setCenter(label);
        quizManagement.setOnAction(e->panee.setBottom(GetTabs()));
        
       Scene scene = new Scene(panee,1500,700);
        
        
        
        primaryStage.setScene(scene);
        scene.getStylesheets().add("Quizes/Instructor.css");
        primaryStage.show();
    }
    public  static  void main(String[] args){
        launch(args);
    }
    //giving quiz page method
    public AnchorPane Anchor(){
         Pagination pagination = new Pagination(28, 0);
        pagination.setStyle("-fx-border-color:red;");
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(pageIndex);
            }
        });
       
        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);
        
        
        
        
         return anchor;
    }
    public BorderPane borderPane(){
        BorderPane pane = new BorderPane();
        
         StackPane about = new StackPane();
         
        TextArea description = new TextArea();
        description.setMinHeight(15);
        
        description.setText(description.getText() + "\t\t \t\t This is Your Page for setting quiz to your students\n "
                + "\t\t \t\t And setting the deadline of their work \n"
                + " \t\t \t\t And for checking their marks and prepare well their report easily\n\n  \t\t \t\t  ");
        about.getChildren().add(description);
        description.setId("text");
        description.setEditable(false);
        about.setId("banner");
        
        
        pane.setBottom(about);
         VBox vbox1 = new VBox();
        
        pane.setTop(vbox1);
        
        
        
        
        
        
        
        
        Button button = new Button("Your Classes");
      
      //Creating a context menu
      ContextMenu contextMenu = new ContextMenu();
      //Creating the menu Items for the context menu
      MenuItem item1 = new MenuItem("posts");
      MenuItem item2 = new MenuItem("List Of Students");
      MenuItem item3 = new MenuItem("Attended students");
      MenuItem item4 = new MenuItem("Students who did preious Quizes");
      MenuItem item5 = new MenuItem(" Students Results");
      MenuItem item6 = new MenuItem("Students ");
      contextMenu.getItems().addAll(item1, item2,item3,item4, item5,item6);
      //Adding the context menu to the button 
      
      button.setContextMenu(contextMenu);
      HBox layout = new HBox(20);
      layout.setPadding(new Insets(15, 15, 300, 15));
      layout.getChildren().addAll( button);

        pane.setLeft(layout);
        
        VBox vbox = new VBox();
        Label lecture = new Label("Lecture");
        Label instructorName = new Label("Instructor name|Lecture|Grade");
        Label led = new Label("Start giving your quiz by here on this page go to quiz giving");
        instructorName.setId("entere");
        led.setId("entered");
        lecture.setId("EnteredName");
        vbox.getChildren().addAll(lecture,instructorName);
        vbox.getChildren().add(led);
        pane.setCenter(vbox);
        vbox.setId("box");
        DropShadow shadow = new DropShadow();
        vbox.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e)->{
            vbox.setEffect(shadow); });
        vbox.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e)-> {
           vbox.setEffect(null);});
        MenuBar menuBar = new MenuBar();
        Menu classes = new Menu("Classes");
        Menu library = new Menu("Library");
        menuBar.getMenus().addAll(classes,library);
        HBox hb = new HBox();
        hb.getChildren().add(menuBar);
        pane.setTop(hb);
        
        VBox view = new VBox();
        Label vi  = new Label("View all ClassWork");
        TextField vie = new TextField("View all ClassWork");
        view.getChildren().addAll(vi,vie);
        pane.setRight(view);
        view.setId("view");
       return pane; 
    }
    public TabPane GetTabs(){
        TabPane pane = new TabPane();
        Tab tab1 = new Tab("Home");
        tab1.setContent(borderPane());
       
        Tab tab2 = new Tab("quiz giving");
        tab2.setContent(Anchor());
        
        pane.getTabs().addAll(tab1,tab2);
        return pane;
    }
    
    public int itemsPerPage() {
        return 8;
    }
 
    public GridPane createPage(int pageIndex) {
         GridPane anchorr = new GridPane();
        int page = (pageIndex-6);
        for (int i = page; i <page + itemsPerPage();i++) {
           
           
            Label label = new Label("New Quiz");
         Hyperlink label1 = new Hyperlink("Question" + i );
       label1.setVisited(true);
       
        
        TextField question1 = new TextField();
       
        question1.setId("question1" );
        
        
        Label label2 = new Label("Responses" );
       
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("Multiplechoice");
        comboBox.getItems().add("Uploading questions files");
        comboBox.getItems().add("written question answering");
        HBox hbox = new HBox(comboBox);
        
       
        Button adding = new Button("Add Response");
        VBox vbox = new VBox();
        
        
         
       
         adding.setOnAction(e -> {
        HBox vbox12 = new HBox();
        CheckBox  checkBox = new CheckBox();
        TextField textField = new TextField();
        textField.setPromptText("Add another choice");
         vbox12.getChildren().addAll(checkBox,textField);
        
         
        
        
        
        vbox.getChildren().add(vbox12);
       
        
        
    });
         anchorr.add(vbox,0,8);

                      
         anchorr.add(label,0,0);
         anchorr.add(question1, 0, 2);
         anchorr.add(label1, 0, 1 );
          anchorr.add(label2, 0, 3 );
         
        
        
         
         anchorr.add(hbox, 6, 2);
        
         
         anchorr.add(adding,0,18);
         anchorr.setAlignment(Pos.CENTER);
         
       
         
       
         label.setId("title");
         label1.setId("type");
         label2.setId("type");
         
         
        anchorr.setId("pane");
            
            //Hyperlink link = new Hyperlink( + (i+1));
            //vboxs.setVisited(true);
            //Label text = new Label("Search results\nfor "+ link.getText());
            //element.getChildren().addAll(vboxs);
            
        }
        return anchorr;
    }
}


