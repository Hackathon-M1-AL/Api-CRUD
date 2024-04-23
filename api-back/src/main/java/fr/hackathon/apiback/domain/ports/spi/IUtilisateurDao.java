package fr.hackathon.apiback.domain.ports.spi;

import fr.hackathon.apiback.domain.ports.Utilisateur;
import fr.hackathon.apiback.infrastructure.entity.UtilisateurEntity;

public interface IUtilisateurDao {

    Utilisateur addUtilisateur(Utilisateur domain);

    Utilisateur getUtilisateurById(Long id);

    Utilisateur updateUtilisateur(Utilisateur utilisateur);

    void deleteUtilisateur(Long id);
}
