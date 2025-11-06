package es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria;

import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoriaUseCase {
    private final CategoriaRepository categoriaRepository;

    public void delete(CategoriaId id) {

        categoriaRepository.deteteById(id);

    }

}
