package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.domain.ports.spi.IProduitDao;
import fr.hackathon.apiback.infrastructure.entity.Produit;
import fr.hackathon.apiback.infrastructure.repository.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProduitDao implements IProduitDao {
    private final ProduitRepository produitRepository;

    public ProduitDao(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<Produit> getAll() {
        return this.produitRepository.findAll();
    }

    @Override
    public Produit getOneProduitById(Long id) {
        final Optional<Produit> produit = this.produitRepository.findById(id);

        if (produit.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Catalogue not found");
        }

        return produit.get();
    }

    @Override
    public Produit add(final Produit produit) {
        return this.produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        Optional<Produit> produitToUpdate = this.produitRepository.findById(produit.getId());
        if(produitToUpdate.isEmpty()) {
            throw new NoSuchElementException("Produit non trouvé: " + produit.getId());
        }

        return this.produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        Optional<Produit> produitToDelete = this.produitRepository.findById(id);
        if(produitToDelete.isEmpty()) {
            throw new NoSuchElementException("Produit non trouvé: " + id);
        }

        this.produitRepository.deleteById(id);
    }
}
