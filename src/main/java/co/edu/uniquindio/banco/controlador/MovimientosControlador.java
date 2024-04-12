package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.Transaccion;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
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

public class MovimientosControlador implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNmrCuenta;
    @FXML
    private TableView<Transaccion> tablaMovimientos;
    @FXML
    private TableColumn<Transaccion, String> colFecha;

    @FXML
    private TableColumn<Transaccion, String> colCategoria;
    @FXML
    private TableColumn<Transaccion, String> colMonto;
    @FXML
    private TableColumn<Transaccion, String> colUsuario;




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
            stage.setTitle(tituloVentana);

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

        colMonto.setCellValueFactory(cellData -> new SimpleStringProperty( ""+cellData.getValue().getMonto()) );
        colCategoria.setCellValueFactory(cellData -> new SimpleStringProperty( cellData.getValue().getCategoria().toString() ));
        colUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNombre()));
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));

    }
}

