package ca.badalsarkar.amazingshop.assemblers;

import ca.badalsarkar.amazingshop.models.product.Department;
import ca.badalsarkar.amazingshop.restcontrollers.DepartmentController;
import ca.badalsarkar.amazingshop.restcontrollers.ProductController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class DepartmentAssembler implements RepresentationModelAssembler<Department, EntityModel<Department>> {

    @Override
    public EntityModel<Department> toModel(Department department) {
       return EntityModel.of(department,
                linkTo(methodOn(DepartmentController.class).departmentById(department.getId())).withSelfRel(),
                linkTo(methodOn(DepartmentController.class).all()).withRel("all"),
                linkTo(methodOn(ProductController.class).productByDepartment(department.getId(), null)).withRel("products"));
    }
}
