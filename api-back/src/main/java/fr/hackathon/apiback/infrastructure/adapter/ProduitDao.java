package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.domain.ports.spi.IProduitDao;
import fr.hackathon.apiback.infrastructure.entity.Produit;
import fr.hackathon.apiback.infrastructure.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
