package fr.hackathon.apiback.infrastructure.mapper;

import fr.hackathon.apiback.application.dto.InCatalogueDto;
import fr.hackathon.apiback.application.dto.OutCatalogueDto;
import fr.hackathon.apiback.domain.ports.Catalogue;
import fr.hackathon.apiback.infrastructure.entity.CatalogueEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityToDomainMapper {

    Catalogue entityToDomain(final CatalogueEntity inDto);
    CatalogueEntity domainToEntity(final Catalogue domain);
}
