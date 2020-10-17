package quizes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DatabaseConfiguration.Connections;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kwizera
 */
public class TakeQuizz extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        StackPane root = new StackPane();
       root.getChildren().add(TakingQuiz());
         
        ScrollPane scroll = new ScrollPane(root); 
        Scene scene = new Scene(scroll, 700, 500);
        
        primaryStage.setTitle("Taking the quiz!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    VBox TakingQuiz()
    {
        VBox StudentQuizAssessment=new VBox();
        Button Start=new Button("Start the quiz");
        StudentQuizAssessment.getChildren().add(Start);
        Start.setOnAction(e->{
            int confirm=JOptionPane.showConfirmDialog(null, "Do you want to start quiz ?","",JOptionPane.YES_NO_OPTION);
            if(confirm==0)
            {
                ArrayList<String> Problems=new ArrayList<>();
                try{
                 
                 Statement st=Connections.getConnection();
                 ResultSet Result=st.executeQuery("SELECT `Question` FROM `quizes`");
                 while(Result.next())
                 {
                    
                   Problems.add(Result.getString(1));
                 }
                 Button AddNew=new Button("Next Question");
                         StudentQuizAssessment.getChildren().add(new Label(Problems.get(0)));
                         ResultSet result1=st.executeQuery("select Question,ProposedAnswers,Answer from quizes where Question='"+Problems.get(0)+"';");
                         if(result1.next())
                                 StudentQuizAssessment.getChildren().add(new Label(result1.getString(2)));
             StudentQuizAssessment.getChildren().add(AddNew);
             ArrayList<String> Answers=new ArrayList<>();
             ArrayList<String> ProposedAnswers=new ArrayList<>();
               
                      ResultSet result2=st.executeQuery("select Question,ProposedAnswers,Answer from quizes where QuestionNumber>'"+5+"'");
                     AddNew.setOnAction(add->{ 
                     try {
                         String quest=new String();
                         Label question=new Label();
                         String proposed =new String();
                         Label proposing=new Label();
                           ArrayList<CheckBox> CheckBoxchoices = new ArrayList<>();
                           ArrayList<RadioButton> RadioButtonchoice = new ArrayList<>();
                           List<String> proposedelements = new ArrayList<>();
                           List<String> RealAnswers=new ArrayList<>();
                   if(result2.next())
                         {
                             quest=result2.getString(1);
                             Answers.add(quest);
                             question.setText(quest);
                             String answer=result2.getString(3);
                             String Real[]=answer.split(",");
                             RealAnswers=Arrays.asList(Real);
                             proposed=result2.getString(2);
                             
                            
                            String elments[]=proposed.split(",");
                            proposedelements=Arrays.asList(elments);
                         
                             
                         }
                         
                         StudentQuizAssessment.getChildren().add(question);
                         
                                  //checkbox to tick where the real answers are
                                  if(RealAnswers.size()>1)
                                  {
                           
                           for(int i=0;i<proposedelements.size();i++)  
                           {
                               HBox Answerspane=new HBox();
                                CheckBox choose = new CheckBox( );
                               Answerspane.getChildren().addAll(choose,new Label(proposedelements.get(i)));
                            
                         StudentQuizAssessment.getChildren().add( Answerspane); 
                           }
                                  }
                                  else
                                  {
                                       for(int i=0;i<proposedelements.size();i++)  
                           {
                                      HBox Answerspane=new HBox();
                                RadioButton choose = new RadioButton( );
                                RadioButtonchoice.add(choose);
                                ToggleGroup gr=new ToggleGroup();
                                RadioButtonchoice.get(i).setToggleGroup(gr);
                               
                               Answerspane.getChildren().addAll( RadioButtonchoice.get(i),new Label(proposedelements.get(i)));
                            
                         StudentQuizAssessment.getChildren().add( Answerspane); 
                                  }}
                     } catch (SQLException ex) {
                         Logger.getLogger(TakeQuiz.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      });
                      
                     
                }
                
                
                catch(SQLException ex)
                        {
                        JOptionPane.showMessageDialog(null, e);
                        }
            }
        });
         
        return StudentQuizAssessment;
        
    }
    
}
