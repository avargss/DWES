public class Empleados {
    public @interface empleado {
        String nombre();
        String apellido();
        int edad();
        String puesto() default "Becario";
        int telefono();
        String departamento();

    }
}
