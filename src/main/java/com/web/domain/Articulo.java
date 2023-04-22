package com.web.domain;
import jakarta.persistence.*;

import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long idArticulo;
    private String tipo;
    private Long imagen;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria categoria;

    public Articulo(){}

    public Articulo(String tipo,Long imagen,String descripcion,String detalle,double precio, int existencias, Categoria categoria ){
        this.tipo=tipo;
        this.imagen=imagen;
        this.descripcion=descripcion;
        this.detalle=detalle;
        this.precio=precio;
        this.existencias=existencias;
        this.categoria=categoria;
    }

}
