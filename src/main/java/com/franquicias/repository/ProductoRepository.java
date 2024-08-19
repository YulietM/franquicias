package com.franquicias.repository;
import com.franquicias.model.entity.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Transactional
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("FROM Producto p WHERE p.nombre = :nombre")
    List<Producto> findByNombre(@Param("nombre") String nombre);
}
