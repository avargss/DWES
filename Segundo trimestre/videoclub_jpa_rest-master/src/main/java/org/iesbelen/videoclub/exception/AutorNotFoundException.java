package org.iesbelen.videoclub.exception;

public class AutorNotFoundException extends RuntimeException {
    public AutorNotFoundException(Long id) {
        super("No se ha encontrado Autor con id: " + id);
    }
}
