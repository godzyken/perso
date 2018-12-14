package com.mexpedition.microserviceexpedition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expedition {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private int idCommande;

    private int etat;

    public Expedition(){
        super();

    }

    public Expedition (int id, int idCommande, int etat){

        super();
        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Expedition{" +
                "id=" + id +
                ", idCommande=" + idCommande +
                ", etat=" + etat +
                '}';
    }
}
