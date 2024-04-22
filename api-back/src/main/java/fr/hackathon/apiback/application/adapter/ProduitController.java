package fr.hackathon.apiback.application.adapter;

import fr.hackathon.apiback.domain.ports.api.ProduitService;
import fr.hackathon.apiback.infrastructure.entity.Produit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
