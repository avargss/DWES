import java.util.List;

@datosEmpleados(
        nombre = "Manuel",
        apellido = "Jimenes",
        edad = 40,
        telefono = 123456789,
        puesto = "Directivo",
        departamento = "RRHH"
)

@datosEmpleados(
        nombre = "Juan",
        apellido = "García",
        edad = 30,
        telefono = 12345678,
        puesto = "Técnico",
        departamento = "RRHH"
)

@datosEmpleados(
        nombre = "Marta",
        apellido = "Fajardo",
        edad = 38,
        telefono = 1234567,
        puesto = "Operario",
        departamento = "RRHH"
)

public class Empresa {

    private String nombre;
    private List<Empleados> listaEmpleados;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa();
        datosEmpleados[] datosEmp = Empresa.class.getAnnotationsByType(datosEmpleados.class);

        for (datosEmpleados datos : datosEmp) {
            if (Empresa.DIRECTIVO.equals(datosEmp.clase())) {
                System.out.println();
            }
        }
    }
}