
package com.Proyecto_Dao;

import com.Proyecto.Domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adriana Ramirez
 */
public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}
