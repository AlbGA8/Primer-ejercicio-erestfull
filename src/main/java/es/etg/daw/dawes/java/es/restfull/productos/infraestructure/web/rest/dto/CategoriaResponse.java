package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto;

import java.time.LocalDateTime;

public class CategoriaResponse {

    public record  CategoriaRequest (int id,String nombre, LocalDateTime createdAt) {
    
}

}
