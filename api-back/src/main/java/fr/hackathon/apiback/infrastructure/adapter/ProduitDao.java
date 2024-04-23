package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.application.mapper.DtoToDomainMapper;
import fr.hackathon.apiback.domain.ports.Produit;
import fr.hackathon.apiback.domain.ports.spi.IProduitDao;
import fr.hackathon.apiback.infrastructure.entity.ProduitEntity;
import fr.hackathon.apiback.infrastructure.repository.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProduitDao implements IProduitDao {
    private final ProduitRepository produitRepository;
    private final DtoToDomainMapper mapper;

    public ProduitDao(ProduitRepository produitRepository, DtoToDomainMapper mapper) {
        this.produitRepository = produitRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Produit> getAll() {
        return this.mapper.inDtoListToDomainList(
                this.mapper.entitiesToDomainList(
                        this.produitRepository.findAll()
                )
        );
    }

    @Override
    public Produit getOneProduitById(Long id) {
        final ProduitEntity produitEntity = this.produitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit not found"));

        return this.mapper.domainToOutDto(this.mapper.entityToDomain(produitEntity));

    }

    @Override
    public Produit add(final Produit produit) {
        return this.produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        Optional<Produit> produitToUpdate = this.produitRepository.findById(produit.getId());
        if (produitToUpdate.isEmpty()) {
            throw new NoSuchElementException("Produit non trouvé: " + produit.getId());
        }

        return this.produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        Optional<Produit> produitToDelete = this.produitRepository.findById(id);
        if (produitToDelete.isEmpty()) {
            throw new NoSuchElementException("Produit non trouvé: " + id);
        }

        this.produitRepository.deleteById(id);
    }
}
