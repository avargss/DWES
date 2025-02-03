import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
//Esta anotación indica que se debe incluir una nueva anotación en los documentos java generados por las herramientas de generación de documentos java (javadoc).

@Target(value = {ElementType.TYPE})
//Esta anotación permite que se pueda usar en distintas clases.

public @interface Empleados {
    datosEmpleados[] value(); //Array con todos los empleados.
}
