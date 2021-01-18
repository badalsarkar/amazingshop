package ca.badalsarkar.amazingshop.repositories;

import ca.badalsarkar.amazingshop.models.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
