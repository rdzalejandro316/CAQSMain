/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_callQueue;


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
import servico_callQueue.callQueueBL;
import DTOtableView.DTOcola;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author pc
 */
public class ControllerCallQueue implements Initializable {

    @FXML
    public ChoiceBox idListaNombre;
    public String lis;
    
    
    @FXML
    public TableView<DTOcola> tabla;
    @FXML
    public TableColumn<DTOcola,String> numeroColum;
    
    private DTOcola selectedItem;
    private ObservableList<DTOcola> listaVacantes;
    
    
    @FXML
    private void abrirInforme() throws IOException {

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
    private void AbrirCrearLista() throws IOException {

        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_createList/createList.fxml"));
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
    private void AbrirModificarLista() throws IOException {

        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_listModify/listModify.fxml"));
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
    private void AbrirLista() throws IOException {

        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_consultList/consultList.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            
            Stage stage1 = new Stage(); //login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        }catch (IOException e){
               System.out.println("la ventana no fue abierta satisfactoriamente");
  
        }        
    }

    public List<String> mostrar() throws Exception {

        callQueueBL c = new callQueueBL();
        return c.obtenerNombreLista();

    }

    @FXML
    private void cambio(ActionEvent event) {

        lis = (String) idListaNombre.getValue();
        callQueueBL c = new callQueueBL();
        try {
            
            lis = (String) idListaNombre.getValue();
            
            //tabla
            this.numeroColum.setCellValueFactory(new PropertyValueFactory("numero"));
            List<String> numLis = c.obtenerListaSeleccionada(lis);
            
            this.listaVacantes = FXCollections.observableArrayList();
            
            for(int i=0;i < numLis.size(); i++){                                    
                listaVacantes.add(new DTOcola(numLis.get(i)));
            }
            
            tabla.setItems(listaVacantes);
            
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerCallQueue.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
        
            idListaNombre.setItems(FXCollections.observableArrayList(mostrar()));
            

        } catch (Exception ex) {
            Logger.getLogger(ControllerCallQueue.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
/*try {
            callQueueBL colaBL = new callQueueBL();
            colaBL.obtenerNombreLista();
            String[] numeros = new String[4];
            numeros[0]= "a";
            numeros[1]= "b";
            numeros[2]= "c";
            numeros[3]= "d";
            
            //idListaNombre.setItems(FXCollections.observableArrayList(mostrar()));
            } catch (Exception ex) {
            Logger.getLogger(ControllerCallQueue.class.getName()).log(Level.SEVERE, null, ex);
            }*/
