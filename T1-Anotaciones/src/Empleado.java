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
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Direccion: " + direccion + "\n" +
                "Telefono: " + telefono + "\n" +
                "DNI:" + dni + "\n";
    }
}