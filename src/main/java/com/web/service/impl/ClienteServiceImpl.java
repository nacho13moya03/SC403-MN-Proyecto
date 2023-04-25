package com.web.service.impl;

import com.web.dao.ClienteDao;
import com.web.domain.Cliente;
import com.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteDao clienteDao;

    // @Override
    @Transactional(readOnly = false)
    public void saveCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

   /* @Override
    public Optional<Cliente> findById(Long idCliente) {
        return clienteDao.findById(idCliente);
    }

    @Override
    public Optional<Cliente> findByCorreo(String correo) {
        return clienteDao.findByCorreo(correo);
    }*/

    @Override
    public Cliente getUserByEmail(String correo) {
        return clienteDao.findByCorreo(correo);
    }

  /*  public Optional<Cliente>  getUserById(Long idCliente) {
        return clienteDao.findById(idCliente);
    }*/


}

