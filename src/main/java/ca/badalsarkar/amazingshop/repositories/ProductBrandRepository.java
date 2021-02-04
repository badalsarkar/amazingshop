package ca.badalsarkar.amazingshop.repositories;

import ca.badalsarkar.amazingshop.models.product.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBrandRepository extends JpaRepository<ProductBrand, Long> {
}
