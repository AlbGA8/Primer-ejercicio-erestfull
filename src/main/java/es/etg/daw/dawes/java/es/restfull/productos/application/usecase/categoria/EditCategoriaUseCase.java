package es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.error.ProductoNotFoundException;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class EditCategoriaUseCase {
    private final CategoriaRepository categoriaRepository;

     public Categoria update(EditCategoriaCommand command){
        return categoriaRepository.getById(command.id())
                .map(p -> { //Actualizamos los atributos del objeto
                    p.setNombre(command.nombre());
                    return categoriaRepository.save(p);})
                .orElseThrow(() -> new ProductoNotFoundException(command.id().getValue())); //Lo cambiamos

    }


}
