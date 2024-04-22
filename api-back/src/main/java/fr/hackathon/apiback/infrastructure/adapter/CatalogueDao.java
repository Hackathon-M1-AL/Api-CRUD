package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;
import fr.hackathon.apiback.domain.ports.spi.ICatalogueDao;
import fr.hackathon.apiback.infrastructure.repository.CatalogueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueDao implements ICatalogueDao {

    private final CatalogueRepository repository;

    public CatalogueDao(CatalogueRepository repository) {
        this.repository = repository;
    }


    @Override
    public Catalogue add(final Catalogue catalogue) {

        return this.repository.save(catalogue);
    }

    @Override
    public List<Catalogue> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Catalogue getCatalogueByid(final Long id) {
        final Optional<Catalogue> catalogue = this.repository.findById(id);

        if (catalogue.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Catalogue not found");
        }

        return catalogue.get();
    }
}
