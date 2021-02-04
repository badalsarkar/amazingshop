package ca.badalsarkar.amazingshop.services;

import ca.badalsarkar.amazingshop.models.product.Product;
import ca.badalsarkar.amazingshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DepartmentService departmentService;

    public Product createNew(Product newProduct){
        return productRepository.save(newProduct);
    }
}
