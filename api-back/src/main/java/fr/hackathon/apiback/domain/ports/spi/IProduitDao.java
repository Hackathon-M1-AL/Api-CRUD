package fr.hackathon.apiback.domain.ports.spi;

import fr.hackathon.apiback.domain.ports.Produit;

import java.util.List;

public interface IProduitDao {
    public List<Produit> getAll();
    public Produit getOneProduitById(Long id);
    public Produit add(final Produit produit);
    public Produit updateProduit(final Produit produit);
    public void deleteProduit(Long id);
}
