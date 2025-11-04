package es.etg.daw.dawes.java.es.restfull.productos.application.services.producto;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class EditProductoService {

    private final EditProductoUseCase editProductoUseCase;

    public Producto update(EditProductoCommand command){
        Producto producto = editProductoUseCase.update(command);
        return producto;
    }
    

}
