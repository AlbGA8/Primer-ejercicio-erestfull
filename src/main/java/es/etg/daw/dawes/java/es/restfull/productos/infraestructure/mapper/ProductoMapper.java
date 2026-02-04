package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.entity.categoria.CategoriaEntity;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.entity.producto.ProductoEntity;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.dto.ProductoRequest;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.dto.ProductoResponse;

public class ProductoMapper {

    public static CreateProductoCommand toCommand(ProductoRequest productoRequest){
		return new CreateProductoCommand(productoRequest.nombre(), productoRequest.precio(), new CategoriaId(productoRequest.categoria()));
	}

	public static EditProductoCommand toCommand(int id, ProductoRequest productoRequest){
        //pasamos del int a ProductoId
        return new EditProductoCommand(new ProductoId(id), productoRequest.nombre(), productoRequest.precio());
    }


	    public static ProductoResponse toResponse(Producto producto){
        return new ProductoResponse(producto.getId().getValue(), //lo pasamos a int
                                    producto.getNombre(),
                                    producto.getPrecio(),
                                    producto.getCreatedAt(),
                                    producto.getCategoria().getValue());//Agregamos la categoria.
    }

    public static ProductoEntity toEntity(Producto p){

        // Defino la categoría
        CategoriaEntity cat = new CategoriaEntity();
        cat.setId(p.getCategoria().getValue());
        ProductoId id = p.getId();
        return ProductoEntity.builder().id(id!=null?id.getValue():null)
                                       .nombre(p.getNombre())
                                       .precio(new BigDecimal(p.getPrecio()))
                                       .fechaCreacion(p.getCreatedAt())
                                       .categoria(cat)
                                       .build();

    }

    public static Producto toDomain(ProductoEntity p){
        return Producto.builder().id(new ProductoId(p.getId()))
                                 .nombre(p.getNombre())
                                 .precio(p.getPrecio().doubleValue())
                                 .createdAt(p.getFechaCreacion())
                                 .categoria(new CategoriaId(p.getCategoria().getId()))
                                 .build();

    }

    public static List<Producto> toDomain(List<ProductoEntity> lista){
        List<Producto> lp = new ArrayList<>();
        for(ProductoEntity pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }
}
