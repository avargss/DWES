package anotaciones2;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Repeatable(EmpleadosNota.class)
// La anotación `Repeatable` permite que la anotación de la clase EmpleadosNota se repita las veces que haga falta.
// Para que funcione hay que añadir @Inherited en la clase a la que hace referencia.

public @interface EmpleadoNota {
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