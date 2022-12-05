package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class GamePageController {
    wordDictionary dictionaryList;
    @FXML
    TextField searchword;
    @FXML
    TextField word;
    @FXML
    TextField meaning;

    @FXML
    public void newword(MouseEvent event) throws IOException {
        System.out.println("New Word Added");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("New Word Adding");
        if(word.textProperty().get().equals("") || meaning.textProperty().get().equals(""))
        {
            infoAlert.setContentText("Enter some word/Meaning to be added");
            infoAlert.showAndWait();
        }
        else {
            dictionaryList.addWord(word.textProperty().get(), meaning.textProperty().get());
            dictionaryList.serializeMap();
            infoAlert.setContentText("New Word has Added to Dictionary");
            infoAlert.showAndWait();
        }

    }

    @FXML
    public void search(MouseEvent event) throws IOException{
        System.out.println("Searching the word");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Search Result");
        if(searchword.textProperty().get().equals(""))
        {
            infoAlert.setContentText(dictionaryList.getWordList().get("Please Enter a word for search"));
            infoAlert.showAndWait();
        }
        if(dictionaryList.getWordList().containsKey(searchword.textProperty().get()))
        {
            System.out.println(dictionaryList.getWordList().get(searchword.textProperty().get()));
            infoAlert.setContentText(dictionaryList.getWordList().get(searchword.textProperty().get()));
            infoAlert.showAndWait();
        }
        else
        {
            infoAlert.setContentText("The Word is not available in Dictionary");
            infoAlert.showAndWait();
        }

    }
}
