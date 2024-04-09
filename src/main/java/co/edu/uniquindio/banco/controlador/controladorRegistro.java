package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Banco;
import co.edu.uniquindio.banco.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controladorRegistro {
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtContra;

    // variable global
    private final Banco banco = Banco.getInstancia();


    // metodo para agregar usuarios
    public void agregarUsuarios(ActionEvent event){
        try{

            banco.agregarUsuario(txtNombre.getText(), txtDireccion.getText(), txtId.getText(), txtCorreo.getText(), txtContra.getText());

            banco.agregarCuentaAhorros(txtId.getText(), 0F);
            crearAlerta("Usuario registrado correctamente", Alert.AlertType.INFORMATION);

            navegarVentana("/inicio.fxml", "Banco - Registro de Cliente");
            cerrarVentana();

        }catch (Exception e)
        {
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);

        }


    }


    // Metodo para mostrar una alerta
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){


        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();


    }


    // metodo para navegar entre ventanas
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
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // metodo para crear una alerta
    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }



    // metodo para cerrar una ventana
    public void cerrarVentana(){
        Stage stage = (Stage) txtId.getScene().getWindow();
        stage.close();
    }





}
