package fr.hackathon.apiback.application.adapter;

import fr.hackathon.apiback.infrastructure.entity.Catalogue;
import fr.hackathon.apiback.domain.ports.api.CatalogueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/catalogue")
public class CatalogueController {

    private final CatalogueService service;

    public CatalogueController(CatalogueService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity addCatalogue(@RequestBody final Catalogue catalogue){
        final Catalogue AddedCatalogue = this.service.add(catalogue);
        if (AddedCatalogue == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return new ResponseEntity(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam final Long id){
        return new ResponseEntity(this.service.getCatalogueByid(id), HttpStatus.OK);
    }
}
