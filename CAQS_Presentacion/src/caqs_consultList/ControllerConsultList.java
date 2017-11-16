/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_consultList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import servicio_Consultlist.ConsultlistBL;

/**
 *  
 * @author OSCAR CASTILLO
 */
public class ControllerConsultList implements Initializable {

    @FXML
    public ChoiceBox idlista;
    public String lis;

    @FXML
    private void cambio(ActionEvent event) {

        lis = (String) idlista.getValue();
        ConsultlistBL c = new ConsultlistBL();
        c.obtenerDatoslista(lis);

    }
    

    public List<String> mostrar() throws Exception {

        ConsultlistBL con = new ConsultlistBL();
        return con.traerLista();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            
            //lis = (String) idListaNombre.getValue();
            //System.out.println(lis);
            idlista.setItems(FXCollections.observableArrayList(mostrar()));
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerConsultList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
