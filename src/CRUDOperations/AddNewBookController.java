/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import Dao.LibraryController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import model.Library;

/**
 *
 * @author Compu City
 */
public class AddNewBookController implements Initializable {

    @FXML
    private Label success;
    @FXML
    private Label bookid;
    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField publisher;
    @FXML
    private TextField category;
    @FXML
    private TextField quantity;
    @FXML
    private DatePicker datepublished;
    @FXML
    private ComboBox<String> publishingcountry;
    @FXML
    private Label failed;

    @FXML
    void saveAction(ActionEvent event) {
        if (title.getText().trim().isEmpty() || author.getText().trim().isEmpty() || publisher.getText().trim().isEmpty() || category.getText().trim().isEmpty() || datepublished.getValue() == null || quantity.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "you must enter all fields ");
            return;
        }
        LibraryController libraryController = new LibraryController();
        Library library = new Library(title.getText(), author.getText(), publisher.getText(), category.getText(), Integer.parseInt(quantity.getText()), datepublished.getValue(), publishingcountry.getSelectionModel().getSelectedItem());
        int result = libraryController.addBooks(library);
        if (result == 1) {
            success.setVisible(true);
            bookid.setText(String.valueOf(library.getBookNumber()));
            PauseTransition pauseTransition = new PauseTransition();
            pauseTransition.setDuration(Duration.seconds(3));
            pauseTransition.setOnFinished(ev -> success.setText(""));
        } else {
            failed.setVisible(true);
            PauseTransition pauseTransition = new PauseTransition();
            pauseTransition.setDuration(Duration.seconds(3));
            pauseTransition.setOnFinished(ev -> failed.setText(""));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String line;
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader("countries.txt"))) {
            while ((line = bufferedreader.readLine()) != null) {
                publishingcountry.getItems().add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddNewBookController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddNewBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        success.setVisible(false);
        failed.setVisible(false);
    }
}
