package ca.badalsarkar.amazingshop.controlleradvice;

import ca.badalsarkar.amazingshop.exceptions.ProductBrandNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductBrandNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProductBrandNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String brandNotFoundAdvice(ProductBrandNotFoundException ex){return ex.getMessage();}
}
