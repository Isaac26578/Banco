package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelClienteControlador implements Initializable {



    // este boton me dirije a la view de transferir
    public void transferencia (ActionEvent e){

        navegarVentana("/Transferir.fxml", "Banco - Tranferir Dinero");

    }

    // navegacion entre ventanas
    public void navegarVentana(String nombreArchivoFxml, String tituloVentana) {
        try {

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

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void cerrar(ActionEvent event) {
        //cerrarVentana();
        navegarVentana("/inicio.fxml", "Banco - Tranferir Dinero");


    }

    // cerrar una ventana

    //public void cerrarVentana(){
      //  Stage stage = (Stage) btnCerrar.getScene().getWindow();
      //  stage.close();
    // }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    public void Editar(ActionEvent event) {

        navegarVentana("/Crud.fxml", "Hola");
    }


    // metodo para consultar

    public void Consultar(ActionEvent event) {

    }
}
