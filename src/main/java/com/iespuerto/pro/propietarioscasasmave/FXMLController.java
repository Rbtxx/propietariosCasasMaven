package com.iespuerto.pro.propietarioscasasmave;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtMetros;
    @FXML
    private Button btnVincularCasa;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnNuevaCasa;
    @FXML
    private Button btnBorrarCasa;
    @FXML
    private CheckBox chkGaraje;
    @FXML
    private CheckBox chkAscensor;
    @FXML
    private Button btnCrearCasa;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private Button btnAtrasP;
    @FXML
    private Button btnSiguienteP;
    @FXML
    private Button btnNuevoPropietario;
    @FXML
    private Button btnVincularPropietario;
    @FXML
    private Button btnBorrarPropietario;
    @FXML
    private Button btnCrearPropietario;
    @FXML
    private Label lblDNI;
    @FXML
    private TextField txtDNI;
    @FXML
    private Button btnCancelarP;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
