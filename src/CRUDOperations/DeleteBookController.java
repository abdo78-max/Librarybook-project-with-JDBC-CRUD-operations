/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import Dao.LibraryController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import model.Library;

/**
 *
 * @author Compu City
 */
public class DeleteBookController implements Initializable {

    @FXML
    private TextField bookId;
    @FXML
    private Label success;
    @FXML
    private Label failed;

    @FXML
    void deleteBookAction(ActionEvent event) {
        if (bookId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "bookid is empty");
        } else {
            boolean isNumber = true;
            String text = bookId.getText();
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                LibraryController libraryController = new LibraryController();
                Library library = new Library();
                library.setBookNumber(Integer.parseInt(bookId.getText()));
                int result = libraryController.deleteBook(library);
                if (result == 1) {
                    success.setVisible(true);
                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> success.setText(""));
                } else {
                    failed.setVisible(true);
                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(3));
                    pauseTransition.setOnFinished(ev -> failed.setText(""));
                }
            } else {
                JOptionPane.showMessageDialog(null, "you must enter only positive numbers");

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        success.setVisible(false);
        failed.setVisible(false);
    }
}
