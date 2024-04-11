package co.edu.uniquindio.banco.modelo;

import lombok.*;

@AllArgsConstructor  // me inicializa el constructor
@Builder             // me genra el patron de diseño build
@Getter              // me genera los getters de esta clase
@Setter              // me genera los metodos setters de esta clase
@ToString            // me genera el metodo toString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Usuario {
    private String jason;
    @EqualsAndHashCode.Include
    // encapsulamos los datos
    private final String numeroIdentificacion;

    private final String nombre;
    private final String direccion;
    private final String correoElectronico;
    private final String contrasena;

}
