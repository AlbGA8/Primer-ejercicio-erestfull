package es.etg.daw.dawes.java.es.restfull.productos.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Producto {

    public Producto(ProductoId i, String string, double d, LocalDateTime now) {
        //TODO Auto-generated constructor stub
    }
    // Atributos
	private ProductoId id;
	private String nombre;
	private double precio;
	private LocalDateTime createdAt;
	//agregamos la categoria
	private CategoriaId categoria;

}
