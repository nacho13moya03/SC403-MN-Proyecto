package com.web.service;

import com.web.domain.Catalogue;
import java.util.List;

public interface CatalogueService{

    //Se recupera una lista con todos los registros de la tabla articulo
    public List<Catalogue> getArticulos(boolean activos);

    //Se recupera el registro que tiene el idArticulo pasado por parámetro
    //si no existe en la tabla se retorna null
    public Catalogue getArticulo(Catalogue catalogue);

    //Se elimina el registro que tiene el idArticulo pasado por parámetro
    public void deleteArticulo(Catalogue catalogue);

    //Si el objeto articulo tiene un idArticulo que existe en la tabla articulo
    //El registro de actualiza con la nueva información
    //Si el idArticulo NO existe en la tabla, se crea el registro con esa información
    public void saveArticulo(Catalogue catalogue);

    //Se hace uso de un método Query para recuperar la información de un conjunto de artículos entre unas fechas
    //ordenados por descripcion
    public List<Catalogue> getArticulosMetodoQuery(double precioInf, double precioSup);

    //Se hace uso de un método @JPQL para recuperar la información de un conjunto de artículos entre unas fechas
    //ordenados por descripcion
    public List<Catalogue> getArticulosMetodoJPQA(double precioInf, double precioSup);

    //Se hace uso de un método Nativo para recuperar la información de un conjunto de artículos entre unas fechas
    //ordenados por descripcion
    public List<Catalogue> getArticulosMetodoNativo(double precioInf, double precioSup);

}
