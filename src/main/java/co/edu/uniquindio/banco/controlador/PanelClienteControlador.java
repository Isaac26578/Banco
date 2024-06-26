package co.edu.uniquindio.banco.controlador;


import co.edu.uniquindio.banco.modelo.Banco;

import co.edu.uniquindio.banco.modelo.*;
import co.edu.uniquindio.banco.modelo.CuentaAhorros;
import co.edu.uniquindio.banco.modelo.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;

import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PanelClienteControlador implements Initializable {

    private final Banco banco = Banco.getInstancia();

    private CuentaAhorros cuentaAhorros;



    @FXML
    private Label lblSaldo;
    @FXML
    private String txtIdentificacion;
    @FXML
    private PasswordField txtPassword;
    private final Sesion sesion = Sesion.getInstancia();

    public void transferencia (ActionEvent e) throws IOException {

        FXMLLoader loader = navegarVentana("/Transferir.fxml", "Banco - Tranferir Dinero");

    }

    // navegacion entre ventanas
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




    public void cerrar(ActionEvent eve) throws IOException {
        //cerrarVentana();
        navegarVentana("/inicio.fxml", "Banco - Tranferir Dinero");


    }


    // creamos una alerta
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }


    // este boton cuando le demos en editar me dijire a la viem del crud
    public void Editar(ActionEvent event) throws IOException {
        navegarVentana("/Crud.fxml", "Hola");

    }
    // metodo para cuando se le da el boton consultar nos leve a la ventana de movimientos

    public void Consultar(ActionEvent event) throws IOException {

        navegarVentana("/Movimientos.fxml", "Hola");
    }

    public void ConsultarSaldo() throws Exception {

        float Saldo;

        Usuario usuario = sesion.getUsuario();
        Saldo = banco.ConsultarSaldo(usuario.getNumeroIdentificacion(), usuario.getContrasena());
        mostrarAlerta("Su saldo es:"+Saldo,Alert.AlertType.INFORMATION);

    }

    public void inicializarValores(){
        String resultadoConsulta;

        Usuario usuario = sesion.getUsuario();
        resultadoConsulta = banco.ConsultarNombre(usuario.getNumeroIdentificacion(), usuario.getContrasena());
        lblSaldo.setText(resultadoConsulta);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializarValores();
    }



} // ultimo



