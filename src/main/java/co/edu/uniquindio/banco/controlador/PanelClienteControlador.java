package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.controlador.observador.Observable;
import co.edu.uniquindio.banco.modelo.Banco;
import co.edu.uniquindio.banco.modelo.Transaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PanelClienteControlador implements Initializable, Observable {

    private TableView<Transaccion> tablaMovimientos;

    private final Banco banco = Banco.getInstancia();



    // este boton me dirije a la view de transferir
    public void transferencia (ActionEvent e) throws IOException {

        FXMLLoader loader =navegarVentana("/Transferir.fxml", "Banco - Tranferir Dinero");
        transferirControlador controlador = loader.getController();
        controlador.inicializarObservable(this);
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




    public void cerrar(ActionEvent eve) {
        //cerrarVentana();
        navegarVentana2("/inicio.fxml", "Banco - Tranferir Dinero");


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

        navegarVentana2("/Crud.fxml", "Hola");
    }


    // metodo para consultar

    public void Consultar(ActionEvent event)  {

        navegarVentana2("/Movimientos.fxml", "Hola");

    }

    // metodo nuevo

    public void irTranferencia () throws IOException {
        FXMLLoader loader = navegarVentana("/Movimientos.fxml", "Banco- Actualizar cliente");
        transferirControlador controlador = loader.getController();

    }

    public void navegarVentana2(String nombreArchivoFxml, String hola) {
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


    @Override
    public void notificar() {

    }
}
