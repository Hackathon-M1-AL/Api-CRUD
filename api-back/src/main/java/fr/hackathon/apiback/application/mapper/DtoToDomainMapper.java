package fr.hackathon.apiback.application.mapper;

import fr.hackathon.apiback.application.dto.produit.InProduitDto;
import fr.hackathon.apiback.application.dto.produit.OutProduitDto;
import fr.hackathon.apiback.domain.ports.Produit;
import fr.hackathon.apiback.infrastructure.entity.ProduitEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoToDomainMapper {
    Produit inDtoToDomain(final InProduitDto inDto);
    List<Produit> inDtoListToDomainList(final List<InProduitDto> inDtoList);
    InProduitDto entityToDomain(final ProduitEntity entity);
    List<InProduitDto> entitiesToDomainList(final List<ProduitEntity> entities);
    OutProduitDto domainToOutDto(final Produit domain);
    List<OutProduitDto> domainListToOutDtoList(final List<Produit> listDomains);
}
