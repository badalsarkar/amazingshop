package ca.badalsarkar.amazingshop.restcontrollers;

import ca.badalsarkar.amazingshop.assemblers.ProductAssembler;
import ca.badalsarkar.amazingshop.exceptions.ProductNotFoundException;
import ca.badalsarkar.amazingshop.models.product.Product;
import ca.badalsarkar.amazingshop.repositories.ProductRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductRepository repository;
    private final ProductAssembler assembler;

    public ProductController(ProductRepository repository, ProductAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping("/products")
    public ResponseEntity newProduct(@RequestBody Product newProduct){
        EntityModel<Product> product = assembler.toModel(repository.save(newProduct));
        return ResponseEntity.created(product.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(product);
    }

    @GetMapping("/products")
    public ResponseEntity all(){
        List<EntityModel<Product>> products = repository.findAll()
                .stream().map(assembler::toModel).collect(Collectors.toList());
        return ResponseEntity.ok()
                .body(CollectionModel.of(products, linkTo(methodOn(ProductController.class).all()).withSelfRel()));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity one(@PathVariable Long id){
        Product product= repository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));
        return ResponseEntity.ok().body(assembler.toModel(product));
    }

    @GetMapping(value = "/products", params = "brandId")
    public ResponseEntity productByBrand(@RequestParam Long brandId){
        List<EntityModel<Product>> products = repository.findByBrand_Id(brandId).stream()
                .map(assembler::toModel).collect(Collectors.toList());
        return ResponseEntity.ok().body(CollectionModel.of(products, linkTo(methodOn(ProductController.class)
                .productByBrand(brandId)).withSelfRel()));
    }

    @GetMapping(value = "/products", params = "categoryId")
    public ResponseEntity productByCategory(@RequestParam Long categoryId){
        List<EntityModel<Product>> products=repository.findByCategory_Id(categoryId)
                .stream().map(assembler::toModel).collect(Collectors.toList());
        return ResponseEntity.ok()
                .body(CollectionModel.of(products, linkTo(methodOn(ProductController.class)
                .productByCategory(categoryId))
                .withSelfRel()));
    }

}