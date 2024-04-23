package fr.hackathon.apiback.application.dto;

import fr.hackathon.apiback.domain.ports.Produit;

import java.util.ArrayList;
import java.util.List;

public class InCatalogueDto {
    private Long id;
    private String nom;
    private List<Produit> produits = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
