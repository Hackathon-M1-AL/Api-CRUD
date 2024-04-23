package fr.hackathon.apiback.application.adapter;

import fr.hackathon.apiback.application.dto.InCatalogueDto;
import fr.hackathon.apiback.application.dto.OutCatalogueDto;
import fr.hackathon.apiback.application.mapper.CatalogueDtoToDomainMapper;
import fr.hackathon.apiback.domain.ports.Catalogue;
import fr.hackathon.apiback.domain.ports.api.CatalogueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {

    private final CatalogueDtoToDomainMapper mapper;
    private final CatalogueService service;
    public CatalogueController(CatalogueDtoToDomainMapper mapper, CatalogueService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping("/nouveau-catalogue")
    public ResponseEntity<OutCatalogueDto> addCatalogue(@RequestBody final InCatalogueDto inCatalogueDto){

        final Catalogue addedCatalogue = this.service.add(this.mapper.inCatalogueDtoToCatalogue(inCatalogueDto));

        if (addedCatalogue == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(this.mapper.catalogueToOutCatalogeDto(addedCatalogue),HttpStatus.CREATED);

    }

    @GetMapping("/get-all-catalogues")
    public ResponseEntity<List<OutCatalogueDto>> getAll(){

        List<Catalogue> catalogueEntities = this.service.getAll();
        final List<OutCatalogueDto> dtoList = catalogueEntities.stream()
                .map(mapper::catalogueToOutCatalogeDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/get-catalogue-by-id")
    public ResponseEntity<OutCatalogueDto> getById(@RequestParam final Long id){
        final OutCatalogueDto outCatalogueDto = this.mapper.catalogueToOutCatalogeDto(this.service.getCatalogueByid(id));
        return new ResponseEntity<>(outCatalogueDto, HttpStatus.OK);
    }

    @PutMapping("/modifie-catalogue")
    public ResponseEntity updateCatalogue(@RequestBody final InCatalogueDto inCatalogueDto){
        final Catalogue domain = this.mapper.inCatalogueDtoToCatalogue(inCatalogueDto);

        try {
            final Catalogue updatedCatalogue = this.service.updateCatalogue(domain);
            return new ResponseEntity<>(this.mapper.catalogueToOutCatalogeDto(updatedCatalogue), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/supprimer-catalogue")
    public ResponseEntity deleteCatalogue(@RequestParam final Long id){
        try {
            this.service.deleteCatalogue(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (final Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
