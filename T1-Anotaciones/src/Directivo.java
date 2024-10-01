public class Directivo extends Empleado {
    private int codigoDespacho;

    public Directivo(String nombre, String apellido, String direccion, String telefono, String dni, int codigoDespacho) {
        super(nombre, apellido, direccion, telefono, dni);
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Código del despacho: " + codigoDespacho + "\n");
        sb.append("-------------------\n");


        return sb.toString();
    }
}
