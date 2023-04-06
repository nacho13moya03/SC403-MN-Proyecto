package com.web.service.impl;

import com.web.dao.CatalogueDao;
import com.web.domain.Catalogue;
import com.web.service.CatalogueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogueServiceImpl implements CatalogueService {
    @Autowired
    private CatalogueDao catalogueDao;
    @Override
    @Transactional(readOnly=true)
    public List<Catalogue> getArticulos(boolean activos) {
        var lista = (List<Catalogue>) catalogueDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

    }
    @Override
    @Transactional(readOnly=true)
    public Catalogue getArticulo(Catalogue articulo) {
        return catalogueDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void deleteArticulo(Catalogue articulo) {
        catalogueDao.delete(articulo);
    }
    @Override
    @Transactional(readOnly=false)
    public void saveArticulo(Catalogue articulo) {
        catalogueDao.save(articulo);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Catalogue> getArticulosMetodoQuery(double precioInf, double precioSup) {
        return catalogueDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Catalogue> getArticulosMetodoJPQA(double precioInf, double precioSup) {
        return catalogueDao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Catalogue> getArticulosMetodoNativo(double precioInf, double precioSup) {
        return catalogueDao.metodoNativo(precioInf, precioSup);
    }
}
