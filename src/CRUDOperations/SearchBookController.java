/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import Dao.LibraryController;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.Library;

/**
 *
 * @author Compu City
 */
public class SearchBookController {

    @FXML
    private TableColumn<Library, String> author;

    @FXML
    private TableColumn<Library, Integer> bookId;

    @FXML
    private TextField bookid;

    @FXML
    private TextField booktitle;

    @FXML
    private TableColumn<Library, String> category;

    @FXML
    private TableColumn<Library, LocalDate> datepublished;

    @FXML
    private TableColumn<Library, String> publishedcountry;

    @FXML
    private TableColumn<Library, String> publisher;

    @FXML
    private TableColumn<Library, Integer> quantity;

    @FXML
    private TableColumn<Library, String> title;
    @FXML
    private TableView<Library> bookTable;

    void loadData() {
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookNumber"));
        title.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        publishedcountry.setCellValueFactory(new PropertyValueFactory<>("publishedCountry"));
        datepublished.setCellValueFactory(new PropertyValueFactory<>("datepublished"));
    }

    @FXML
    void applyIdAction(ActionEvent event) {
        boolean isNumber = true;
        String text = bookid.getText();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                isNumber = false;
                break;
            }
        }
        if (bookid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "bookid is empty");
        } else {
            if (isNumber) {
                LibraryController libraryController = new LibraryController();
                Library library = new Library();
                library.setBookNumber(Integer.parseInt(text));
                library = libraryController.searchBookWithId(library);
                loadData();
                ObservableList<Library> observableList
                        = FXCollections.observableArrayList(library);
                bookTable.setItems(observableList);
            } else {
                JOptionPane.showMessageDialog(null, "you must enter only positive numbers");
            }
        }
    }

    @FXML
    void applyTitleAction(ActionEvent event) {
        if (booktitle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "booktitle is empty");
        } else {
            LibraryController libraryController = new LibraryController();
            ArrayList<Library> libraryList = new ArrayList<>();
            Library library = new Library();
            library.setBookTitle(booktitle.getText());
            libraryList.addAll(libraryController.searchBookByTitleContaining(library));
            loadData();
            ObservableList<Library> observableList
                    = FXCollections.observableArrayList(libraryList);
            bookTable.setItems(observableList);
        }
    }

    @FXML
    void clearAction(ActionEvent event) {
        bookTable.getItems().clear();
    }
}
