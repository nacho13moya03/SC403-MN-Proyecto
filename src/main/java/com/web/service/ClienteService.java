package com.web.service;

import com.web.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<Cliente> getClientes();
    public Cliente getCliente(Cliente cliente);
    public void saveCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente);
    Cliente getUserByEmail(String correo);

    //Cliente getUserById(Long idCliente);

    //Optional<Cliente> findById(Long idCliente);
   /* Optional<Cliente> findByCorreo(String correo);*/
    
}
