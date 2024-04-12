package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Banco;
import co.edu.uniquindio.banco.modelo.CuentaAhorros;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.Usuario;
import co.edu.uniquindio.banco.modelo.enums.CategoriaTransaccion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class transferirControlador implements Initializable {


    @FXML
    private TextField txtCuenta;

    @FXML
    private TextField txtMonto;

    @FXML
    private ComboBox<String> txtCategoria;

    private final Banco banco = Banco.getInstancia();

    private final Sesion sesion = Sesion.getInstancia();

    // metodo para tranferir una cuenta
    public void realizarTransferencia(ActionEvent event) throws Exception {

        try {

            List<CuentaAhorros> cuentas = new ArrayList<>();
            // tenemos el usuario
            Usuario usuario = sesion.getUsuario();
            cuentas= banco.consultarCuentasUsario(usuario.getNumeroIdentificacion(), usuario.getContrasena());



            banco.realizarTransferencia(cuentas.get(0).getNumeroCuenta(), txtCuenta.getText(), Float.parseFloat(txtMonto.getText()), CategoriaTransaccion.valueOf(txtCategoria.getValue()));

            txtCuenta.clear();
            txtMonto.clear();
            txtCategoria.setValue(null);


            mostrarAlerta("La transferencia se realizó correctamente", Alert.AlertType.INFORMATION);

        } catch (Exception e){

            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);

        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCategoria.setItems( FXCollections.observableArrayList(banco.listarCategorias()));
    }


    // Metodo para mostrar una alerta
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }


}


