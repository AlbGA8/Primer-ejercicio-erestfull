package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.es.restfull.productos.domain.model.ProductoId;

public record ProductoResponse(ProductoId id, String nombre, double precio, LocalDateTime createdAt) {
	
}
