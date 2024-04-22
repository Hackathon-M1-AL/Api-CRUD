package fr.hackathon.apiback.infrastructure.repository;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
}
