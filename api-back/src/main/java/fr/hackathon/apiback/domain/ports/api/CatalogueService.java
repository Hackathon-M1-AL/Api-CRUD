package fr.hackathon.apiback.domain.ports.api;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;
import fr.hackathon.apiback.domain.ports.spi.ICatalogueDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatalogueService implements ICatalogueService{

    private final ICatalogueDao catalogueDao;

    public CatalogueService(ICatalogueDao catalogueDao) {
        this.catalogueDao = catalogueDao;
    }

    @Override
    public Catalogue add(Catalogue catalogue) {
        return catalogueDao.add(catalogue);
    }

    @Override
    public List<Catalogue> getAll() {
        return catalogueDao.getAll();
    }

    @Override
    public Catalogue getCatalogueByid(final Long id) {
        return catalogueDao.getCatalogueByid(id);
    }
}
