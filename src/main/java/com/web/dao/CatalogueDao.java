package com.web.dao;

import com.web.domain.Catalogue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueDao extends JpaRepository<Catalogue, Long>{

    //Ejemplo de método utilizando Métodos de Query
    public List<Catalogue> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Catalogue a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Catalogue> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de método utilizando Consultas con Native Query SQL
    @Query(nativeQuery=true,
            value="SELECT * FROM articulo where articulo.precio BETWEEN :precioInf AND :precioSup ORDER BY articulo.descripcion ASC")
    public List<Catalogue> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}