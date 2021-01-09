package ca.badalsarkar.amazingshop.restcontroller;

import ca.badalsarkar.amazingshop.models.Customer;
import ca.badalsarkar.amazingshop.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    public List<Customer> all(){
        return repository.findAll();
    }
}
