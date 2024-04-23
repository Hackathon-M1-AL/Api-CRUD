package fr.hackathon.apiback.domain.ports.api;


import fr.hackathon.apiback.domain.ports.Utilisateur;

public interface IUtilisateurService {

    Utilisateur addUtilisateur(Utilisateur utilisateur);

    Utilisateur getUtilisateurById(Long id);

    Utilisateur updateUtilisateur(Utilisateur utilisateur);

    void deleteUtilisateur(Long id);
}
