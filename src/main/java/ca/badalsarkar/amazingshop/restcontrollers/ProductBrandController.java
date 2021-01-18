package ca.badalsarkar.amazingshop.restcontrollers;

import ca.badalsarkar.amazingshop.assemblers.ProductBrandAssembler;
import ca.badalsarkar.amazingshop.exceptions.ProductBrandNotFoundException;
import ca.badalsarkar.amazingshop.models.ProductBrand;
import ca.badalsarkar.amazingshop.repositories.ProductBrandRepository;
import org.hibernate.EntityMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProductBrandController {

    private final ProductBrandRepository brandRepository;
    private final ProductBrandAssembler brandAssembler;
    private final Logger logger;

    public ProductBrandController(ProductBrandRepository brandRepository, ProductBrandAssembler brandAssembler) {
        this.brandRepository = brandRepository;
        this.brandAssembler=brandAssembler;
        this.logger= LoggerFactory.getLogger(ProductBrandController.class);
    }

    @GetMapping("/brands")
    public ResponseEntity all(){
        List<EntityModel<ProductBrand>> brands=brandRepository.findAll().stream().map(brandAssembler::toModel).collect(Collectors.toList());
        return ResponseEntity.ok().body(CollectionModel.of(brands,linkTo(methodOn(ProductBrandController.class).all()).withSelfRel()));
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity one(@PathVariable Long id){
        logger.info("Received get request for brand id :"+id);
        ProductBrand brand= brandRepository.findById(id).orElseThrow(()-> new ProductBrandNotFoundException(id));
        return ResponseEntity.ok().body(brandAssembler.toModel(brand));
    }

    @PostMapping("/brands")
    public ResponseEntity newBrand(@RequestBody ProductBrand newBrand){
        logger.info("Received post request for brand "+ newBrand);
        try{
            EntityModel<ProductBrand> brand = brandAssembler.toModel(brandRepository.save(newBrand));
            return ResponseEntity.created(brand.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(brand);
        }
        catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            throw ex;
        }
    }
}
