package fr.hackathon.apiback.domain.ports.spi;

import fr.hackathon.apiback.domain.ports.Catalogue;

import java.util.List;

public interface ICatalogueDao {

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

    /**
     * Supprime le catalogue
     * @param id
     */
    void deleteCatalogue(final Long id);

    /**
     * Modifie le catalogue
     * @param catalogue
     * @return Catalogue
     */
    Catalogue updateCatalogue(final Catalogue catalogue);
}
