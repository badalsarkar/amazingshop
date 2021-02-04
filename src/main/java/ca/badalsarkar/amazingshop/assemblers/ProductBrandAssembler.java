package ca.badalsarkar.amazingshop.assemblers;

import ca.badalsarkar.amazingshop.models.product.ProductBrand;
import ca.badalsarkar.amazingshop.restcontrollers.ProductBrandController;
import ca.badalsarkar.amazingshop.restcontrollers.ProductController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductBrandAssembler implements RepresentationModelAssembler<ProductBrand, EntityModel<ProductBrand>> {

    @Override
    public EntityModel<ProductBrand> toModel(ProductBrand brand) {
        return EntityModel.of(brand,
                linkTo(methodOn(ProductBrandController.class).one(brand.getId())).withSelfRel(),
                linkTo(methodOn(ProductBrandController.class).all()).withRel("brands"),
                linkTo((methodOn(ProductController.class).productByBrand(brand.getId()))).withRel("products"));
    }
}
