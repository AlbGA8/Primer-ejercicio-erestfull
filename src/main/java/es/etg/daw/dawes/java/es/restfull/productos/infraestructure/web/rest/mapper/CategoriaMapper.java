package es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.mapper;

import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.es.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.CategoriaRequest;
import es.etg.daw.dawes.java.es.restfull.productos.infraestructure.web.rest.dto.CategoriaResponse;


public class CategoriaMapper {

    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest){
		return new CreateCategoriaCommand(categoriaRequest.nombre());
	}

	public static EditCategoriaCommand toCommand(int id , CategoriaRequest categoriaRequest){
        //pasamos del int a CategoriaId
        return new EditCategoriaCommand(new CategoriaId(id), categoriaRequest.nombre());
    }


	    public static CategoriaResponse toResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getNombre(),
                                    categoria.getCreatedAt());
                              
                                }

}
