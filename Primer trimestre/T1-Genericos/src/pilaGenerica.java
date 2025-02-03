import java.util.LinkedList;
import java.util.List;

public class pilaGenerica<T> implements ColeccionSimpleGenerica<T> {

    private List<T> pila = new LinkedList<T>();

    public pilaGenerica() {

    }

    @Override
    public boolean estaVacia() {
        if (pila.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T extraer() {
        return pila.removeFirst();
    }

    @Override
    public T primero() {
        return pila.getFirst();
    }

    @Override
    public void aniadir(T nuevoObjeto) {
        pila.add(pila.size(), nuevoObjeto);
    }

    @Override
    public String toString() {

        return pila.toString();
    }
}