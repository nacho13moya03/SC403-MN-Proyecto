package com.web.service.impl;


import com.web.dao.ArticuloDao;
import com.web.domain.Articulo;
import com.web.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ArticuloServiceImpl implements ArticuloService {
   /* @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulosC() {
        return articuloDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo getArticuloC(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }*/
}
