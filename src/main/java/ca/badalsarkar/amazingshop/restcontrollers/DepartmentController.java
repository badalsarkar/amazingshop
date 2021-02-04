package ca.badalsarkar.amazingshop.restcontrollers;

import ca.badalsarkar.amazingshop.assemblers.DepartmentAssembler;
import ca.badalsarkar.amazingshop.exceptions.DepartmentNotFoundException;
import ca.badalsarkar.amazingshop.models.product.Department;
import ca.badalsarkar.amazingshop.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentAssembler departmentAssembler;
    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public ResponseEntity<EntityModel<Department>> newDepartment(@RequestBody Department newDepartment){
        EntityModel<Department> department = departmentAssembler.toModel(departmentService.createNew(newDepartment));
        return ResponseEntity.created(department.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(department);
    }

    @GetMapping("/departments")
    public ResponseEntity<CollectionModel<EntityModel<Department>>> all(){
        logger.info("Received get request for all departments");
        List<EntityModel<Department>> departments = departmentService.getAllDepartments()
                .stream().map(departmentAssembler::toModel).collect(Collectors.toList());
        return ResponseEntity.ok().body(CollectionModel.of(departments, linkTo(methodOn(DepartmentController.class)
                .all()).withSelfRel()));
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<EntityModel<Department>> departmentById(@PathVariable short id) {
        logger.info("Received get request for department with id "+ id);
        Department department = departmentService.findById(id);
        if (department==null){
            logger.info("Department with id "+ id +" not found.");
            throw new DepartmentNotFoundException(id);
        }
        return ResponseEntity.ok().body(departmentAssembler.toModel(department));
    }
}
