package fr.hackathon.apiback.infrastructure.entity;

import fr.hackathon.apiback.domain.ports.Produit;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CatalogueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany
    private List<ProduitEntity> produits = new ArrayList<>();

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

    public List<ProduitEntity> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitEntity> produits) {
        this.produits = produits;
    }
}
