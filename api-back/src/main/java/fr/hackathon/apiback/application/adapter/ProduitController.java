package fr.hackathon.apiback.application.adapter;

import fr.hackathon.apiback.domain.ports.api.ProduitService;
import fr.hackathon.apiback.infrastructure.entity.Produit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/produits")
public class ProduitController {
    private final ProduitService produitService;
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }
    @GetMapping("")
    public List<Produit> recupererProduits() {
        return produitService.recupererProduits();
    }

    @GetMapping("/")
    public ResponseEntity getOneById(@RequestParam final Long id) {
        return new ResponseEntity(this.produitService.getOneProduitById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addProduit(@RequestBody final Produit produit) {
        final Produit nouveauProduit = this.produitService.add(produit);
        if(nouveauProduit == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
