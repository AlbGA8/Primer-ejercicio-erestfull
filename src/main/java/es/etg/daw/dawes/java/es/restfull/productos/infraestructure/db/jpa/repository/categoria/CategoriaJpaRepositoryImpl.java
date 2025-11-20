package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.repository.categoria;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.CategoriaRepository;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.entity.categoria.CategoriaEntity;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaJpaRepositoryImpl implements CategoriaRepository {

    private final CategoriaEntityJpaRepository repository;

    @Override
    public Categoria save(Categoria t) {

        CategoriaEntity prod = CategoriaMapper.toEntity(t);
        return CategoriaMapper.toDomain(repository.save(prod));
    }

    @Override
    public List<Categoria> getAll() {
        return CategoriaMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Categoria> getById(CategoriaId id) {
        Optional<Categoria> Categoria = null;
        Optional<CategoriaEntity> pe = repository.findById(id.getValue());

        if (pe.isEmpty()) {
            Categoria = Optional.empty();
        } else {
            Categoria = Optional.of(CategoriaMapper.toDomain(pe.get()));
        }

        return Categoria;
    }

    @Override
    public void deteteById(CategoriaId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Categoria> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(),
    // etc.

}