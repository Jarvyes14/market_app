package com.tecdesoftware.market.persistance.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

}
