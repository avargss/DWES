package org.iesbelen.videoclub.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("No se ha encontrado Categoria con id: " + id);
    }
}