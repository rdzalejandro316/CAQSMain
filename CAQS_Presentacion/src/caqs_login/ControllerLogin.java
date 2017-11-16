package caqs_login;

import java.io.IOException;
import servicio_login.LoginBL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControllerLogin implements Initializable {

    @FXML

    public Label cambio;
    public TextField usuario;
    public PasswordField passField;

    public ChoiceBox tipoUsuario;
    public Button login;

    public String usu;
    public String cont;
    public String lis;
    public boolean ingreso;

    @FXML
    private void handleButtonAction1(ActionEvent event) throws Exception {

        usu = usuario.getText();
        cont = passField.getText();
        lis = (String) tipoUsuario.getValue();

        boolean u = usuario.getText().isEmpty();
        boolean c = passField.getText().isEmpty();

        LoginBL pr = new LoginBL();
        pr.verificarUsurio(usu, cont);

        if (u) {
            cambio.setText("ingrese su usuario");
        }
        if (c) {
            cambio.setText("ingrese su contraseña");
        }
        if (u && c) {
            cambio.setText("ingrese su usuario y cotraseña");
        }
        

        if (pr.verificarUsurio(usu, cont)) {
            System.out.println("abrir ventana");

            if (lis == "especialista") {
                abrirVentana();
            } else {
                abrirVentanaColaLlamada();
            }

        } else {
            MostrarMensaje();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tipoUsuario.setItems(FXCollections.observableArrayList("agente", "especialista"));

    }

    /*@FXML
    private void revisar(ActionEvent event){
        cambio.setVisible(false);
    }*/
    private void MostrarMensaje() {
        cambio.setVisible(true);
        cambio.setText("usuario y contraseña incorrecta");
    }

    private void abrirVentanaColaLlamada() throws IOException {

        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_callQueue/callQueue.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();

            Stage stage1 = (Stage) login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException e) {
            System.out.println("la ventana no fue abierta satisfactoriamente");

        }
    }

    private void abrirVentana() throws IOException {

        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../caqs_list/list.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = (Stage) login.getScene().getWindow();
            stage1.setTitle("otra ventana");
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException e) {
            System.out.println("la ventana no fue abierta satisfactoriamente");

        }
    }

}
