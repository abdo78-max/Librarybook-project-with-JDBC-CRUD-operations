/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import Dao.LibraryController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Compu City
 */
public class LibraryMenuController {

    LibraryController libraryController = new LibraryController();

    @FXML
    void HomeAction(ActionEvent event) {
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("/LibraryDesign/librarymenu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void viewbookAction(ActionEvent event) {
        Parent parent;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibraryDesign/bookstable.fxml"));
            parent = loader.load();
            libraryController.viewBooks();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void addBookAction(ActionEvent event) {
        Parent parent;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibraryDesign/addnewbook.fxml"));
            parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void searchBookAction(ActionEvent event) {
        Parent parent;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibraryDesign/searchbook.fxml"));
            parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void updateBookAction(ActionEvent event) {
        Parent parent;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibraryDesign/updatebook.fxml"));
            parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deleteBookAction(ActionEvent event) {
        Parent parent;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibraryDesign/deletebook.fxml"));
            parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void AboutUsAction(ActionEvent event) {
        Parent parent;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LibraryDesign/aboutus.fxml"));
            parent = loader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LibraryMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
