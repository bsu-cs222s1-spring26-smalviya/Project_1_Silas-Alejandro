package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        configure(primaryStage);
    }

    private void configure(Stage stage){
        stage.setTitle("Wikipedia Revision Searcher");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }

    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().addAll(
                new Label("Enter Query:")
        );
        root.setAlignment(Pos.CENTER);
        return root;
    }

}
