package es.etg.daw.dawes.java.es.restfull.productos.application.services.categoria;


import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria.FindCategoriaUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;


@RequiredArgsConstructor
@Service
public class FindCategoriaService {

     private final FindCategoriaUseCase findCategoriaUseCase;

     public List<Categoria> findAll() {
        return findCategoriaUseCase.findAll();
     }
}
