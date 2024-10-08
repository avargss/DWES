package anotaciones2;

import java.util.ArrayList;
import java.util.List;

@DatosDirectivo(nombre = "Daniel", apellidos = "Torralvo", direccion = "Málaga 1", telefono = "123", dni = "12345678A",  codigoDespacho = 1)
@DatosOficial(nombre = "Miguel", apellidos = "Luque", direccion = "Málaga 2", telefono = "456", dni = "12345678B", codigoTaller = 1, categoria = "C")
@DatosTecnico(nombre = "Rodolfo", apellidos = "Dorronsoro", direccion = "Málaga 3", telefono = "789", dni = "12345678C", codigoTaller = 404, perfil = "Informático")

public class Empresa {
    private String nombre;
    private List<Empleado> listaEmpleados;

    public Empresa(String nombre) { // OJO no añadir la lista de empleados en el constructor porque haría conflicto en el cargador de contexto.
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public static Empresa cargadorDirectivo(Empresa empresa) {
        DatosDirectivo[] directivos = Empresa.class.getAnnotationsByType((DatosDirectivo.class));
        for (DatosDirectivo d : directivos) {
            Empleado directivo = null;
            directivo = new Directivo(d.nombre(), d.apellidos(), d.direccion(), d.telefono(), d.dni(), d.codigoDespacho());
            if (directivo != null) {
                empresa.listaEmpleados.add(directivo);
            }
        }
        return empresa;
    }

    public static Empresa cargadorOficial(Empresa empresa) {
        DatosOficial[] oficiales = Empresa.class.getAnnotationsByType((DatosOficial.class));
        for (DatosOficial o : oficiales) {
            Empleado oficial = null;
            oficial = new Oficial(o.nombre(), o.apellidos(), o.direccion(), o.telefono(), o.dni(), o.codigoTaller(), o.categoria());
            if (oficial != null) {
                empresa.listaEmpleados.add(oficial);
            }
        }
        return empresa;
    }

    public static Empresa cargadorTecnico(Empresa empresa) {
        DatosTecnico[] tecnicos = Empresa.class.getAnnotationsByType((DatosTecnico.class));
        for (DatosTecnico t : tecnicos) {
            Empleado tecnico = null;
            tecnico = new Oficial(t.nombre(), t.apellidos(), t.direccion(), t.telefono(), t.dni(), t.codigoTaller(), t.perfil());
            if (tecnico != null) {
                empresa.listaEmpleados.add(tecnico);
            }
        }
        return empresa;
    }


    // Cargador de contexto del ejercicio 1.
    /*public static Empresa cargadorDeContexto(String nombre) {
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
                    empleado = new Directivo(e.nombre(), e.apellido(), e.direccion(), e.telefono(), e.dni(), e.codigoDespacho());
                    break;
                case "Tecnico":
                    empleado = new Tecnico(e.nombre(), e.apellido(), e.direccion(), e.telefono(), e.dni(), e.codigoTaller(), e.perfil());
                    break;
                case "Oficial":
                    empleado = new Oficial(e.nombre(), e.apellido(), e.direccion(), e.telefono(), e.dni(), e.codigoTaller(), e.categoria());
                    break;
                default:
                    System.out.println("Clase no reconocida: " + clase);
            }

            if (empleado != null) { // Si existe un nuevo empleado, se añade al arraylist.
                empresa.listaEmpleados.add(empleado);
            }
        }
        return empresa;
    }*/

    @Override
    public String toString() {
        return "Empresa{" +
                "Empleados: \n" + listaEmpleados.toString() +
                "\n Nombre Empresa: " + nombre +
                "}";
    }
}