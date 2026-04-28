/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDOperations;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Compu City
 */
public class AboutUsController implements Initializable {

    @FXML
    private Label sentence;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sentence.setWrapText(true);
     }

}
