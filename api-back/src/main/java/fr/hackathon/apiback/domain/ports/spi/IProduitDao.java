package fr.hackathon.apiback.domain.ports.spi;

import fr.hackathon.apiback.infrastructure.entity.Produit;

import java.util.List;

public interface IProduitDao {
    public List<Produit> getAll();

    public Produit getOneProduitById(Long id);
}
