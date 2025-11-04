package es.etg.daw.dawes.java.es.restfull.productos.application.usecase.categoria;

import lombok.AllArgsConstructor;

@AllArgsConstructor

    private CategoriaRepository categoriaRepository;

public Categoria create(CreateCategoriaCommand comando) {

        Categoria categoria = Categoria.builder() 
                .nombre(comando.nombre())
                .createdAt(LocalDateTime.now()).build();

        categoriaRepository.save(categoria);
        return categoria;

}
