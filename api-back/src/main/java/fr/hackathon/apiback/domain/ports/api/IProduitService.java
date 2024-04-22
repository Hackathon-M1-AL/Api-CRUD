package fr.hackathon.apiback.domain.ports.api;

import fr.hackathon.apiback.infrastructure.entity.Produit;

import java.util.List;

public interface IProduitService {
    public List<Produit> recupererProduits();
    public Produit getOneProduitById(Long id);
}
