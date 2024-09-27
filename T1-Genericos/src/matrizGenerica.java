public class matrizGenerica<T> {

    private T[][] matriz;
    private int filas;
    private int columnas;

    public matrizGenerica(int filas, int columnas) {
        this.matriz = (T[][]) new Object[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
    }

    public void set(int fila, int columna, T elemento) {

        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            matriz[fila][columna] = elemento;
        } else {
            throw new IndexOutOfBoundsException("Fuera de límite de la matriz");

        }
    }

    public T get(int fila, int columna) {

        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return matriz[fila][columna];
        } else {
            System.out.println("Fuera de la matriz");
            return null;
        }
    }

    public int columnas() {
        return this.matriz[0].length;
    }

    public int filas() {
        return this.matriz.length;
    }

    @Override
    public String toString() {

        String resultado = "";

        for (int i = 0; i < filas; i++) {
            resultado += "[";
            for (int j = 0; j < columnas; j++) {
                resultado += matriz[i][j];

                if (j < columnas - 1) {
                    resultado += ", ";
                }
            }
            resultado += "]";
            if (i < filas - 1) {
                resultado += "\n";
            }
        }
        return resultado;
    }
}
