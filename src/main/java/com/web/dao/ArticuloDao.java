package com.web.dao;

import com.web.domain.Articulo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArticuloDao extends JpaRepository<Articulo, Long> {
}
