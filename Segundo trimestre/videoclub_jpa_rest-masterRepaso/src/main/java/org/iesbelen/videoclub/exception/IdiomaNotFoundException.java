package org.iesbelen.videoclub.exception;

public class IdiomaNotFoundException extends RuntimeException {
    public IdiomaNotFoundException(Long id) {
        super("No se ha encontrado el idioma con id: " + id);
    }
}
