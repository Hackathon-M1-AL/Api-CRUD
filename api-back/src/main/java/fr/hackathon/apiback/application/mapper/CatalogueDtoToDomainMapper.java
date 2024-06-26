package fr.hackathon.apiback.application.mapper;

import fr.hackathon.apiback.application.dto.InCatalogueDto;
import fr.hackathon.apiback.application.dto.OutCatalogueDto;
import fr.hackathon.apiback.domain.ports.Catalogue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogueDtoToDomainMapper {

    Catalogue inCatalogueDtoToCatalogue(final InCatalogueDto inDto);
    OutCatalogueDto catalogueToOutCatalogeDto(final Catalogue domain);
}
