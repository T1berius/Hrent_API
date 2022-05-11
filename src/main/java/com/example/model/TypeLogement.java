package com.example.model;

import javax.persistence.*;

@Entity
@Table
public class TypeLogement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String libelle;

    public TypeLogement() {
    }

    public TypeLogement(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
}
