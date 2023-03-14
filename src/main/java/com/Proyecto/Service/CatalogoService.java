/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.Service;

import com.Proyecto.Domain.Catalogo;
import java.util.List;

/**
 *
 * @author Adriana Ramirez
 */
public interface CatalogoService {
     public List<Catalogo> getCatalogo(boolean activos);
    
    public void save(Catalogo catalogo);
    
    public Catalogo getCatalogo(Catalogo catalogo);
    
    public void delete(Catalogo catalogo);
}
