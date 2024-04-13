package co.edu.uniquindio.banco.controlador;


import co.edu.uniquindio.banco.controlador.observador.Observable;
import co.edu.uniquindio.banco.modelo.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MovimientosControlador implements Initializable ,Observable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNmrCuenta;
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
    TableView<Transaccion> tablaMovientos;

    private String numeroCuentaOrigen;

    private final Banco banco = Banco.getInstancia();
    private final Sesion sesion = Sesion.getInstancia();

    private CuentaAhorros cuenta;
    private Observable observable;

    // Metodo para navegar entre ventanas


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //no me recibe los getter y setter
        colMonto.setCellValueFactory(cellData -> new SimpleStringProperty( ""+cellData.getValue().getMonto()) );
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty( cellData.getValue().getCategoria().toString() ));
        colUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNombre()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        colTipo.setCellValueFactory(cellData -> new SimpleStringProperty( cellData.getValue().getTipo().toString()));

    }








    // metodo para obtener la cuenta de ahorros del usuario
    public void obtenerCuenta (Usuario us ){

        // lanzamos una exepcion

        try {

            if(us != null){
                sesion.getCuenta().getNumeroCuenta();
                cuenta= banco.consultarCuentasUsario(us.getNumeroIdentificacion());
                sesion.setCuenta(cuenta);
                consultarTransacciones ();

            }

        } catch (Exception ex){


        }

    }



    // metodo para consultar las transacciones
    public  void consultarTransacciones (){

        tablaMovientos.setItems(FXCollections.observableArrayList(cuenta.getTransacciones()));
    }


    public void inicializarValores(String numeroCuentaorigen ,TableView<Transaccion> tablaMovientos){
        this.tablaMovientos = tablaMovientos;
        this.numeroCuentaOrigen = numeroCuentaorigen;


    }


    // nuevo
    @Override
    public void notificar() {
        consultarTransacciones ();

    }

    public void inicializarObservable(Observable observador) {
        this.observable = observador;
    }




}

