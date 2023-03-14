/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
   private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private Long idCatalogo;
    private String N_Producto;
    private String descripcion;
    private double precio;
    private int existencias;
    private boolean activo;
    
    public Producto(){};

    public Producto(Long idCatalogo,  String N_Producto, String descripcion, double precio, int existencias, boolean activo) {
        this.idCatalogo = idCatalogo;
        this.N_Producto = N_Producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
}
