package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.validation.categoria;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoCategoriaValidador.class)
@Documented
public @interface NombradoCategoria {

    //Definimos el mensaje por defecto
    String message() default "{es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.validation.NombradoCategoria}";

    //Permite agrupar validaciones. Es útil cuando quieres validar solo un subconjunto de reglas 
    //(por ejemplo, validar un producto para "Creación" vs. para "Actualización"). 
    //El valor por defecto es para todos los casos.
    Class<?>[] groups() default {};
    
    //Una propiedad avanzada que permite definir metadatos  o códigos de error específicos al resultado de la validación.
    Class<? extends Payload>[] payload() default {};
}
