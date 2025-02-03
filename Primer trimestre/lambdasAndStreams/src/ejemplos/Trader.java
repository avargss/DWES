package ejemplos;

public class Trader {
    private final String nombre;
    private final String ciudad;

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Trader(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Trader:" + this.nombre + " in this " + this.ciudad;
    }
}
