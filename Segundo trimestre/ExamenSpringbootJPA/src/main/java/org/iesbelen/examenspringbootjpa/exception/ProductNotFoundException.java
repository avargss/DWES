package org.iesbelen.examenspringbootjpa.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Excepción");
    }
}
