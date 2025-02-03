package anotaciones2;

import java.lang.annotation.*;

@Documented // Indica que los elementos deben ser documentados por JavaDoc
@Inherited
// Cuando se aplica esta anotación a cualquier otra anotación en su definición indicará que la anotación se hereda en el esquema de herencia de clases de Java.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Para que la anotación se pueda usar en clases

public @interface DatosOficial {
    String nombre();

    String apellidos();

    String dni();

    String direccion();

    String telefono();

    int codigoTaller() default 1; // Para Operario y subclases

    String categoria() default ""; // Para Oficial
}