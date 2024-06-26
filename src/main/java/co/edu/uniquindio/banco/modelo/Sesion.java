package co.edu.uniquindio.banco.modelo;


import lombok.Getter;
import lombok.Setter;

// clase para guardae los datos del usuario
public class Sesion {

    // creamos el singlenton
    public static Sesion INSTANCIA;


    @Getter
    @Setter

    // encapsulamos los datos

    private Usuario usuario;
    private CuentaAhorros cuenta;

    // constructor vacio y privado


    private Sesion() {
    }


    public static Sesion getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }


    public void cerrarSesion() {
        usuario = null;
        // variable nueva
        cuenta= null;

    }


    // metodo nuevo

    public void setCuenta(CuentaAhorros cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaAhorros getCuenta() {
        return cuenta;
    }

}

