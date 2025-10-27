package es.etg.daw.dawes.java.es.restfull.productos.application.services;

import org.springframework.stereotype.Service;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.DeleteProductoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class DeleteProductoService {

    private final DeleteProductoUseCase deleteProductoUseCase;

    public void delete(int id) {

        deleteProductoUseCase.delete(id);
        

    }

}
