public class Operario extends Empleado {
    private int codigoTaller;

    public Operario(String nombre, String apellido, String direccion, String telefono, String dni, int codigoTaller) {
        super(nombre, apellido, direccion, telefono, dni);
        this.codigoTaller = codigoTaller;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Código Taller: " + codigoTaller + "\n");
        sb.append("-------------------\n");

        return sb.toString();
    }
}
