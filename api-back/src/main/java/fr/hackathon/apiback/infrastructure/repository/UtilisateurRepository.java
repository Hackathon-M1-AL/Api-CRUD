package fr.hackathon.apiback.infrastructure.repository;

import fr.hackathon.apiback.infrastructure.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {
}
