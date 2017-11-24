/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_TransferEsp;

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
import servicio_TransferEsp.TransferEspBL;
import servicio_lista.ListBL;

/**
 *
 * @author pc
 */
public class ControllerTransferEsp implements Initializable {

    @FXML
    public ChoiceBox prioridadCB;
    public ChoiceBox listaCB;

    public List<Integer> choiceBoxPrioridad() throws Exception {
        
        TransferEspBL BL = new TransferEspBL();
        List<Integer> a = BL.obtenerListaPrioridad();

        return a;
    }
    
    public List<String> mostrar() throws Exception {
        ListBL bl = new ListBL();
        return bl.traerLista();
    }

    @FXML
    private void atras(ActionEvent event) {
        System.out.println("You clicked me!");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            prioridadCB.setItems(FXCollections.observableArrayList(choiceBoxPrioridad()));
            listaCB.setItems(FXCollections.observableArrayList(mostrar()));
        } catch (Exception ex) {
            Logger.getLogger(ControllerTransferEsp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
