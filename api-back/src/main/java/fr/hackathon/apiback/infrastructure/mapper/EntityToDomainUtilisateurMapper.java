package fr.hackathon.apiback.infrastructure.mapper;

import fr.hackathon.apiback.application.dto.InUtilisateurDto;
import fr.hackathon.apiback.domain.ports.Utilisateur;
import fr.hackathon.apiback.infrastructure.entity.UtilisateurEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityToDomainUtilisateurMapper {
    Utilisateur toDomain(UtilisateurEntity entity);
    UtilisateurEntity toEntity(Utilisateur domain);
}
