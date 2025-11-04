package es.etg.daw.dawes.java.es.restfull.productos.domain.repository;
import java.util.Optional;
import es.etg.daw.dawes.java.es.restfull.common.domain.repository.CRUDRepository;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;

public interface CategoriaRepository extends CRUDRepository<Categoria, CategoriaId> {

    Optional<Categoria> getByName(String name);
    Optional<Categoria> getById(CategoriaId categoriaId);
}
