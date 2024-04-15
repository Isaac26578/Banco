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

public class loginControlador {

    @FXML
    private TextField txtIdentificacion;
    @FXML
    private PasswordField txtPassword;
    private final Banco banco = Banco.getInstancia();
    private final Sesion sesion = Sesion.getInstancia();

    public void IniciarSesion (ActionEvent e) throws Exception {
        try {

        Usuario usuario = sesion.getUsuario();
        sesion.setUsuario(usuario);
        String nombre, contrasena;
        nombre= txtIdentificacion.getText();
        contrasena = txtPassword.getText();
        usuario= banco.validarUsuario(nombre, contrasena);

        Sesion sesion = Sesion.getInstancia();
        sesion.setUsuario(usuario);

        if (usuario.getNumeroIdentificacion().equals(nombre)){

                // si el usuario existe dejelo entrar a la ventana principal
                navegarVentana("/panel.fxml");
                cerrarVentana();

        }

        } catch (Exception E){

            mostrarAlerta(E.getMessage(), Alert.AlertType.ERROR);


        }

  }


    public void navegarVentana(String nombreArchivoFxml) {
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
            stage.setTitle("");

            // Mostrar la nueva ventana
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

 // metodo para mostrar un mensaje
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }


    // metodo para cerrar una ventana
    public void cerrarVentana(){
        Stage stage = (Stage) txtIdentificacion.getScene().getWindow();
        stage.close();
    }



}
