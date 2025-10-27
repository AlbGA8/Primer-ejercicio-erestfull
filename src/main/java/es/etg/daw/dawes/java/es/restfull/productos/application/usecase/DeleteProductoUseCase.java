package es.etg.daw.dawes.java.es.restfull.productos.application.usecase;

import es.etg.daw.dawes.java.es.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductoUseCase {

   private final ProductoRepository productoRepository;

   public void delete(int id) {

      productoRepository.deteteById(id);

   }

}
