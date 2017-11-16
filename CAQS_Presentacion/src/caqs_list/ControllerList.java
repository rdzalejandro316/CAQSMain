/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_list;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import servicio_Consultlist.ConsultlistBL;
import servicio_lista.ListBL;

/**
 *
 * @author OSCAR CASTILLO
 */
public class ControllerList implements Initializable {

    @FXML
    public ChoiceBox listaCB;
    
    public String list;
    
    @FXML
    private void abirInfome(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_report/report.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            
            Stage stage1 = new Stage(); //login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        }catch (IOException e){
               System.out.println("la ventana no fue abierta satisfactoriamente");
  
        }
    }
    
    @FXML
    private void abrirlistaNegra(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_blackList/blacklist.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            
            Stage stage1 = new Stage(); //login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        }catch (IOException e){
               System.out.println("la ventana no fue abierta satisfactoriamente");
  
        }
    }
    
    @FXML
    private void atras(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void cambio(ActionEvent event) {

        list = (String) listaCB.getValue();
        ListBL bl = new ListBL();
        bl.obtenerDatoslista(list);

    }
    
    public List<String> mostrar() throws Exception {

        ListBL bl = new ListBL();
        return bl.traerLista();

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listaCB.setItems(FXCollections.observableArrayList(mostrar()));
        } catch (Exception ex) {
            Logger.getLogger(ControllerList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
