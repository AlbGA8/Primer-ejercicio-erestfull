package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import es.etg.daw.dawes.java.es.restfull.productos.application.services.producto.DeleteProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.producto.EditProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.services.producto.FindProductoService;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto.CreateProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto.DeleteProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.application.usecase.producto.FindProductoUseCase;
import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.repository.producto.ProductoEntityJpaRepository;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.repository.producto.ProductoJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor

public class ProductoConfig {

     private final ProductoEntityJpaRepository productoRepository;

    // Creo por configuración la instalacia que me interesa del productoRepository (desde jpa)
    @Bean
    public  ProductoRepository productoRepository(){
        return new ProductoJpaRepositoryImpl(productoRepository);
    }
    
    @Bean
    public CreateProductoUseCase createProductoUseCase() {
        return new CreateProductoUseCase(productoRepository());
    }

    @Bean
    public FindProductoUseCase findProductoUseCase() {
        return new FindProductoUseCase(productoRepository());
    }

    @Bean
    public FindProductoService findProductoService() {
        return new FindProductoService(findProductoUseCase());
    }

    @Bean
    public EditProductoService editProductoService() {
        return new EditProductoService(editProductoUseCase());
    }

    @Bean
    public EditProductoUseCase editProductoUseCase() {
        return new EditProductoUseCase(productoRepository());
    }

    @Bean
    public DeleteProductoService deleteProductoService() {
        return new DeleteProductoService(deleteProductoUseCase());
    }

    @Bean
    public DeleteProductoUseCase deleteProductoUseCase() {
        return new DeleteProductoUseCase(productoRepository());
    }

    

}
