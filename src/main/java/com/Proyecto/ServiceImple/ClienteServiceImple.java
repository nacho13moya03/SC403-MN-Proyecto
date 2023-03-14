
package com.Proyecto.ServiceImple;

import com.Proyecto.Domain.Cliente;
import com.Proyecto.Domain.Descuento;
import com.Proyecto.Service.ClienteService;
import com.Proyecto_Dao.ClienteDao;
import com.Proyecto_Dao.DescuentoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImple implements ClienteService {
        
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private DescuentoDao creditoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        Descuento descuento = cliente.getDescuento();
        descuento = creditoDao.save(descuento);
        cliente.setDescuento(descuento);
        clienteDao.save(cliente);
    }
}
