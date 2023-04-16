package com.web.service;

import com.web.domain.Cliente;

import java.util.Optional;

public interface ClienteService {
    public void saveCliente(Cliente cliente);

    Optional<Cliente> findById(Long idCliente);
    Optional<Cliente> findByCorreo(String correo);
}
