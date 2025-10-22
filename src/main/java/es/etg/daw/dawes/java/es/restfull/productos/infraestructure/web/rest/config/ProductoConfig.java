package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.es.restfull.productos.application.services.CreateProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.DeleteProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.EditProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.FindProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.DeleteProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.EditProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.FindProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.repository.mock.ProductoRepositoryMockImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor

public class ProductoConfig {

    private final ProductoRepository productoRepository;

     @Bean
    public CreateProductoUseCase createProductoUseCase() {
		//Añadimos en la llamada una instancia de nuestro MOCK.
        return new CreateProductoUseCase(productoRepository);
    }
    @Bean
    public CreateProductoService createProductoService(){
        return new CreateProductoService(createProductoUseCase());
    }

     @Bean
    public FindProductoUseCase findProductoUseCase(){
        return new FindProductoUseCase(productoRepository);
    }

    @Bean
    public FindProductoService findProductoService(){
        return new FindProductoService(findProductoUseCase());
    }

    @Bean
    public EditProductoService editProductoService(){
            return new EditProductoService(editProductoUseCase());
    }
    @Bean
    public EditProductoUseCase editProductoUseCase(){
            return new EditProductoUseCase(productoRepository);
    }

     @Bean
    public DeleteProductoService deleteProductoService(){
            return new DeleteProductoService(deleteProductoUseCase());
    }
    @Bean
    public DeleteProductoUseCase deleteProductoUseCase(){
            return new DeleteProductoUseCase(productoRepository);
    }



    

}
