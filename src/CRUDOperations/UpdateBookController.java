/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import Dao.LibraryController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class UpdateBookController implements Initializable {

    @FXML
    private TextField Author;

    @FXML
    private TextField bookId;

    @FXML
    private TextField bookTitle;

    @FXML
    private TextField category;

    @FXML
    private DatePicker datepublished;

    @FXML
    private TextField publishedcountry;

    @FXML
    private TextField publisher;

    @FXML
    private TextField quantity;

    @FXML
    private Label failed;
    @FXML
    private Label success;

    @FXML
    void ApplyIdAction(ActionEvent event) {
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
                library.setBookNumber(Integer.parseInt(text));
                library = libraryController.searchBookWithId(library);
                bookTitle.setText(library.getBookTitle());
                category.setText(library.getCategory());
                datepublished.setValue(library.getDatepublished());
                publishedcountry.setText(library.getPublishedCountry());
                Author.setText(library.getAuthor());
                publisher.setText(library.getPublisher());
                quantity.setText(String.valueOf(library.getQuantity()));
                ObservableList<Library> observableList
                        = FXCollections.observableArrayList(library);
            } else {
                JOptionPane.showMessageDialog(null, "you must enter only positive numbers");
            }
        }
    }

    @FXML
    void updateAction(ActionEvent event) {
        if (bookId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "bookid is empty");
            return;
        } else if (Integer.parseInt(bookId.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "you must enter positive value");
            return;
        }
        boolean isNumber = true;
        String text = quantity.getText();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                isNumber = false;
                break;
            }
        }
        if (!isNumber) {
            JOptionPane.showMessageDialog(null, "you must enter positive number in quantity");
            return;

        }
        Library library = new Library(bookTitle.getText(), Author.getText(), publisher.getText(), category.getText(), Integer.parseInt(quantity.getText()), datepublished.getValue(), publishedcountry.getText());
        LibraryController libraryController = new LibraryController();
        library.setBookNumber(Integer.parseInt(bookId.getText()));
        int result = libraryController.updateBook(library);
        if (result == 1) {
            library.setBookTitle(bookTitle.getText());
            library.setAuthor(Author.getText());
            library.setCategory(category.getText());
            library.setDatepublished(datepublished.getValue());
            library.setPublisher(publisher.getText());
            library.setQuantity(Integer.parseInt(quantity.getText()));
            library.setPublishedCountry(publishedcountry.getText());
            ObservableList<Library> observableList
                    = FXCollections.observableArrayList(library);
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        success.setVisible(false);
        failed.setVisible(false);
    }
}
