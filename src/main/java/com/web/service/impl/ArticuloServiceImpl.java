package com.web.service.impl;


import com.web.dao.ArticuloDao;
import com.web.domain.Articulo;
import com.web.domain.Cliente;
import com.web.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ArticuloServiceImpl implements ArticuloService {
   @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulosCatalogos() {
        return articuloDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo getArticuloCatalogo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

   /* @Override
    public Articulo getArticuloByCategoria(Long categoria) {
        return articuloDao.findByCategoria(categoria);
    }*/

    /*@Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulosMujer() {
        var lista = (List<Articulo>) articuloDao.findAll();
        if (lista.) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

    }*/
}
