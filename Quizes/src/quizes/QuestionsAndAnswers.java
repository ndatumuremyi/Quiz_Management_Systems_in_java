package quizes;


import DatabaseConfiguration.Connections;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kwizera
 */
public class QuestionsAndAnswers extends Application {
Stage primaryStage=new Stage();
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;

        try {
            StackPane root = new StackPane();
            root.getChildren().add(getAnswers());

            Scene scene = new Scene(root, 600, 400);

            primaryStage.setTitle("Provide the quiz!");
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
        AnswersPane.setSpacing(10.5);

        ArrayList<String> RealAnswer = new ArrayList<>();
        
        ArrayList<String> ProposedAnswers = new ArrayList<>();//list of proposed answers
        Button AddQuestion = new Button("Add new question");
        AnswersPane.getChildren().add(AddQuestion);
        TextField questioning = new TextField();// the question to be given
        questioning.setPromptText("Enter the question " );
        
        
        
        
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
                        HBox Answerspane=new HBox();
                        TextField posibleAnswers = new TextField();//textField where the proposed answers are writen
                        posibleAnswers.setPromptText("Enter the choice " + (i + 1));

                        CheckBox choose = new CheckBox("choose correct as answer  " + (i + 1));  //checkbox to tick where the real answers are

                        //inputs.add(input);
Answerspane.getChildren().addAll(choose,posibleAnswers);
                        //AnswersPane.getChildren().add(choose);
                        choices.add(choose);
                       // AnswersPane.getChildren().add(posibleAnswers);
                        answers.add(posibleAnswers);
                        AnswersPane.getChildren().add(Answerspane);
                        
                    }
                        
                            
                            
                            
                        
                        
                        
                       // while(!endquiz.isPressed())
                              //  {
                        Save.setOnAction((ActionEvent SaveEvent)
                                -> {
                               
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
                                              
                                            Statement statement =Connections.getcon(); //creating statement
                                            statement.executeUpdate("INSERT INTO quizes(Question) VALUES ('" + Problem + "');");//sql queries
                                             String coma=" ";
                                            StringBuilder getproposedanswers=new StringBuilder();
                                            for (String proposed : ProposedAnswers) {
                                                getproposedanswers.append(coma);
                                                getproposedanswers.append(proposed);
                                               coma=","; 

                                            }
                                           
                                            statement.executeUpdate("UPDATE quizes SET ProposedAnswers = ('" + getproposedanswers.toString() + "')where Question='" + Problem + "';");
                                            StringBuilder getreal=new StringBuilder();
                                            for (String Real : RealAnswer) {
                                             
                                              getreal.append(coma);
                                               getreal.append(Real);
                                                coma=",";
                                            }
                                            
                                            statement.executeUpdate("UPDATE quizes SET Answer=('" + getreal.toString() + "')where Question='" + Problem + "';");

                                            JOptionPane.showMessageDialog(null, "Saved successfully !");//if data are saved

                                        } catch (HeadlessException | SQLException ex) {
                                            JOptionPane.showMessageDialog(null, ex.getMessage());//if not saved
                                        }
                                     /* questioning.clear();
                                     ProposedAnswers.clear(); 
                                      RealAnswer.clear(); 
                                      choices.clear();
                                      questioning.setPromptText("Enter an other question ");
                                        for (int v = 0; v < number; v++)
                                       {
                                            
                                       answers.get(v).clear();
                                         choices.get(v).setSelected(false);
                                         
                                   } 
*/ 

                                        
                                    }
                                
                                    //Save.setDisable(true);//setting save button disabled
                                });
                               // }
                               Button clear=new Button("clear");
                               Button Addnew=new Button("Add new");
                               Addnew.setOnAction(add->{
                                    primaryStage.close();
                        questioning.setPromptText("Enter the other question");
                                     primaryStage.show();
                               });
                    clear.setOnAction(clearing->{
                        questioning.clear();
                          for (int v = 0; v < number; v++)
                                       {
                                            
                                       answers.get(v).clear();
                                         choices.get(v).setSelected(false);
                                         
                                   } 
                    });
Button Exit=new Button("Exit");
Exit.setOnAction(exit->{
  int n=  JOptionPane.showConfirmDialog(null, "Do you realy want to stop giving quiz?","",JOptionPane.YES_NO_OPTION);
    if(n==0){
        primaryStage.close();
   
    }
    if(n==1)
    { 
       
        JOptionPane.showMessageDialog(null, "Stay tuned to giving quiz!");
    }
});
         HBox Actions=new HBox(); 
         Actions.setPadding(new Insets(10,5,10,5));
         Actions.setSpacing(0xa);//spacing value in hexadecimal
         Actions.getChildren().addAll(Save,Addnew,clear,Exit);

AnswersPane.getChildren().add(Actions);
                 

                  AddQuestion.setDisable(true);//setting start quiz button disabled
                                
                });
        
        

        return AnswersPane;
    }
}