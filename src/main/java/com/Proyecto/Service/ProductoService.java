/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.Service;

import com.Proyecto.Domain.Producto;
import java.util.List;

/**
 *
 * @author Adriana Ramirez
 */
public interface ProductoService {
    public List<Producto> getProducto(boolean activos);
    
    public void save(Producto producto);
    
    public void delete(Producto producto);
    
    public Producto getProducto(Producto producto);
}
