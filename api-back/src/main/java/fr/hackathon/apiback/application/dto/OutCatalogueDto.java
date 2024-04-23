package fr.hackathon.apiback.application.dto;

import fr.hackathon.apiback.domain.ports.Produit;
import fr.hackathon.apiback.infrastructure.entity.ProduitEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OutCatalogueDto {
    private Long id;
    private String nom;
    private List<ProduitEntity> produits = new ArrayList<>();
}
