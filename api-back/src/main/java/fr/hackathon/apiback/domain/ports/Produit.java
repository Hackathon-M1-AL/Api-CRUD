package fr.hackathon.apiback.domain.ports;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Produit {
    private Long id;
    private String nom;
    private String description;
    private int quantite;
    private Double prix;
    private List<Catalogue> catalogues = new ArrayList<>();
}
