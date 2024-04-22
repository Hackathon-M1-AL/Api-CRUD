package fr.hackathon.apiback.infrastructure.repository;

import fr.hackathon.apiback.infrastructure.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
