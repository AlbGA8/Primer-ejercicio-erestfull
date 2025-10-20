package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.es.restfull.productos.application.services.CreateProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.EditProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.FindProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.EditProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.FindProductoUseCase;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor

public class ProductoConfig {

    @Bean
    public CreateProductoUseCase createProductoUseCase() {
        return new CreateProductoUseCase();
    }
    @Bean
    public CreateProductoService createProductoService(){
        return new CreateProductoService(createProductoUseCase());
    }

     @Bean
    public FindProductoUseCase findProductoUseCase(){
        return new FindProductoUseCase();
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
            return new EditProductoUseCase(editProductoUseCase());
    }

}
