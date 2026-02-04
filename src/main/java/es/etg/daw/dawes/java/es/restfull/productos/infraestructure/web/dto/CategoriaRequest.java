package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.dto;

import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.validation.producto.NombradoProducto;
import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
        @NotBlank(message = "{categoria.valid.nombre.no_vacio}") 
        @NombradoProducto(message = "{producto.valid.nombre.nombrado_validation}") 
        String nombre) {
            

    public CategoriaRequest(Categoria c) {
        this(c.getNombre());
    }

}
