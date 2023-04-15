package com.web.service.impl;

import com.web.dao.ConfigBDDao;
import com.web.domain.ConfigBD;
import com.web.service.ConfigBDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfigBDServiceImpl implements ConfigBDService {
    @Autowired
    private ConfigBDDao configBDDao;
    @Override
    @Transactional(readOnly=true)
    public List<ConfigBD> getArticulos() {
        return configBDDao.findAll();
    }
    @Override
    @Transactional(readOnly=true)
    public ConfigBD getArticulo(ConfigBD articulo) {
        return configBDDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void deleteArticulo(ConfigBD articulo) {
        configBDDao.delete(articulo);
    }
    @Override
    @Transactional(readOnly=false)
    public void saveArticulo(ConfigBD articulo) {
        configBDDao.save(articulo);
    }

    @Override
    @Transactional(readOnly=true)
    public List<ConfigBD> getArticulosMetodoQuery(double precioInf, double precioSup) {
        return configBDDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly=true)
    public List<ConfigBD> getArticulosMetodoJPQA(double precioInf, double precioSup) {
        return configBDDao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly=true)
    public List<ConfigBD> getArticulosMetodoNativo(double precioInf, double precioSup) {
        return configBDDao.metodoNativo(precioInf, precioSup);
    }
}
