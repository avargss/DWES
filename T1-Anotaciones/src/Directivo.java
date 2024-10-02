public class Directivo extends Empleado {
    private int codigoDespacho;

    public Directivo(String nombre, String apellido, String direccion, String telefono, String dni, int codigoDespacho) {
        super(nombre, apellido, direccion, telefono, dni);
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        return super.toString() + "Código del despacho: " + codigoDespacho + "\n" + "-------------------\n";
    }
}
