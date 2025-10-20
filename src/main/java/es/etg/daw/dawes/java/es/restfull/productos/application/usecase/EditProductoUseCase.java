package es.etg.daw.dawes.java.es.restfull.productos.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class EditProductoUseCase {
    private final EditProductoUseCase editProductoUseCase;

    public Producto update(EditProductoCommand command){
        
        return editProductoUseCase.update(command);
    }
    
}
