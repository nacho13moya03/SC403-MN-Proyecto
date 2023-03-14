/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.Service;

import com.Proyecto.Domain.Cliente;
import java.util.List;

/**
 *
 * @author Adriana Ramirez
 */
public interface ClienteService {
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);
    
    public void saveCliente(Cliente cliente);
}
