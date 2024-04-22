package fr.hackathon.apiback.application.dto;

import fr.hackathon.apiback.infrastructure.entity.Produit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OutCatalogueDto {
    private Long id;
    private String nom;
    private List<Produit> produits = new ArrayList<>();
}
