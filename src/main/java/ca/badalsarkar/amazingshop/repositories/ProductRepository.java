package ca.badalsarkar.amazingshop.repositories;

import ca.badalsarkar.amazingshop.models.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    List<Product> findByBrand_Id(Long id);
    List<Product> findByCategory_Id(Long id);
    Page<Product> findByDepartment_Id(Short id, Pageable pageable);
}
