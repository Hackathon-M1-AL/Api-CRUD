package fr.hackathon.apiback.application.mapper;

import fr.hackathon.apiback.application.dto.produit.InProduitDto;
import fr.hackathon.apiback.application.dto.produit.OutProduitDto;
import fr.hackathon.apiback.domain.ports.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitDtoToDomainMapper {
    Produit inDtoToDomain(final InProduitDto inDto);
    OutProduitDto domainToOutDto(final Produit domain);
}
