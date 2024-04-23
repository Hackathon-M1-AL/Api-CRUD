package fr.hackathon.apiback.infrastructure.adapter;

import fr.hackathon.apiback.domain.ports.Utilisateur;
import fr.hackathon.apiback.domain.ports.spi.IUtilisateurDao;
import fr.hackathon.apiback.infrastructure.entity.UtilisateurEntity;
import fr.hackathon.apiback.infrastructure.mapper.EntityToDomainUtilisateurMapper;
import fr.hackathon.apiback.infrastructure.repository.UtilisateurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UtilisateurDao implements IUtilisateurDao {

    private final EntityToDomainUtilisateurMapper mapper;

    private final UtilisateurRepository utilisateurRepository;
    public UtilisateurDao(UtilisateurRepository utilisateurRepository, final EntityToDomainUtilisateurMapper mapper){
        this.utilisateurRepository = utilisateurRepository;
        this.mapper = mapper;
    }

    @Override
    public Utilisateur addUtilisateur(final     Utilisateur domain){
        final UtilisateurEntity entityToSave = this.mapper.toEntity(domain);
        final UtilisateurEntity savedEntity = this.utilisateurRepository.save(entityToSave);
        return this.mapper.toDomain(savedEntity);
    }

    @Override
    public Utilisateur getUtilisateurById(final Long id){
        final UtilisateurEntity entityToFind = this.utilisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur not found")
        );
        return this.mapper.toDomain(entityToFind);
    }

    @Override
    public Utilisateur updateUtilisateur(final Utilisateur utilisateur){
        final Optional<UtilisateurEntity> foundUtilisateur = this.utilisateurRepository.findById(utilisateur.getId());
        if(foundUtilisateur.isEmpty()){
            throw new NoSuchElementException("Utilisateur not found with ID: " + utilisateur.getId());
        }
        final UtilisateurEntity savedEntity = this.utilisateurRepository.save(this.mapper.toEntity(utilisateur));

        return this.mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteUtilisateur(final Long id){
        final Optional<UtilisateurEntity> Utilisateur = this.utilisateurRepository.findById(id);

        if (Utilisateur.isEmpty()){
            throw new NoSuchElementException("Utilisateur not found with ID: " + id);
        }
        this.utilisateurRepository.deleteById(id);
    }
}
