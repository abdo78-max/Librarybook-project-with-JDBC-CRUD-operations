/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import Dao.LibraryServices;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Library;

/**
 *
 * @author Compu City
 */
public class BooksTableController implements Initializable {

    @FXML
    private TableView<Library> bookMenu;
    @FXML
    private TableColumn<Library, Integer> bookId;
    @FXML
    private TableColumn<Library, String> title;
    @FXML
    private TableColumn<Library, String> Author;
    @FXML
    private TableColumn<Library, String> publisher;
    @FXML
    private TableColumn<Library, String> category;
    @FXML
    private TableColumn<Library, Integer> quantity;
    @FXML
    private TableColumn<Library, LocalDate> datepublished;
    @FXML
    private TableColumn<Library, String> publishedcountry;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookNumber"));
        title.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        Author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        publishedcountry.setCellValueFactory(new PropertyValueFactory<>("publishedCountry"));
        datepublished.setCellValueFactory(new PropertyValueFactory<>("datepublished"));
        LibraryServices libraryServices = new LibraryServices();
        ArrayList<Library> list = libraryServices.viewBooks();
        ObservableList<Library> observableList
                = FXCollections.observableArrayList(list);
        bookMenu.setItems(observableList);

    }
}
