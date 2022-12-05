package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        GamePage game = new GamePage();
        root.getChildren().add(game.root);
        stage.setTitle("WordDictionary");
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.web("RED"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}