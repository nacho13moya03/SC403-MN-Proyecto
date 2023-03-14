/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.Service;

import com.Proyecto.Domain.Descuento;
import java.util.List;

/**
 *
 * @author Adriana Ramirez
 */
public interface DescuentoService {
    public List<Descuento> getDescuento(boolean Descuento);
    
    public void save(Descuento descuento);
    
    public void delete(Descuento descuento);
    
    public Descuento getDescuento(Descuento descuento);
}
