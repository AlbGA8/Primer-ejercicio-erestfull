package es.etg.daw.dawes.java.es.restfull.productos.domain.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.etg.daw.dawes.java.es.restfull.common.domain.error.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "producto";

    public ProductoNotFoundException(){
        super(ENTIDAD);
    }

    public ProductoNotFoundException(int id){
        super(ENTIDAD, id);
    }
        public ProductoNotFoundException(String mensaje) {
        super(mensaje);
    }
    
}
