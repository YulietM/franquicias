package com.franquicias.repository;
import com.franquicias.model.entity.Franquicia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Transactional
public interface FranquiciaRepository extends CrudRepository<Franquicia, Long> {

    @Query("FROM Franquicia f where f.nombreFranquicia = :nombre")
    List<Franquicia> findBynombreFranquicia(@Param("nombre") String nombre);


}
