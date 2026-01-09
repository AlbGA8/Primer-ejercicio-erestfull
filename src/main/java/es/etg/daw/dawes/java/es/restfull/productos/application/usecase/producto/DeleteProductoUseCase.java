package es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto;

import es.etg.daw.dawes.java.es.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductoUseCase {

    private final ProductoRepository productoRepository;
    
    public void delete(ProductoId id){ //Lo cambiamos
        productoRepository.deteteById(id);
    }

}
