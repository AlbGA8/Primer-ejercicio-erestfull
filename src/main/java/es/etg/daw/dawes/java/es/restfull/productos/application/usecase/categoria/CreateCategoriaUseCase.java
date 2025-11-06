package es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)
public class CreateCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public Categoria create(CreateCategoriaCommand comando) {

        Categoria categoria = Categoria.builder() // Se puede usar comando.id y no getId por usar @Accessors(fluent = true)
                                               // la clase CreateProductoCommand
                .nombre(comando.nombre())
                .createdAt(LocalDateTime.now()).build();

        categoriaRepository.save(categoria);
        return categoria;

    }
}
