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

    Casas c = new Casas();
    Propietarios p = new Propietarios();

    //Los index se usan para moverse por las posiciones con las flechas. Si ves que tal cámbialo.
    int indexC = 0;
    int indexP = 0;

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
    @FXML
    private Button btnModificarC;
    @FXML
    private Button btnModificarP;
    @FXML
    private Button btnGuardarC;
    @FXML
    private Button btnGuardarP;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c.generarArray();
        p.generarArray();
        btnCrearCasa.setDisable(true);
        btnCrearPropietario.setDisable(true);
        btnCancelar.setDisable(true);
        btnCancelarP.setDisable(true);
        txtDireccion.setDisable(true);
        txtPrecio.setDisable(true);
        txtMetros.setDisable(true);
        chkGaraje.setDisable(true);
        chkAscensor.setDisable(true);
        txtNombre.setDisable(true);
        txtApellido.setDisable(true);
        txtDNI.setDisable(true);
        btnGuardarC.setDisable(true);
        btnGuardarP.setDisable(true);

    }

    @FXML
    private void crearCasa(ActionEvent event) {

        c.crearCasa(Double.parseDouble(txtPrecio.getText()), txtDireccion.getText(), Double.parseDouble(txtMetros.getText()), chkGaraje.isSelected(), chkAscensor.isSelected());

        p.generarArray();
        txtDireccion.setDisable(true);
        txtPrecio.setDisable(true);
        txtMetros.setDisable(true);
        chkGaraje.setDisable(true);
        chkAscensor.setDisable(true);
        txtDireccion.setText(p.casas.get(0).getDireccion());
        txtPrecio.setText("" + p.casas.get(0).getPrecio());
        txtMetros.setText("" + p.casas.get(0).getMetros());
        chkAscensor.setSelected(p.casas.get(0).isAscensor());
        chkGaraje.setSelected(p.casas.get(0).isGaraje());
        btnAtras.setDisable(false);
        btnSiguiente.setDisable(false);
        btnVincularCasa.setDisable(false);
        btnBorrarCasa.setDisable(false);
        btnCancelar.setDisable(true);
        btnNuevaCasa.setDisable(false);
        btnCrearCasa.setDisable(true);
        btnModificarC.setDisable(false);

        btnGuardarC.setDisable(false);
        indexC = 0;

    }

    @FXML
    private void nuevaCasa(ActionEvent event) {
        txtDireccion.setText("");
        txtPrecio.setText("");
        txtMetros.setText("");
        chkAscensor.setSelected(false);
        chkGaraje.setSelected(false);
        btnCrearCasa.setDisable(false);
        btnCancelar.setDisable(false);
        txtDireccion.setDisable(false);
        txtPrecio.setDisable(false);
        txtMetros.setDisable(false);
        chkGaraje.setDisable(false);
        chkAscensor.setDisable(false);
        btnAtras.setDisable(true);
        btnSiguiente.setDisable(true);
        btnVincularCasa.setDisable(true);
        btnBorrarCasa.setDisable(true);
        btnCancelar.setDisable(false);
        btnNuevaCasa.setDisable(true);
        btnModificarC.setDisable(true);
        btnGuardarC.setDisable(true);
    }

    @FXML
    private void casaAnterior(ActionEvent event) {

        indexC--;
        txtDireccion.setText(p.casas.get(indexC).getDireccion());
        txtPrecio.setText("" + p.casas.get(indexC).getPrecio());
        txtMetros.setText("" + p.casas.get(indexC).getMetros());
        chkAscensor.setSelected(p.casas.get(indexC).isAscensor());
        chkGaraje.setSelected(p.casas.get(indexC).isGaraje());

    }

    @FXML
    private void casaSiguiente(ActionEvent event) {
        indexC++;
        txtDireccion.setText(p.casas.get(indexC).getDireccion());
        txtPrecio.setText("" + p.casas.get(indexC).getPrecio());
        txtMetros.setText("" + p.casas.get(indexC).getMetros());
        chkAscensor.setSelected(p.casas.get(indexC).isAscensor());
        chkGaraje.setSelected(p.casas.get(indexC).isGaraje());

    }

    @FXML
    private void cancelarCasa(ActionEvent event) {
        txtDireccion.setDisable(true);
        txtPrecio.setDisable(true);
        txtMetros.setDisable(true);
        chkGaraje.setDisable(true);
        chkAscensor.setDisable(true);
        btnAtras.setDisable(false);
        btnSiguiente.setDisable(false);
        btnVincularCasa.setDisable(false);
        btnBorrarCasa.setDisable(false);
        btnCancelar.setDisable(true);
        btnNuevaCasa.setDisable(false);
        btnCrearCasa.setDisable(true);
        btnModificarC.setDisable(false);
        btnGuardarC.setDisable(true);
        txtDireccion.setText(p.casas.get(0).getDireccion());
        txtPrecio.setText("" + p.casas.get(0).getPrecio());
        txtMetros.setText("" + p.casas.get(0).getMetros());
        chkAscensor.setSelected(p.casas.get(0).isAscensor());
        chkGaraje.setSelected(p.casas.get(0).isGaraje());
        indexC = 0;

        
    }

    @FXML
    private void borrarCasa(ActionEvent event) {
        c.borrarCasa(c.id);
        p.generarArray();
        txtDireccion.setText(p.casas.get(0).getDireccion());
        txtPrecio.setText("" + p.casas.get(0).getPrecio());
        txtMetros.setText("" + p.casas.get(0).getMetros());
        chkAscensor.setSelected(p.casas.get(0).isAscensor());
        chkGaraje.setSelected(p.casas.get(0).isGaraje());

        indexC = 0;
    }

    @FXML
    private void modificarCasa(ActionEvent event) {

        chkAscensor.setDisable(false);
        chkGaraje.setDisable(false);
        btnVincularCasa.setDisable(true);
        btnBorrarCasa.setDisable(true);
        btnCancelar.setDisable(false);
        txtDireccion.setDisable(false);
        txtPrecio.setDisable(false);
        txtMetros.setDisable(false);
        btnGuardarC.setDisable(false);
        btnAtras.setDisable(true);
        btnSiguiente.setDisable(true);
        btnNuevaCasa.setDisable(true);
    }

    @FXML
    private void guardarCambiosC(ActionEvent event) {
        c.modificarCasa(Double.parseDouble(txtPrecio.getText()), txtDireccion.getText(), Double.parseDouble(txtMetros.getText()), chkGaraje.isSelected(), chkAscensor.isSelected());
        p.generarArray();
        txtDireccion.setDisable(true);
        txtPrecio.setDisable(true);
        txtMetros.setDisable(true);
        chkGaraje.setDisable(true);
        chkAscensor.setDisable(true);
        btnAtras.setDisable(false);
        btnSiguiente.setDisable(false);
        btnVincularCasa.setDisable(false);
        btnBorrarCasa.setDisable(false);
        btnCancelar.setDisable(true);
        btnNuevaCasa.setDisable(false);
        btnCrearCasa.setDisable(true);
        btnModificarC.setDisable(false);
        txtDireccion.setText(p.casas.get(0).getDireccion());
        txtPrecio.setText("" + p.casas.get(0).getPrecio());
        txtMetros.setText("" + p.casas.get(0).getMetros());
        chkAscensor.setSelected(p.casas.get(0).isAscensor());
        chkGaraje.setSelected(p.casas.get(0).isGaraje());
        indexC = 0;
    }

    @FXML
    private void vincularCasa(ActionEvent event) {
    }

    @FXML
    private void crearPropietario(ActionEvent event) {

        p.crearPropietarios(txtDNI.getText(), txtNombre.getText(), txtApellido.getText());
        c.generarArray();
        txtNombre.setDisable(true);
        txtApellido.setDisable(true);
        txtDNI.setDisable(true);
        txtNombre.setText(c.propietarios.get(0).getNombre());
        txtApellido.setText(c.propietarios.get(0).getApellido());
        txtDNI.setText(c.propietarios.get(0).getDni());
        btnAtrasP.setDisable(false);
        btnSiguienteP.setDisable(false);
        btnVincularPropietario.setDisable(false);
        btnBorrarPropietario.setDisable(false);
        btnCancelarP.setDisable(true);
        btnNuevoPropietario.setDisable(false);
        btnCrearPropietario.setDisable(true);
        indexP = 0;
        btnModificarP.setDisable(false);
        btnGuardarP.setDisable(true);
    }

    @FXML
    private void nuevoPropietario(ActionEvent event) {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDNI.setText("");
        btnCrearPropietario.setDisable(false);
        btnCancelarP.setDisable(false);
        txtNombre.setDisable(false);
        txtApellido.setDisable(false);
        txtDNI.setDisable(false);
        btnAtrasP.setDisable(true);
        btnSiguienteP.setDisable(true);
        btnVincularPropietario.setDisable(true);
        btnBorrarPropietario.setDisable(true);
        btnNuevoPropietario.setDisable(true);
        btnModificarP.setDisable(true);
        btnGuardarP.setDisable(true);
    }

    @FXML
    private void propietarioAnterior(ActionEvent event) {
        indexP--;
        txtNombre.setText(c.propietarios.get(indexP).getNombre());
        txtApellido.setText("" + c.propietarios.get(indexP).getApellido());
        txtDNI.setText("" + c.propietarios.get(indexP).getDni());

    }

    @FXML
    private void propietarioSiguiente(ActionEvent event) {
        indexP++;
        txtNombre.setText(c.propietarios.get(indexP).getNombre());
        txtApellido.setText("" + c.propietarios.get(indexP).getApellido());
        txtDNI.setText("" + c.propietarios.get(indexP).getDni());
    }

    @FXML
    private void vincularPropietario(ActionEvent event) {
    }

    @FXML
    private void borrarPropietario(ActionEvent event) {
        p.borrarPropietario(p.dni);
        c.generarArray();
        txtNombre.setText(c.propietarios.get(0).getNombre());
        txtApellido.setText(c.propietarios.get(0).getApellido());
        txtDNI.setText(c.propietarios.get(0).getDni());
        indexP = 0;
    }

    @FXML
    private void cancelarPropietario(ActionEvent event) {
        txtNombre.setDisable(true);
        txtApellido.setDisable(true);
        txtDNI.setDisable(true);
        btnAtrasP.setDisable(false);
        btnSiguienteP.setDisable(false);
        btnVincularPropietario.setDisable(false);
        btnBorrarPropietario.setDisable(false);
        btnCancelarP.setDisable(true);
        btnNuevoPropietario.setDisable(false);
        btnCrearPropietario.setDisable(true);
        btnModificarP.setDisable(false);
        btnGuardarP.setDisable(true);
        txtNombre.setText(c.propietarios.get(0).getNombre());
        txtApellido.setText(c.propietarios.get(0).getApellido());
        txtDNI.setText(c.propietarios.get(0).getDni());
        indexP = 0;
        
        
    }

    @FXML
    private void modificarPropietario(ActionEvent event) {
        btnVincularPropietario.setDisable(true);
        btnBorrarPropietario.setDisable(true);
        btnCancelarP.setDisable(false);
        txtNombre.setDisable(false);
        txtApellido.setDisable(false);
        txtDNI.setDisable(false);
        btnGuardarP.setDisable(false);
        btnAtrasP.setDisable(true);
        btnSiguienteP.setDisable(true);
        btnNuevoPropietario.setDisable(true);
    }

    @FXML
    private void guardarCambiosCP(ActionEvent event) {
        p.modificarPropietario(txtDNI.getText(), txtNombre.getText(), txtApellido.getText());
        c.generarArray();
        txtNombre.setDisable(true);
        txtApellido.setDisable(true);
        txtDNI.setDisable(true);
        btnAtrasP.setDisable(false);
        btnSiguienteP.setDisable(false);
        btnVincularPropietario.setDisable(false);
        btnBorrarPropietario.setDisable(false);
        btnCancelarP.setDisable(true);
        btnNuevoPropietario.setDisable(false);
        btnCrearPropietario.setDisable(true);
        btnModificarP.setDisable(false);
        btnGuardarP.setDisable(true);
        txtNombre.setText(c.propietarios.get(0).getNombre());
        txtApellido.setText("" + c.propietarios.get(0).getApellido());
        txtDNI.setText("" + c.propietarios.get(0).getDni());

        indexP = 0;
    }
}
