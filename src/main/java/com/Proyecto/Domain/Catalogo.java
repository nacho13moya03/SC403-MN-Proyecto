/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="catalogo")
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogo;
    private String N_catalogo;
    private boolean activo;

    public Catalogo() {
    }

    public Catalogo(String N_catalogo, boolean activo) {
        this.N_catalogo = N_catalogo;
        this.activo = activo;
    }
    
    
}

