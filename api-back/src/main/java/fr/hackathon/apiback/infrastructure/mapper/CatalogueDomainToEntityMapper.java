package fr.hackathon.apiback.infrastructure.mapper;

import fr.hackathon.apiback.domain.ports.Catalogue;
import fr.hackathon.apiback.infrastructure.entity.CatalogueEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogueDomainToEntityMapper {

    Catalogue entityToDomain(final CatalogueEntity inDto);
    CatalogueEntity domainToEntity(final Catalogue domain);
}
