package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.mapper;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.ProductoRequest;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.ProductoResponse;

public class ProductoMapper {

    public static CreateProductoCommand toCommand(ProductoRequest productoRequest){
		return new CreateProductoCommand(productoRequest.nombre(), productoRequest.precio());
	}

	public static ProductoResponse toResponse(Producto producto){
		return new ProductoResponse(producto.getId(),
									producto.getNombre(),
									producto.getPrecio(),
									producto.getCreatedAt());
	}
	

}
