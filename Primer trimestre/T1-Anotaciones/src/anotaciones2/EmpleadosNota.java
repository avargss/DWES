package anotaciones2;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited

public @interface EmpleadosNota {
    DatosEmpleados[] value();
}