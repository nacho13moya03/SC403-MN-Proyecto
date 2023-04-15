package com.web.dao;

import com.web.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long>{
}
