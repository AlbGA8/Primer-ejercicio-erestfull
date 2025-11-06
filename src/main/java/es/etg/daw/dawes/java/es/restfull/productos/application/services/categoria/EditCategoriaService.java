package es.etg.daw.dawes.java.es.restfull.productos.application.services.categoria;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class EditCategoriaService {

    private final EditCategoriaUseCase EditCategoriaUsecase;

    public Categoria update(EditCategoriaCommand command){
        Categoria categoria = EditCategoriaUsecase.update(command);
        return categoria;
    }


}
