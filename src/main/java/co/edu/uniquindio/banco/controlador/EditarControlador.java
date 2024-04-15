package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Banco;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarControlador {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;
    // variable global
    private final Banco banco = Banco.getInstancia();
    private final Sesion sesion = Sesion.getInstancia();

    // metodo para agregar usuarios
    public void Actualizar(ActionEvent event){
        try{
            Usuario user;

           user=  sesion.getUsuario();

            banco.actualizarUsuario(txtNombre.getText(), txtDireccion.getText(), txtIdentificacion.getText(), txtCorreo.getText(), txtPassword.getText());


            mostrarAlerta("Datos Actualizados correctamente", Alert.AlertType.INFORMATION);
            cerrarVentana();

            //cerrarVentana();

        }catch (Exception e)
        {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);

        }

    }


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

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }

    public void cerrarVentana(){
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }

}
