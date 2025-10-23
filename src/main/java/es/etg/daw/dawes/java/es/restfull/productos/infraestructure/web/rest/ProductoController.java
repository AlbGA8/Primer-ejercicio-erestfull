package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.CreateProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.DeleteProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.EditProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.FindProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.ProductoRequest;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.ProductoResponse;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.mapper.ProductoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos") 
@RequiredArgsConstructor



public class ProductoController {
    
	private final FindProductoService findProductoService;
	private final CreateProductoService createProductoService;
	private final DeleteProductoService deleteProductoService;
	private final EditProductoService editProductoService;
	@PostMapping //Método Post
	public ResponseEntity<ProductoResponse> createProducto(@Valid @RequestBody ProductoRequest productoRequest) {
		CreateProductoCommand comando = ProductoMapper.toCommand(productoRequest); 
		Producto producto = createProductoService.createProducto(comando);
		return ResponseEntity.status(HttpStatus.CREATED).body(ProductoMapper.toResponse(producto)); //Respuestagit@github.com:julparper/dawes-springboot-restful.git
	}

	
	 // Este método se ejecuta para la versión 1
      //Recogemos la versión el properties
    @Value("${api.version}")
    private String apiVersion;

    @GetMapping 
    public List<ProductoResponse> allProductos(){
        if("1.0".equals(apiVersion)){
            return findProductoService.findAll()
                    .stream() //Convierte la lista en un flujo
                    .map(ProductoMapper::toResponse) //Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto de Respuesta (ProductoResponse)
                    .toList(); //Lo devuelve como una lista.
        }else{
            // Lanzamos una excepción con el error
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Versión del API incorrecta");
        }
    }

	 @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteProducto(@PathVariable int id) {
        deleteProductoService.delete(id);
        return ResponseEntity.noContent().build(); //Devpñvemos una respuesta vacía.
    }

	 @PutMapping("/{id}")
    public ProductoResponse editProducto(@PathVariable int id, @RequestBody ProductoRequest productoRequest){
        EditProductoCommand comando = ProductoMapper.toCommand(id, productoRequest);
        Producto producto = editProductoService.update(comando);
        return  ProductoMapper.toResponse(producto); //Respuesta
    }

	 @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    

    
	
}
