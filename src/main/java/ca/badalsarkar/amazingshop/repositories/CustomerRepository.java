package ca.badalsarkar.amazingshop.repositories;

import ca.badalsarkar.amazingshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
