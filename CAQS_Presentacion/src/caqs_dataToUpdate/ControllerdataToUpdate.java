/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_dataToUpdate;

import co.com.caqs.dal.dao.TransferenciaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author OSCAR CASTILLO
 */
public class ControllerdataToUpdate implements Initializable {

    @FXML
    public TextField nombreTF;
    public TextField apellidoTF;
    public TextField direccioTF;
    public TextField correroTF;
    
    public String nom;
    public String apell;
    public String dir;
    public String corr;
    
    
    @FXML
    private void atras(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void actualizar(ActionEvent event) throws Exception {   
        nom = nombreTF.getText();
        apell = apellidoTF.getText();
        dir = direccioTF.getText();
        corr = correroTF.getText();
                
        TransferenciaDAO dao = new TransferenciaDAO();
        dao.ActualizarDatos(nom, apell, dir, corr, 1);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
