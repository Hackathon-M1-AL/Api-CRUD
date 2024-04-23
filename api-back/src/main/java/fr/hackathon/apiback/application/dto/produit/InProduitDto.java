package fr.hackathon.apiback.application.dto.produit;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InProduitDto {
    private String nom;
    private String description;
    private int quantite;
    private Double prix;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
