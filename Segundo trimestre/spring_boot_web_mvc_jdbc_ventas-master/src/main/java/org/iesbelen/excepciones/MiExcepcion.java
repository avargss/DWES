package org.iesbelen.excepciones;

public class MiExcepcion extends RuntimeException {

    public MiExcepcion(String mensaje) {
        super(mensaje);
    }

    public MiExcepcion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
