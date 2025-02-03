import java.lang.annotation.Repeatable;


@Repeatable(Empleados.class)
public @interface datosEmpleados {

    String nombre();

    String apellido();

    int edad();

    int telefono();

    String[] puesto();

    String departamento();
}
