package ca.badalsarkar.amazingshop.repositories;

import ca.badalsarkar.amazingshop.models.product.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Short> {
}
