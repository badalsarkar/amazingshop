package ca.badalsarkar.amazingshop.exceptions;

public class ProductBrandNotFoundException extends RuntimeException {
    public ProductBrandNotFoundException(Long id) {
        super("Could not find brand "+id);
    }
}
