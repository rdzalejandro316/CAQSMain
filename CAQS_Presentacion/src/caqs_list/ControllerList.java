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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import servicio_lista.ListBL;
import DTOtableView.DTOlista;

/**
 *
 * @author OSCAR CASTILLO
 */
public class ControllerList implements Initializable {

    @FXML
    public ChoiceBox listaCB;
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
    private void abirInfome(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_report/report.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();

            Stage stage1 = new Stage(); //login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException e) {
            System.out.println("la ventana no fue abierta satisfactoriamente");

        }
    }

    @FXML
    private void abrirlistaNegra(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_blackList/blacklist.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();

            Stage stage1 = new Stage(); //login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException e) {
            System.out.println("la ventana no fue abierta satisfactoriamente");

        }
    }

    @FXML
    private void atras(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    public List<String> mostrar() throws Exception {

        ListBL bl = new ListBL();
        return bl.traerLista();

    }

    @FXML
    private void cambio(ActionEvent event) {

        lis = (String) listaCB.getValue();
        ListBL bl = new ListBL();
        
        try {
            
            lis = (String) listaCB.getValue();
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
            Logger.getLogger(ControllerList.class.getName()).log(Level.SEVERE, null, ex);
        }

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
