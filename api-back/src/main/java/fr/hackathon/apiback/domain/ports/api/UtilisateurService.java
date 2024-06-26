package fr.hackathon.apiback.domain.ports.api;

import fr.hackathon.apiback.domain.ports.Utilisateur;
import fr.hackathon.apiback.infrastructure.adapter.UtilisateurDao;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UtilisateurService implements IUtilisateurService{

    private final UtilisateurDao utilisateurDao;

    public UtilisateurService(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur){
        return utilisateurDao.addUtilisateur(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurDao.getUtilisateurById(id);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        final Utilisateur foundUtilisateur = getUtilisateurById(utilisateur.getId());

        if(foundUtilisateur == null){
            throw new NoSuchElementException("Utilisateur not found with ID: " + utilisateur.getId());
        }

        return utilisateurDao.updateUtilisateur(utilisateur);
    }

        @Override
    public void deleteUtilisateur(Long id) {
        utilisateurDao.deleteUtilisateur(id); }
}
