package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Banco;
import co.edu.uniquindio.banco.modelo.enums.CategoriaTransaccion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class transferirControlador implements Initializable {

    private float monto;



    @FXML
    private TextField txtNumeroCuenta;

    @FXML TextField txtNumeroCuentaDestino;

    @FXML
    private TextField txtMontoTransferir;

    @FXML
    private ComboBox<String> txtCategoria;

    private final Banco banco = Banco.getInstancia();

    // metodo para tranferir una cuenta
    public void realizarTransferencia(ActionEvent event) throws Exception {

        try {

            banco.realizarTransferencia(txtNumeroCuenta.getText(), txtNumeroCuentaDestino.getText(), monto = Float.parseFloat(txtMontoTransferir.getText()), CategoriaTransaccion.valueOf(txtCategoria.getValue()));
            txtNumeroCuenta.clear();
            txtNumeroCuentaDestino.clear();
            txtCategoria.setValue(null);

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


