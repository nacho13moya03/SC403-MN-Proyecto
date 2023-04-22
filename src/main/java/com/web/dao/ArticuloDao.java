package com.web.dao;

import com.web.domain.Articulo;
import com.web.domain.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ArticuloDao extends JpaRepository<Articulo, Long> {
    //Articulo findByCategoria(Long categoria);
    List<Articulo> findByCategoria(Long categoria);
}
