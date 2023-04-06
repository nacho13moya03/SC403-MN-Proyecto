package com.web.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private boolean activo;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @OneToMany
    private List<Catalogue> articulos;

    public Categorie() {
    }

    public Categorie(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
