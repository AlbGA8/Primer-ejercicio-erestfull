package es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria;

import java.util.List;

import es.etg.daw.dawes.java.es.restfull.productos.domain.error.ProductoNotFoundException;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class FindCategoriaUseCase {
     private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> categoria = categoriaRepository.getAll();

        if (categoria.isEmpty())
            throw new ProductoNotFoundException();

        return categoria;
    }

}
