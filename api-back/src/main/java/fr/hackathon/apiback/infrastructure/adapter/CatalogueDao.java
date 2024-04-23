package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.domain.ports.Catalogue;
import fr.hackathon.apiback.domain.ports.spi.ICatalogueDao;
import fr.hackathon.apiback.infrastructure.entity.CatalogueEntity;
import fr.hackathon.apiback.infrastructure.mapper.EntityToDomainMapper;
import fr.hackathon.apiback.infrastructure.repository.CatalogueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogueDao implements ICatalogueDao {

    private final EntityToDomainMapper mapper;
    private final CatalogueRepository repository;

    public CatalogueDao(EntityToDomainMapper mapper, CatalogueRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public Catalogue add(final Catalogue catalogue) {
        final CatalogueEntity entityToSave = this.mapper.domainToEntity(catalogue);

        return this.mapper.entityToDomain(this.repository.save(entityToSave));
    }

    @Override
    public List<Catalogue> getAll() {
        List<CatalogueEntity> catalogueEntities = this.repository.findAll();
        return catalogueEntities.stream()
                .map(mapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Catalogue getCatalogueByid(final Long id) {
        final Optional<CatalogueEntity> catalogue = this.repository.findById(id);

        if (catalogue.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Catalogue not found");
        }

        return this.mapper.entityToDomain(catalogue.get());
    }

    @Override
    public void deleteCatalogue(final Long id) {
        final Optional<CatalogueEntity> catalogue = this.repository.findById(id);

        if(catalogue.isEmpty()) {
            throw new NoSuchElementException("Catalogue not found with ID: " + id);
        }

        this.repository.deleteById(id);
    }

    @Override
    public Catalogue updateCatalogue(final Catalogue catalogue) {
        final Optional<CatalogueEntity> foundCatalogue = this.repository.findById(catalogue.getId());

        if (foundCatalogue.isEmpty()) {
            throw new NoSuchElementException("Catalogue not found with ID: " + catalogue.getId());
        }

        final CatalogueEntity savedEntity = this.repository.save(this.mapper.domainToEntity(catalogue));

        return this.mapper.entityToDomain(savedEntity);
    }
}
