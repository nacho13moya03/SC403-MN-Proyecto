package com.web.dao;

import com.web.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
}
