package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.entity.categoria.CategoriaEntity;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.db.jpa.entity.producto.ProductoEntity;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.CategoriaRequest;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.CategoriaResponse;

public class CategoriaMapper {

  public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest) {
    return new CreateCategoriaCommand(categoriaRequest.nombre());
  }

  public static EditCategoriaCommand toCommand(int id, CategoriaRequest categoriaRequest) {
    // pasamos del int a CategoriaId
    return new EditCategoriaCommand(new CategoriaId(id), categoriaRequest.nombre());
  }

  public static CategoriaResponse toResponse(Categoria categoria) {
    return new CategoriaResponse(categoria.getId().getValue(), categoria.getNombre(), categoria.getCreatedAt());

  }

  public static CategoriaEntity toEntity(Categoria c) {

    CategoriaId id = c.getId();
    return CategoriaEntity.builder().id(id != null ? id.getValue() : null)
        .nombre(c.getNombre())
        .build();

  }

  public static Categoria toDomain(CategoriaEntity c) {
    return Categoria.builder().id(new CategoriaId(c.getId()))
        .nombre(c.getNombre())             
        .build();

  }

  public static List<Categoria> toDomain(List<CategoriaEntity> lista) {
    List<Categoria> lp = new ArrayList<>();
    for (CategoriaEntity pe : lista) {
      lp.add(toDomain(pe));
    }
    return lp;
  }

}
