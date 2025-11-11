package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.repository.mock.categoria;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;

public class CategoriaFactory {

    public static final Map<CategoriaId, Categoria> getDemoData(){

        Map<CategoriaId, Categoria> datos = new LinkedHashMap<>();

        datos.put(new CategoriaId(1), new Categoria("Categoria 1", new CategoriaId(1), LocalDateTime.now()));
        datos.put(new CategoriaId(2), new Categoria("Categoria 2", new CategoriaId(1), LocalDateTime.now()));
        return datos;
    }
    
}