package fr.hackathon.apiback.domain.ports.api;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;

import java.util.List;

public interface ICatalogueService {

    /**
     * Ajout d'un catalogue
     * @param catalogue
     * @return catalogue
     */
    Catalogue add(final Catalogue catalogue);

    /**
     * Récupere touts les catalogues présents en base
     * @return
     */
    List<Catalogue> getAll();

    /**
     *
     * Récupère le catalogue par rapport a son nom
     * @param id
     * @return
     */
    Catalogue getCatalogueByid(final Long id);
}
