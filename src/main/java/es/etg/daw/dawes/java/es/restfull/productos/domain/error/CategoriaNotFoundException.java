package es.etg.daw.dawes.java.es.restfull.productos.domain.error;

import es.etg.daw.dawes.java.es.restfull.common.domain.error.EntityNotFoundException;

public class CategoriaNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "categoria";

    public CategoriaNotFoundException() {

        super(ENTIDAD);
    }

    public CategoriaNotFoundException(int id){
        super(ENTIDAD, id);
    }

}
