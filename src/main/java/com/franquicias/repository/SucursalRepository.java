package com.franquicias.repository;
import com.franquicias.model.entity.Sucursal;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface SucursalRepository extends CrudRepository<Sucursal, Long> {

    @Query("FROM Sucursal s where s.nombre  = :nombre")
    List<Sucursal> findByNombre(@Param("nombre") String nombre);

}
