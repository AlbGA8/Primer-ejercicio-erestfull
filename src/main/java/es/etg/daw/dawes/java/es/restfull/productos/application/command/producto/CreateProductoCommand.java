package es.etg.daw.dawes.java.es.restfull.productos.application.command.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)

public class CreateProductoCommand {

	private String nombre;
	private double precio;

}
