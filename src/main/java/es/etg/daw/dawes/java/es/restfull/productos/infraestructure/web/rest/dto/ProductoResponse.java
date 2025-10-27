package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto;

import java.time.LocalDateTime;

public record ProductoResponse(int id, String nombre, double precio, LocalDateTime createdAt) {
	
}
