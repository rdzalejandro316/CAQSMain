/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_createList;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import servicio_CreateList.CreateListBL;

/**
 *
 * @author OSCAR CASTILLO
 */
public class ControllerCreateList implements Initializable {

    @FXML
    private TextField nuevaLista;
    public Label error;

    public String nue;

    @FXML
    private void crear(ActionEvent event) throws Exception {

        nue = nuevaLista.getText();

        CreateListBL bl = new CreateListBL();
        int id = bl.siguienteId();

        if (bl.verificarIngreso(id, nue, null)) {
            cambiartexto();
        } else {
            mostrar();
        }

    }

    public void mostrar() {
        error.setVisible(true);

    }

    public void cambiartexto() {
        error.setText("lista creada con exito");
        error.setTextFill(Color.web("#2980b9"));
    }

    @FXML
    private void atras(ActionEvent event) {

        System.out.println("atras");
    }

    /*public void ocultarLabel() {

        error.setVisible(true);
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
