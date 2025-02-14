package org.iesbelen.videoclub.exception;

public class PeliculaNotFoundException extends RuntimeException {
    public PeliculaNotFoundException(Long id) {
        super("No se ha encontrado la película con id: " + id);
    }
}
