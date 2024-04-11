package co.edu.uniquindio.banco.controlador;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Movimientos implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNmrCuenta;
    @FXML
    private TableView<Movimientos> tablaMovimientos;
    @FXML
    private TableColumn<String, Movimientos> colFecha;
    @FXML
    private TableColumn<String, Movimientos> colCategoria;
    @FXML
    private TableColumn<String, Movimientos> colMonto;
    @FXML
    private TableColumn<String, Movimientos> colUsuario;




    // Metodo para navegar entre ventanas
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

    //Metodo para cerrar la ventana
    public void cerrar(ActionEvent event) {
        //cerrarVentana();
        navegarVentana("/inicio.fxml", "Banco - Tranferir Dinero");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colMonto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMonto()));
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        colUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));

    }
}
