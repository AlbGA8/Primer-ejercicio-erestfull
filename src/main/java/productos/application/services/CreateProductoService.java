package productos.application.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import productos.application.command.CreateProductoCommand;
import productos.application.usecase.CreateProductoUseCase;
import productos.domain.model.Producto;

@RequiredArgsConstructor
@Service

public class CreateProductoService {

    private final CreateProductoUseCase createProductoUseCase;

	public Producto createProducto(CreateProductoCommand comando){
		Producto producto = createProductoUseCase.create(comando);
		return producto;
	}

}
