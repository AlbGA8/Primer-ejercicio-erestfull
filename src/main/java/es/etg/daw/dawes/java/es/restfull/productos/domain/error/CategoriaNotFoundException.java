package es.etg.daw.dawes.java.es.restfull.productos.domain.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import es.etg.daw.dawes.java.es.restfull.common.domain.error.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoriaNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "categoria";

    public CategoriaNotFoundException() {

        super(ENTIDAD);
    }

    public CategoriaNotFoundException(int id) {
        super(ENTIDAD, id);
    }
        public CategoriaNotFoundException(String mensaje) {
        super(mensaje);
    }

}
