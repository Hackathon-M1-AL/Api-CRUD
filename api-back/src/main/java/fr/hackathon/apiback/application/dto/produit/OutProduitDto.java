package fr.hackathon.apiback.application.dto.produit;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;

import java.util.ArrayList;
import java.util.List;

public class OutProduitDto {
    private Long id;
    private String nom;
    private String description;
    private int quantite;
    private Double Prix;
    private List<Catalogue> catalogues = new ArrayList<>();
}
