package es.etg.daw.dawes.java.es.restfull.productos.application.services.categoria;

import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoriaService {

    private final DeleteCategoriaUseCase deleteCategoriaUseCase;

    public void delete(CategoriaId id) {

        deleteCategoriaUseCase.delete(id);
        
    }


}
