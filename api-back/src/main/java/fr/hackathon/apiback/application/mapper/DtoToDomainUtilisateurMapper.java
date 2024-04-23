package fr.hackathon.apiback.application.mapper;

import fr.hackathon.apiback.application.dto.InUtilisateurDto;
import fr.hackathon.apiback.application.dto.OutUtilisateurDto;
import fr.hackathon.apiback.domain.ports.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoToDomainUtilisateurMapper {
    OutUtilisateurDto toOutUtilisateurDto(final Utilisateur domain);
    InUtilisateurDto toInUtilisateurDto(final Utilisateur domain);
    Utilisateur toDomain(final InUtilisateurDto inDto);
}
