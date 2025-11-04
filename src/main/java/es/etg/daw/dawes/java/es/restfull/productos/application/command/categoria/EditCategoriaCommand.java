package es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria;

import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditCategoriaCommand {

    private CategoriaId id;
	private String nombre;
	private double precio;

}
