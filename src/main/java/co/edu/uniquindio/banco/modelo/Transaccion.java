package co.edu.uniquindio.banco.modelo;
import co.edu.uniquindio.banco.modelo.enums.CategoriaTransaccion;
import co.edu.uniquindio.banco.modelo.enums.TipoTransaccion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// lonbok
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Transaccion {
    // encapsulamos los datos
    private final TipoTransaccion tipo; // "Depósito" o "Retiro"
    private final float monto;
    private final Usuario usuario; // Usuario emisor o destinatario de la transacción
    private final LocalDateTime fecha;
    private final CategoriaTransaccion categoria;

}
