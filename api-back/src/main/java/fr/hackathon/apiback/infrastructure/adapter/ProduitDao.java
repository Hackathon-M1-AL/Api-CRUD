package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.infrastructure.mapper.DomainToEntityMapper;
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
import java.util.stream.Collectors;

@Service
public class ProduitDao implements IProduitDao {
    private final ProduitRepository produitRepository;
    private final DtoToDomainMapper dtoToDomainMapper;
    private final DomainToEntityMapper domainToEntityMapper;

    public ProduitDao(
            ProduitRepository produitRepository,
            DtoToDomainMapper dtoToDomainMapper,
            DomainToEntityMapper domainToEntityMapper
    ) {
        this.produitRepository = produitRepository;
        this.dtoToDomainMapper = dtoToDomainMapper;
        this.domainToEntityMapper = domainToEntityMapper;
    }

    @Override
    public List<Produit> getAll() {
        List<ProduitEntity> entities = this.produitRepository.findAll();
        return entities.stream()
                .map(this.domainToEntityMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Produit getOneProduitById(Long id) {
        final ProduitEntity produitEntity = this.produitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit not found"));

        return this.domainToEntityMapper.entityToDomain(produitEntity);

    }

    @Override
    public Produit add(final Produit produit) {
        final ProduitEntity entity = this.domainToEntityMapper.domainToEntity(produit);
        return this.domainToEntityMapper.entityToDomain(this.produitRepository.save(entity));
    }

    @Override
    public Produit updateProduit(Produit produit) {
        Optional<ProduitEntity> entityToupdate = this.produitRepository.findById(produit.getId());
        if (entityToupdate.isEmpty()) {
            throw new NoSuchElementException("Produit non trouvé: " + produit.getId());
        }

        final ProduitEntity savedEntity = this.produitRepository.save(this.domainToEntityMapper.domainToEntity(produit));

        return this.domainToEntityMapper.entityToDomain(savedEntity);
    }

    @Override
    public void deleteProduit(Long id) {
        Optional<ProduitEntity> entityToDelete = this.produitRepository.findById(id);
        if (entityToDelete.isEmpty()) {
            throw new NoSuchElementException("Produit non trouvé: " + id);
        }

        this.produitRepository.deleteById(id);
    }
}
