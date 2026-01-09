package es.etg.daw.dawes.java.es.restfull.productos.domain.model;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Categoria {

   
        // Atributos
        private String nombre;
        private CategoriaId id;
        private LocalDateTime createdAt;
     


}
