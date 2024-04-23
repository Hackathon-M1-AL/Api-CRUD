package fr.hackathon.apiback.application.adapter;

import fr.hackathon.apiback.application.dto.produit.InProduitDto;
import fr.hackathon.apiback.application.dto.produit.OutProduitDto;
import fr.hackathon.apiback.application.mapper.DtoToDomainMapper;
import fr.hackathon.apiback.domain.ports.Produit;
import fr.hackathon.apiback.domain.ports.api.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController("/api/produits")
public class ProduitController {
    private final DtoToDomainMapper mapper;
    private final ProduitService produitService;
    public ProduitController(DtoToDomainMapper mapper, ProduitService produitService) {
        this.mapper = mapper;
        this.produitService = produitService;
    }
    @GetMapping("")
    public ResponseEntity<List<OutProduitDto>> recupererProduits() {
        return new ResponseEntity<>(this.mapper.domainListToOutDtoList(produitService.recupererProduits()), HttpStatus.OK);
    }

    @GetMapping("/produit")
    public ResponseEntity getOneById(@RequestParam final Long id) {
        return new ResponseEntity(this.produitService.getOneProduitById(id), HttpStatus.OK);
    }

    @PostMapping("/nouveau-produit")
    public ResponseEntity addProduit(@RequestBody final InProduitDto body) {
        final Produit domain = this.mapper.inDtoToDomain(body);
        final Produit nouveauProduit = this.produitService.add(domain);
        if(nouveauProduit == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/modifie-produit")
    public ResponseEntity editProduit(@RequestBody final Produit produit) {
        final Produit produitModifie = this.produitService.updateProduit(produit);
        if(produitModifie == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer-produit")
    public ResponseEntity deleteProduit(@RequestParam final Long id) {
        try {
            this.produitService.deleteProduit(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
