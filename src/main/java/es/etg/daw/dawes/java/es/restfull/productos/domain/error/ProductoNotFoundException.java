package es.etg.daw.dawes.java.es.restfull.productos.domain.error;

import es.etg.daw.dawes.java.es.restfull.common.domain.error.EntityNotFoundException;

public class ProductoNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "producto";

    public ProductoNotFoundException(){
        super(ENTIDAD);
    }

    public ProductoNotFoundException(int id){
        super(ENTIDAD, id);
    }
    
}
