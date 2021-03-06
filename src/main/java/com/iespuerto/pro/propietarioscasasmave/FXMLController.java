package com.iespuerto.pro.propietarioscasasmave;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TextField txtNombreC;
    private TextField txtApellidoC;
    private TextField txtDNIC;
    private TextArea txaPropietario;
    private TextField txtDireccionP;
    private TextField txtPrecioP;
    private TextField txtMetrosP;
    private CheckBox chkGarajeP;
    private CheckBox chkAscensorP;
    private TextArea txaCasa;
    
    int idPropietario = 0;
    int contadorPropietarios = 0;
    int contadorCasas = 0;
    @FXML
    private TableColumn<Propietarios, String> tablePColDNI;
    @FXML
    private TableColumn<Propietarios, String> tablePColNombre;
    @FXML
    private TableColumn<Propietarios, String> tablePColApellido;
    @FXML
    private TableView<Propietarios> tableViewP;
    @FXML
    private Tab tabCasas;
    @FXML
    private Tab tabPropietarios;
    @FXML
    private TableColumn<Casas, Integer> tableColCID;
    @FXML
    private TableColumn<Casas, String> tableColCDireccion;
    @FXML
    private TableColumn<Casas, Double> tableColCPrecio;
    @FXML
    private TableColumn<Casas, Double> tableColCMetros;
    @FXML
    private TableColumn<Casas, Boolean> tableColCGaraje;
    @FXML
    private TableColumn<Casas, Boolean> tableColCAscensor;
    @FXML
    private TableView<Casas> tableViewC;
    @FXML
    private TableView<Casas> tableViewC1;
    @FXML
    private TableColumn<Casas, Integer> tableColCID1;
    @FXML
    private TableColumn<Casas, String> tableColCDireccion1;
    @FXML
    private TableColumn<Casas, Double> tableColCPrecio1;
    @FXML
    private TableColumn<Casas, Double> tableColCMetros1;
    @FXML
    private TableColumn<Casas, Boolean> tableColCGaraje1;
    @FXML
    private TableColumn<Casas, Boolean> tableColCAscensor1;
    @FXML
    private Button btnBorrarVinculo;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    private void crearTablaC(){
        tableColCID.setCellValueFactory(new PropertyValueFactory<Casas,Integer>("id"));
        tableColCDireccion.setCellValueFactory(new PropertyValueFactory<Casas,String>("direccion"));
        tableColCMetros.setCellValueFactory(new PropertyValueFactory<Casas,Double>("metros"));
        tableColCPrecio.setCellValueFactory(new PropertyValueFactory<Casas,Double>("precio"));
        tableColCAscensor.setCellValueFactory(new PropertyValueFactory<Casas,Boolean>("ascensor"));
        tableColCGaraje.setCellValueFactory(new PropertyValueFactory<Casas,Boolean>("garaje"));
        tableViewC.setItems(FXCollections.observableArrayList(p.casas));
    }
    
    private void crearTablaP(){
        tablePColDNI.setCellValueFactory(new PropertyValueFactory<Propietarios,String>("dni"));
        tablePColNombre.setCellValueFactory(new PropertyValueFactory<Propietarios,String>("nombre"));
        tablePColApellido.setCellValueFactory(new PropertyValueFactory<Propietarios,String>("apellido"));
        tableViewP.setItems(FXCollections.observableArrayList(c.propietarios));
    }
    private void crearTablaC1(Propietarios propietarioComprador){
        tableColCID1.setCellValueFactory(new PropertyValueFactory<Casas,Integer>("id"));
        tableColCDireccion1.setCellValueFactory(new PropertyValueFactory<Casas,String>("direccion"));
        tableColCMetros1.setCellValueFactory(new PropertyValueFactory<Casas,Double>("metros"));
        tableColCPrecio1.setCellValueFactory(new PropertyValueFactory<Casas,Double>("precio"));
        tableColCAscensor1.setCellValueFactory(new PropertyValueFactory<Casas,Boolean>("ascensor"));
        tableColCGaraje1.setCellValueFactory(new PropertyValueFactory<Casas,Boolean>("garaje"));
        tableViewC1.setItems(FXCollections.observableArrayList(propietarioComprador.casas));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c.generarArray();
        p.generarArray();
        crearTablaP();
        crearTablaC();
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
        txtDireccion.setText(p.casas.get(contadorCasas).getDireccion());
        txtPrecio.setText("" + p.casas.get(contadorCasas).getPrecio());
        txtMetros.setText("" + p.casas.get(contadorCasas).getMetros());
        chkAscensor.setSelected(p.casas.get(contadorCasas).isAscensor());
        chkGaraje.setSelected(p.casas.get(contadorCasas).isGaraje());
        txtNombre.setText(c.propietarios.get(contadorPropietarios).getNombre());
        txtApellido.setText("" + c.propietarios.get(contadorPropietarios).getApellido());
        txtDNI.setText("" + c.propietarios.get(contadorPropietarios).getDni());

    }

    @FXML
    private void crearCasa(ActionEvent event) {
        int ultimoIdCasa = c.getUltimoID();
        c.crearCasa(Double.parseDouble(txtPrecio.getText()), txtDireccion.getText()
                , Double.parseDouble(txtMetros.getText()), chkGaraje.isSelected(), chkAscensor.isSelected(), ultimoIdCasa);

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

        
        if (contadorCasas <= 0) {
            contadorCasas = p.casas.size();
        }
        contadorCasas--;
        txtDireccion.setText(p.casas.get(contadorCasas).getDireccion());
        txtPrecio.setText("" + p.casas.get(contadorCasas).getPrecio());
        txtMetros.setText("" + p.casas.get(contadorCasas).getMetros());
        chkAscensor.setSelected(p.casas.get(contadorCasas).isAscensor());
        chkGaraje.setSelected(p.casas.get(contadorCasas).isGaraje());
        
    }

    @FXML
    private void casaSiguiente(ActionEvent event) {
        
        if (contadorCasas >= p.casas.size()-1) {
            contadorCasas = -1;
        }
        contadorCasas++;
        txtDireccion.setText(p.casas.get(contadorCasas).getDireccion());
        txtPrecio.setText("" + p.casas.get(contadorCasas).getPrecio());
        txtMetros.setText("" + p.casas.get(contadorCasas).getMetros());
        chkAscensor.setSelected(p.casas.get(contadorCasas).isAscensor());
        chkGaraje.setSelected(p.casas.get(contadorCasas).isGaraje());
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
        c.borrarCasa(p.casas.get(contadorCasas));
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
        c.modificarCasa(Double.parseDouble(txtPrecio.getText()), txtDireccion.getText()
                , Double.parseDouble(txtMetros.getText()), chkGaraje.isSelected(), chkAscensor.isSelected(), c.id);
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
        String dni = tableViewP.getSelectionModel().getSelectedItem().dni;
        int id = p.casas.get(contadorCasas).id;
        c.vincularCasa(id, dni);
        Propietarios p = tableViewP.getSelectionModel().getSelectedItem();
        Propietarios temp = p.generarArrayPropietariosCasas(p);
        crearTablaC1(temp);
    }

    @FXML
    private void crearPropietario(ActionEvent event) {

        p.crearPropietarios(txtDNI.getText(), txtNombre.getText(), txtApellido.getText(), idPropietario);
        idPropietario++;
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
        
        if (contadorPropietarios <= 0) {
            contadorPropietarios = c.propietarios.size();
        }
        contadorPropietarios--;
        txtNombre.setText(c.propietarios.get(contadorPropietarios).getNombre());
        txtApellido.setText("" + c.propietarios.get(contadorPropietarios).getApellido());
        txtDNI.setText("" + c.propietarios.get(contadorPropietarios).getDni());
        
    }

    @FXML
    private void propietarioSiguiente(ActionEvent event) {
        
        if (contadorPropietarios >= c.propietarios.size() - 1) {
            contadorPropietarios = -1;
        }
        contadorPropietarios++;
        txtNombre.setText(c.propietarios.get(contadorPropietarios).getNombre());
        txtApellido.setText("" + c.propietarios.get(contadorPropietarios).getApellido());
        txtDNI.setText("" + c.propietarios.get(contadorPropietarios).getDni());
        
    }

    @FXML
    private void vincularPropietario(ActionEvent event) {
        int id = tableViewC.getSelectionModel().getSelectedItem().id;
        String dni = txtDNI.getText();
        
        p.vincularPropietario(id, dni);
    }

    @FXML
    private void borrarPropietario(ActionEvent event) {
        p.borrarPropietario(c.propietarios.get(contadorPropietarios));
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

    private void propietarioAnteriorC(MouseEvent event) {
        if(contadorPropietarios < 0) {
            contadorPropietarios = c.propietarios.size() - 1;
        }
        Propietarios pC = c.propietarios.get(contadorPropietarios);        
        txtNombreC.setText(pC.nombre);
        txtApellidoC.setText(pC.apellido);
        txtDNIC.setText(pC.dni);
        txaPropietario.appendText(c.propietarios.toString());
        contadorPropietarios--;
    }

    private void propietarioSiguienteC(MouseEvent event) {
        if(contadorPropietarios >= c.propietarios.size()) {
            contadorPropietarios = 0;
        }
        Propietarios pC = c.propietarios.get(contadorPropietarios);        
        txtNombreC.setText(pC.nombre);
        txtApellidoC.setText(pC.apellido);
        txtDNIC.setText(pC.dni);
        txaPropietario.appendText(c.propietarios.toString());
        contadorPropietarios++;
    }

    private void casaAnteriorP(MouseEvent event) {
        System.out.println("comienzo");
        if (contadorCasas < 0) {
            contadorCasas = p.casas.size();
        }
        System.out.println("sds");
        Casas cP = p.casas.get(contadorCasas);
        System.out.println("gsd");
        txtDireccionP.setText(cP.direccion);
        txtMetrosP.setText(""+cP.metros);
        txtPrecioP.setText(""+cP.precio);
        chkAscensorP.setSelected(cP.ascensor);
        chkGarajeP.setSelected(cP.garaje);
        txaCasa.appendText(p.casas.toString());
        contadorCasas--;
        System.out.println("\n\nllegoo aquii");
    }

    private void casaSiguienteP(MouseEvent event) {
        //int max = c.propietarios.size() - 1;
        int max = p.casas.size();
        if (contadorCasas >= max) {
            contadorCasas = 0;
        }
        Casas cP = p.casas.get(contadorCasas);
        txtDireccionP.setText(cP.direccion);
        txtMetrosP.setText(""+cP.metros);
        txtPrecioP.setText(""+cP.precio);
        chkAscensorP.setSelected(cP.ascensor);
        chkGarajeP.setSelected(cP.garaje);
        txaCasa.appendText(p.casas.toString());
        contadorCasas++;
    }

    @FXML
    private void tabCasasSelected(Event event) {
        crearTablaP();
    }

    @FXML
    private void tabPropietariosSelected(Event event) {
        crearTablaC();
    }

    @FXML
    private void mostrarCasas(MouseEvent event) {
        Propietarios propietarioActual = tableViewP.getSelectionModel().getSelectedItem();
        Propietarios propietarioComprador = propietarioActual.generarArrayPropietariosCasas(propietarioActual);
        crearTablaC1(propietarioComprador);
    }

    @FXML
    private void borrarVinculo(MouseEvent event) {
        Propietarios p = tableViewP.getSelectionModel().getSelectedItem();
        Casas c = tableViewC1.getSelectionModel().getSelectedItem();
        c.borrarVinculo(c);
        Propietarios temp = p.generarArrayPropietariosCasas(p);
        crearTablaC1(temp);
        btnBorrarVinculo.setDisable(true);
    }

    @FXML
    private void casavinculadaSelected(MouseEvent event) {
        btnBorrarVinculo.setDisable(false);
    }
    
}
