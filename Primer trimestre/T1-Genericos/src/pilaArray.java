import java.util.Arrays;

public class pilaArray<T> extends pilaGenerica<T> {
    private T[] pila;
    int contador = 0;

    public pilaArray() {
        pila = (T[]) new Object[10];
    }

    @Override
    public boolean estaVacia() {
        return pila.length == 0;
    }

    @Override
    public T extraer() {
        T elemento = pila[0];

        for (int i = 1; i < contador; i++) {
            pila[i - 1] = pila[i];
        }

        pila[--contador] = null; //Esto sirve para reducir el contador y eliminar la referencia

        return elemento;
    }

    @Override
    public T primero() {
        return pila[0];
    }

    @Override
    public void aniadir(T nuevoObjeto) {
        pila = Arrays.copyOf(pila, ++contador);
        pila[pila.length - 1] = nuevoObjeto;
    }

    @Override
    public String toString() {
        return "pilaArray{" +
                "pila=" + Arrays.toString(pila) +
                '}';
    }
}