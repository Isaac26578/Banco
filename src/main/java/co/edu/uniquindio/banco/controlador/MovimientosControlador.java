package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.controlador.observador.Observable;
import co.edu.uniquindio.banco.modelo.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MovimientosControlador implements Initializable{

    @FXML
    private TableColumn<Transaccion, String> colFecha;
    @FXML
    private TableColumn<Transaccion, String> colMonto;
    @FXML
    private TableColumn<Transaccion,String> colTipo;
    @FXML
    private TableColumn<Transaccion, String> colUsuario;
    @FXML
    private TableColumn<Transaccion, String> colCategoria;
    @FXML
    private Label txtNombre;




    @FXML
    private  TableView<Transaccion> tablaMovimientos;

    private String numeroCuentaOrigen;

    private final Banco banco = Banco.getInstancia();
    private final Sesion sesion = Sesion.getInstancia();

    private CuentaAhorros cuenta;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Usuario us = sesion.getUsuario();
        inicializarValoresCuenta(us);
        tablaMovimientos.setItems(FXCollections.observableArrayList(cuenta.getTransacciones()));
        inicializarValores();

        colTipo.setCellValueFactory(cellData -> new SimpleStringProperty( cellData.getValue().getTipo().toString()));
        colMonto.setCellValueFactory(cellData -> new SimpleStringProperty( ""+cellData.getValue().getMonto()) );
        colUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNombre()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty( cellData.getValue().getCategoria().toString() ));




    }

    // metodo para obtener la cuenta de ahorros del usuario
    public void inicializarValoresCuenta (Usuario us ){

        // lanzamos una exepcion

        try {

            if(us != null){
                cuenta= banco.consultarCuentasUsario(us.getNumeroIdentificacion());
                sesion.setCuenta(cuenta);
                System.out.println(cuenta.getTransacciones().getFirst());
               // tablaMovientos.setItems(FXCollections.observableArrayList(cuenta.getTransacciones()));

            }

        } catch (Exception ex){

            mostrarAlerta("la tabla esta vacia", Alert.AlertType.INFORMATION);

        }

    }

    // metodo para consultar las transacciones


    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){

        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }

    public void inicializarValores(){
        String resultadoConsulta;

        Usuario usuario = sesion.getUsuario();
        resultadoConsulta = banco.ConsultarNombre(usuario.getNumeroIdentificacion(), usuario.getContrasena());
        //el txtNombre también se coloca en e label en el movimientosFxml
        txtNombre.setText(resultadoConsulta);
    }

    public void cerrar(ActionEvent event) throws IOException {

        navegarVentana("/panel.fxml","Inicio");

    }


    // cerrar ventana de movimientos
    public FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana) throws IOException {


        // Cargar la vista
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
        Parent root = loader.load();

        // Crear la escena
        Scene scene = new Scene(root);

        // Crear un nuevo escenario (ventana)
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("panel");

        // Mostrar la nueva ventana
        stage.show();
        return loader;

    }
}


