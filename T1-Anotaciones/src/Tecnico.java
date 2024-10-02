public class Tecnico extends Operario{
    private String perfil;

    public Tecnico(String nombre, String apellido, String direccion, String telefono, String dni, int codigoTaller, String perfil) {
        super(nombre, apellido, direccion, telefono, dni, codigoTaller);
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return super.toString() + "Perfil: " + perfil + "\n" + "-------------------\n";
    }
}
