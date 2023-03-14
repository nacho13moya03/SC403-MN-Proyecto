/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ServiceImple;

import com.Proyecto.Domain.Catalogo;
import com.Proyecto_Dao.CatalogoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CatalogoServiceImple {
@Autowired
    private CatalogoDao catalogoDao;
 
    public List<Catalogo> getCatalogos (boolean activos){
        var lista = (List<Catalogo>) catalogoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    public void save(Catalogo catalogo) {
        catalogoDao.save(catalogo);
    }

    public void delete(Catalogo catalogo) {
        catalogoDao.delete(catalogo);
    }

   
    public Catalogo getCatalogo(Catalogo catalogo) {
        return catalogoDao.findById(catalogo.getIdCatalogo()).orElse(null);
    }

}
