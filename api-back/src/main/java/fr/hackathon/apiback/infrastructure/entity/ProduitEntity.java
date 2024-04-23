package fr.hackathon.apiback.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class ProduitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "prix")
    private Double Prix;
    @ManyToMany
    private List<Catalogue> catalogues = new ArrayList<>();
}
