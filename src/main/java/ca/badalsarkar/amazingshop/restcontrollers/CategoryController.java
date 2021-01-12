package ca.badalsarkar.amazingshop.restcontrollers;

import ca.badalsarkar.amazingshop.models.product.Category;
import ca.badalsarkar.amazingshop.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final Logger logger;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.logger = LoggerFactory.getLogger(CategoryController.class);
    }

    @GetMapping("/categories")
    public List<Category> all(){
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public Category newCategory(@RequestBody Category newCategory){
        logger.info("Received post request for new category for "+newCategory);
        return categoryRepository.save(newCategory);
    }
}
