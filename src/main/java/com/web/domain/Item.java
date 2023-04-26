package com.web.domain;
import lombok.Data;

@Data
public class Item extends Articulo{
    private int cantidad; //Almacenar la cantidad de items de un articulo

    public Item() {
    }

    public Item(Articulo articulo) {
        super.setIdArticulo(articulo.getIdArticulo());
        super.setCategoria(articulo.getCategoria());
        super.setTipo(articulo.getTipo());
        super.setImagen(articulo.getImagen());
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        this.cantidad = 0;
    }
}
