package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelClienteControlador implements Initializable {

    @FXML
    private Button btnCerrar;




    // metodo para modificar los datos de un usuario
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
        cerrarVentana();
        navegarVentana("/inicio.fxml", "Banco - Tranferir Dinero");


    }

    // cerrar una ventana

    public void cerrarVentana(){
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
