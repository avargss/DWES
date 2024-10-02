import java.lang.annotation.*;

@Documented // Indica que los elementos deben ser documentados por JavaDoc
@Inherited
// Cuando se aplica esta anotación a cualquier otra anotación en su definición indicará que la anotación se hereda en el esquema de herencia de clases de Java.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Para que la anotación se pueda usar en clases
@Repeatable(EmpleadosNota.class)

public @interface DatosEmpleados {

    String nombre();

    String apellido();

    String direccion();

    String telefono();

    String dni();

    String clase(); // `Directivo`, `Oficial`, `Tecnico`.

    int codigoDespacho() default -1; // La usa el Directivo

    int codigoTaller() default -1; // La usa el Operario y sus subclases

    String categoria() default ""; // La usa el Técnico

    String perfil() default ""; // La usa el Oficial

}