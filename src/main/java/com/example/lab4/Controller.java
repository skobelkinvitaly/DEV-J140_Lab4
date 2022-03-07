package com.example.lab4;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    @FXML
    private TextArea textArea;

    @FXML
    protected void onCSSButtonClick() {
//Не получается реализовать смену CSS.
//Для реализации нужно обращаться к полям класса App??
    }

    @FXML
    protected void onSaveButtonClick() {
        SaverTxt saverTxt = new SaverTxt();
        String txt = textArea.getText();
        saverTxt.saveText(txt);
    }

    @FXML
    protected void onOpenButtonClick() {
        textArea.setWrapText(true);
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
        File txt = chooser.showOpenDialog(null);
        try (FileReader reader = new FileReader(txt)) {
            char[] temp = new char[1024];
            int i = 0;
            while ((i = reader.read(temp)) > 0) {
                textArea.appendText(new String(temp, 0, i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void onClearButtonClick() {
        textArea.clear();
    }
}
