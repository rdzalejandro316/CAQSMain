/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_consultList;

import DTOtableView.DTOlista;
import caqs_list.ControllerList;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableView<DTOlista> tabla;
    @FXML
    public TableColumn<DTOlista, String> nomColum;
    @FXML
    public TableColumn<DTOlista, String> apeColum;  
    @FXML
    public TableColumn<DTOlista, String> dirColum;  
    @FXML
    public TableColumn<DTOlista, String> corrColum;
    @FXML
    public TableColumn<DTOlista, String> causColum;
    @FXML
    public TableColumn<DTOlista, String> prioColum;
    
    private ObservableList<DTOlista> listaVacantes;
    
    @FXML
    private void atras(ActionEvent event){
        
    }
            
            
    @FXML
    private void cambio(ActionEvent event) throws Exception {

        lis = (String) idlista.getValue();
        ConsultlistBL bl = new ConsultlistBL();
        
        try {
            
            lis = (String) idlista.getValue();
            //tabla
            this.nomColum.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.apeColum.setCellValueFactory(new PropertyValueFactory("apellido"));
            this.dirColum.setCellValueFactory(new PropertyValueFactory("direccion"));
            this.corrColum.setCellValueFactory(new PropertyValueFactory("correo"));
            this.causColum.setCellValueFactory(new PropertyValueFactory("causa"));
            this.prioColum.setCellValueFactory(new PropertyValueFactory("prioridad"));
            
            List<String> nomLis = bl.obtenerNombreBL(lis);
            List<String> apeLis = bl.obtenerApellidoBL(lis);
            List<String> direLis = bl.obtenerDirreccionBL(lis);
            List<String> corrLis = bl.obtenerCorreoBL(lis);
            List<String> causaLis = bl.obtenerCausaBL(lis);
            List<Integer> prioLis = bl.obtenerPrioridadBL(lis);
            
            this.listaVacantes = FXCollections.observableArrayList();
            
            for(int i=0;i < nomLis.size(); i++){                                    
                listaVacantes.add(new DTOlista(nomLis.get(i),apeLis.get(i),direLis.get(i),corrLis.get(i),causaLis.get(i),prioLis.get(i)));
            }
            
            
            tabla.setItems(listaVacantes);
            
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerConsultList.class.getName()).log(Level.SEVERE, null, ex);
        }


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
