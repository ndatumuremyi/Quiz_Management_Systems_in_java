package quizes;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DatabaseConfiguration.Connections;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kwizera
 */
public class QuestionsAndAnswers extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            StackPane root = new StackPane();
            root.getChildren().add(getAnswers());

            Scene scene = new Scene(root, 600, 400);

            primaryStage.setTitle("Addstudent!");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (NullPointerException e) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("empty-statement")
    VBox getAnswers() {
        VBox AnswersPane = new VBox();

        AnswersPane.setPadding(new Insets(20, 12.5, 20, 14.5));

        ArrayList<String> RealAnswer = new ArrayList<>();
        int j = 1;
        ArrayList<String> ProposedAnswers = new ArrayList<>();//list of proposed answers
        Button AddQuestion = new Button("Start giving Quiz...");
        AnswersPane.getChildren().add(AddQuestion);
        TextField questioning = new TextField();// the question to be given
        questioning.setPromptText("Enter the question " + j);
        
        
        
        
        AddQuestion.setOnAction((ActionEvent e)
                ->//event handeler when start quiz giving is presed
                {
                    AnswersPane.getChildren().add(questioning);
                    String Choices = JOptionPane.showInputDialog("How many proposed answers to this question ?");//promptingteacher to mention the proposed answers to the question
                    int number = Integer.parseInt(Choices);
                    Label NumberOfchoices = new Label("Fill " + number + " proposed answers!");
                    AnswersPane.getChildren().add(NumberOfchoices);
                    Button Save = new Button("Save");//save button to save all information into database
                    
                    ArrayList<CheckBox> choices = new ArrayList<>();
                    ArrayList<TextField> answers = new ArrayList<>();

                    for (int i = 0; i < number; i++) {
                        TextField posibleAnswers = new TextField();//textField where the proposed answers are writen
                        posibleAnswers.setPromptText("Enter the choice " + (i + 1));

                        CheckBox choose = new CheckBox("choose correct answer " + (i + 1));  //checkbox to tick where the real answers are

                        //inputs.add(input);
                        AnswersPane.getChildren().add(choose);
                        choices.add(choose);
                        AnswersPane.getChildren().add(posibleAnswers);
                        answers.add(posibleAnswers);
                        
                    }
                        
                            
                            
                            
                        
                        
                        
                        Save.setOnAction((ActionEvent SaveEvent)
                                -> //what happens if you click save
                                {
                                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save this question", "selected", JOptionPane.YES_NO_OPTION);//confirming that you want to save
                                    if (confirm == 0)//if you choose yes
                                    {

                                        String Problem = questioning.getText();//storing the question from textfield to a string
                                        for (int v = 0; v < number; v++) {
                                        ProposedAnswers.add(answers.get(v).getText());//gathering all proposed answers into an array
                                        
                                        if (choices.get(v).isSelected()) //what happens when the answer is selected
                                        {
                                            RealAnswer.add(answers.get(v).getText());//storing all real answers into an array 

                                        }
                                        }
                                        try {

                                            Statement statement = Connections.getConnection();//creating statement
                                            statement.executeUpdate("INSERT INTO questions(question) VALUES ('" + Problem + "');");//sql queries

                                            for (String proposed : ProposedAnswers) {
                                                //   answers += proposed + ",";

                                            }
                                            statement.executeUpdate("UPDATE questions SET answers = ('" + ProposedAnswers.toString() + "')where question='" + Problem + "';");
                                            for (String Real : RealAnswer) {
                                                //   correctAnswers += Real +",";

                                            }
                                            statement.executeUpdate("UPDATE questions SET correct=('" + RealAnswer.toString() + "')where Question='" + Problem + "';");

                                            JOptionPane.showMessageDialog(null, "Saved successfully !");//if data are saved

                                        } catch (HeadlessException | SQLException ex) {
                                            JOptionPane.showMessageDialog(null, ex.getMessage());//if not saved
                                        }

                                    }
                                    Save.setDisable(true);//setting save button disabled
                                });
                    

                    AnswersPane.getChildren().add(Save);

                    AddQuestion.setDisable(true);//setting start quiz button disabled

                });
        j++;

        return AnswersPane;
    }
}
