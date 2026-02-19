package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.lang.foreign.SegmentAllocator;

public class UI extends Application {

    private final Button searchButton = new Button("Search");
    private final TextArea outputPanel = new TextArea();
    private final TextField inputField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        outputPanel.setEditable(false);
        configure(primaryStage);
        configureSearchButton();
    }

    private void configure(Stage stage){
        stage.setTitle("Wikipedia Revision Searcher");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
        stage.setMinHeight(stage.getHeight()*2);
        stage.setMinWidth(stage.getWidth());
    }

    private Pane createRoot() {
        BorderPane root = new BorderPane();
        VBox inputPanel = new VBox();


        inputPanel.getChildren().addAll(
                new Label("Enter Query:"),
                inputField,
                searchButton
        );
        inputPanel.setAlignment(Pos.CENTER);
        searchButton.setMinWidth(50.0);
        inputPanel.setSpacing(10);

        root.setLeft(inputPanel);
        root.setCenter(outputPanel);
        HBox.setHgrow(outputPanel, Priority.ALWAYS);
        outputPanel.setMaxHeight(Double.MAX_VALUE);
        BorderPane.setMargin(root.getLeft(), new Insets(0, 20, 0, 20));

        return root;
    }

    private void configureSearchButton() {
        searchButton.setOnAction(event -> searchForRevisions());
    }

    private void searchForRevisions() {
        String input = inputField.getText();

        String output = WikipediaManager.searchForRevisions(input);

        outputPanel.setText(output);
    }

}
