/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_listModify;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import servicio_listModify.ListModifiBL;

/**
 *
 * @author OSCAR CASTILLO
 */
public class ControlleListModify implements Initializable {

    @FXML
    public ChoiceBox listaNombre;

    public String lis;

    @FXML
    private void atras(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    @FXML
    private void cambio(ActionEvent event) {
        lis = (String) listaNombre.getValue();
        ListModifiBL bl = new ListModifiBL();
        bl.obtenerDatoslista(lis);
    }
    
    public List<String> mostrar() throws Exception {
        ListModifiBL bl = new ListModifiBL();
        return bl.obternerLista();
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            listaNombre.setItems(FXCollections.observableArrayList(mostrar()));
        } catch (Exception ex) {
            Logger.getLogger(ControlleListModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
