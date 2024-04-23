package fr.hackathon.apiback.domain.ports.api;

import fr.hackathon.apiback.domain.ports.Produit;
import fr.hackathon.apiback.domain.ports.spi.IProduitDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements IProduitService {
    private final IProduitDao iProduitDao;

    public ProduitService(IProduitDao iProduitDao) {
        this.iProduitDao = iProduitDao;
    }

    @Override
    public List<Produit> recupererProduits() {
        return this.iProduitDao.getAll();
    }
    @Override
    public Produit getOneProduitById(final Long id) {
        return this.iProduitDao.getOneProduitById(id);
    }
    @Override
    public Produit add(Produit produit) {
        return this.iProduitDao.add(produit);
    }
    @Override
    public Produit updateProduit(Produit produit) {
        return this.iProduitDao.updateProduit(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        this.iProduitDao.deleteProduit(id);
    }

}
