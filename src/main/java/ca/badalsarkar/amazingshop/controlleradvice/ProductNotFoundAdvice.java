package ca.badalsarkar.amazingshop.controlleradvice;

import ca.badalsarkar.amazingshop.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ProductNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException ex){
        return ex.getMessage();
    }
}
