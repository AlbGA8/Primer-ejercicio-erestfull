package es.etg.daw.dawes.java.es.restfull.productos.application.services.producto;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto.CreateProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CreateProductoService extends ProductoService{

    private final CreateProductoUseCase createProductoUseCase;

    @CacheEvict (allEntries = true) //Elimina de cache la lista
    public Producto createProducto(CreateProductoCommand comando){
        Producto producto = createProductoUseCase.create(comando);
        return producto;
    }
    
}
