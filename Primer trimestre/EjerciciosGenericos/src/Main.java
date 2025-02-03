public class Main {
    public static void main(String[] args) {
        PilaArray<Integer> pila = new PilaArray<Integer>();

        pila.aniadir(2);
        pila.aniadir(3);
        pila.aniadir(4);

        System.out.println(pila.estaVacia());

        pila.extraer();

        System.out.println(pila);
    }
}