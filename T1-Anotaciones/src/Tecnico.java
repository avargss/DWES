public class Tecnico extends Operario{
    private String perfil;

    public Tecnico(String nombre, String apellido, String direccion, String telefono, String dni, String clase, int codigoTaller, String perfil) {
        super(nombre, apellido, direccion, telefono, dni, clase, codigoTaller);
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Perfil: " + perfil + "\n");
        sb.append("-------------------\n");

        return sb.toString();
    }
}
