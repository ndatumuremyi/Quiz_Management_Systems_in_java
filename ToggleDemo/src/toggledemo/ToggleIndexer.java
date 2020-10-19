/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toggledemo;

/**
 *
 * @author Kwizera
 */



import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.stream.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToggleIndexer extends Application {    
    @Override
    public void start(final Stage stage) throws Exception {
        ToggleGroup toggleGroup = new ToggleGroup();
        ObservableList<RadioButton> buttons = IntStream.range(0, 5)
                .mapToObj(i -> new RadioButton("Radio " + i))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        
        toggleGroup.getToggles().setAll(buttons);

        Label selectedIndex = new Label();
        selectedIndex.setFont(Font.font("monospace"));
        Label selectedItem = new Label();
        selectedItem.setFont(Font.font("monospace"));

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                selectedIndex.setText("");
                selectedItem.setText("");
            } else {
                final int selectedIndexValue =
                        toggleGroup.getToggles().indexOf(newValue);
                selectedIndex.setText("Selected Index: " + selectedIndexValue);

                final String selectedItemText =
                        ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                selectedItem.setText( "Selected Item:  " + selectedItemText);
            }
        });

        VBox layout = new VBox(8);
        layout.setPadding(new Insets(10));
        layout.setPrefWidth(250);
        layout.getChildren().setAll(buttons);
        layout.getChildren().addAll(selectedItem, selectedIndex);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
