package anotaciones2;

public class Oficial extends Operario {
    private String categoria;

    public Oficial(String nombre, String apellido, String direccion, String telefono, String dni, int codigoTaller, String categoria) {
        super(nombre, apellido, direccion, telefono, dni, codigoTaller);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + "Categoria: " + categoria + "\n" + "-------------------\n";
    }
}