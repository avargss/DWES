import java.util.ArrayList;
import java.util.List;

@EmpleadoNota(nombre = "Daniel", apellido = "Torralvo", direccion = "Málaga 1", telefono = "123", dni = "12345678A", clase = "Directivo", codigoDespacho = 1)
@EmpleadoNota(nombre = "Miguel", apellido = "Luque", direccion = "Málaga 2", telefono = "456", dni = "12345678B", clase = "Oficial", codigoTaller = 1, categoria = "C")
@EmpleadoNota(nombre = "Rodolfo", apellido = "Dorronsoro", direccion = "Málaga 3", telefono = "789", dni = "12345678C", clase = "Tecnico", codigoTaller = 404, perfil = "Informático")

public class Empresa {
    private String nombre;
    private List<Empleado> listaEmpleados;

    public Empresa(String nombre) { // OJO no añadir la lista de empleados en el constructor porque haría conflicto en el cargador de contexto.
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public static Empresa cargadorDeContexto(String nombre) {
        Empresa empresa = new Empresa(nombre);

        // Sacamos la clase de la empresa para poder llamarla más tarde.
        Class<Empresa> claseEmpresa = Empresa.class;

        // Añadimos las anotaciones de empleados a un nuevo array
        EmpleadoNota[] empleadosAnotados = claseEmpresa.getAnnotationsByType(EmpleadoNota.class);

        // Ahora recorremos el array para procesar todas las anotaciones que teníamos puestas.
        for (EmpleadoNota e : empleadosAnotados) {
            String clase = e.clase();
            Empleado empleado = null; // Si no lo inicializamos como null, nos dará error.

            switch (clase) { // Diferenciamos por el atributo clase de cada empleado, no clase de .java
                case "Directivo":
                    empleado = new Directivo(e.nombre(), e.apellido(), e.direccion(), e.telefono(), e.dni(), e.clase(), e.codigoDespacho());
                    break;
                case "Tecnico":
                    empleado = new Tecnico(e.nombre(), e.apellido(), e.direccion(), e.telefono(), e.dni(), e.clase(), e.codigoTaller(), e.perfil());
                    break;
                case "Oficial":
                    empleado = new Oficial(e.nombre(), e.apellido(), e.direccion(), e.telefono(), e.dni(), e.clase(), e.codigoTaller(), e.categoria());
                    break;
                default:
                    System.out.println("Clase no reconocida: " + clase);
            }

            if (empleado != null) { // Si existe un nuevo empleado, se añade al arraylist.
                empresa.listaEmpleados.add(empleado);
            }
        }
        return empresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "Empleados: \n" + listaEmpleados.toString() +
                "\n Nombre Empresa: " + nombre +
                "}";
    }
}