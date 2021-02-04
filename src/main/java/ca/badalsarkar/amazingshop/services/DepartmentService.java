package ca.badalsarkar.amazingshop.services;

import ca.badalsarkar.amazingshop.exceptions.DepartmentNotFoundException;
import ca.badalsarkar.amazingshop.models.product.Department;
import ca.badalsarkar.amazingshop.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department createNew(Department department){return departmentRepository.save(department);}

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department findById(short id){
        return departmentRepository.findById(id).orElse(null);
    }


}
