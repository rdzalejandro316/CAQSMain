/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_listModify;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private void atras(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    @FXML
    private void cambio(ActionEvent event) throws Exception {
        
        lis = (String) listaNombre.getValue();
        ListModifiBL bl = new ListModifiBL();
        
        
        try {
            
            lis = (String) listaNombre.getValue();
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
            Logger.getLogger(ControlleListModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
