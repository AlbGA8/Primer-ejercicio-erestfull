package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.entity.categoria.CategoriaEntity;

@Repository
public interface CategoriaEntityJpaRepository extends JpaRepository<CategoriaEntity, Integer> {
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(),
    // etc.

    public CategoriaEntity findByNombre(String nombre);
}
