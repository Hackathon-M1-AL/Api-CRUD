package fr.hackathon.apiback.infrastructure.mapper;

import fr.hackathon.apiback.domain.ports.Produit;
import fr.hackathon.apiback.infrastructure.entity.ProduitEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitDomainToEntityMapper {
    ProduitEntity domainToEntity(final Produit domain);
    Produit entityToDomain(final ProduitEntity entity);
}
