package ca.badalsarkar.amazingshop.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Short id) {
        super("Department not found with id "+ id);
    }
}
