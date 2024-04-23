package fr.hackathon.apiback.domain.ports;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;

import java.util.ArrayList;
import java.util.List;

public class Produit {
    private String nom;
    private String description;
    private int quantite;
    private Double prix;
    private List<Catalogue> catalogues = new ArrayList<>();
}