package anotaciones1;

public class Operario extends Empleado {
    private int codigoTaller;

    public Operario(String nombre, String apellido, String direccion, String telefono, String dni, int codigoTaller) {
        super(nombre, apellido, direccion, telefono, dni);
        this.codigoTaller = codigoTaller;
    }

    @Override
    public String toString() {
        return super.toString() + "Código Taller: " + codigoTaller + "\n";
    }
}
