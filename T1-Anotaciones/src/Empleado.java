public class Empleado {
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;
    protected String dni;

    public Empleado(String nombre, String apellido, String direccion, String telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: " + nombre + "\n");
        sb.append("Apellido: " + apellido + "\n");
        sb.append("Direccion: " + direccion + "\n");
        sb.append("Telefono: " + telefono + "\n");
        sb.append("DNI: " + dni + "\n");
        return sb.toString();
    }
}
