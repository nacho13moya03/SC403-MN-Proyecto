package com.web.service;

import com.web.domain.Articulo;
import com.web.domain.Cliente;

import java.util.List;

public interface ArticuloService {
    //Se recupera una lista con todos los registros de la tabla articulo
    public List<Articulo> getArticulosCatalogos();

    //Se recupera el registro que tiene el idArticulo pasado por parámetro
    public Articulo getArticuloCatalogo(Articulo articulo);

    // Articulo getArticuloByCategoria(Long categoria);

}

