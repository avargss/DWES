package org.iesbelen.model;

public class Categoria {

    private int idCat;
    private String nombre;

    public int getIdcat() {
        return idCat;
    }

    public void setIdcat(int idcat) {
        this.idCat = idcat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria that = (Categoria) o;

        if (idCat != that.idCat) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCat;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
