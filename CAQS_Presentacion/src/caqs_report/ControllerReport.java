/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caqs_report;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import servicio_report.ReportBL;

/**
 *
 * @author OSCAR CASTILLO
 */
public class ControllerReport implements Initializable {

    @FXML
    private TextField nombreTF;
    private DatePicker fechaTX;
    private TextField descripcionTF;
    private Button atras;
    
    public String nom;
    public String fec;
    public String dec;

    @FXML
    private void generar(ActionEvent event) throws Exception {

        //fec = fechaTX.getText();
        //dec = descripcionTF.getSelectedText();
        //Date fecha = new Date();
        nom = nombreTF.getText();

        ReportBL re = new ReportBL();

        int ultm = re.SiguienteId();//conseguir el ultimo Id

        re.verificarIngreso(ultm, nom, "2014/04/22", "08:12", "nada", 1);//ingreasar los datos de la vista

    }
    
    @FXML
    private void atras(ActionEvent event) throws Exception {
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
