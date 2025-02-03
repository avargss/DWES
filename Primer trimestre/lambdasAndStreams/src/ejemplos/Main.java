package ejemplos;

import java.util.Arrays;
import java.util.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

        Trader alvaro = new Trader("Alvaro", "Barcelona");
        Trader miguel = new Trader("Miguel", "Budapest");
        Trader daniel = new Trader("Daniel", "Sevilla");
        Trader rodolfo = new Trader("Rodolfo", "Málaga");
        Trader alex = new Trader("Alex", "Alhaurin");

        List<Transaction> transactions = Arrays.asList(new Transaction(alvaro, 2011, 300),
                new Transaction(miguel, 1998, 400), new Transaction(daniel, 1995, 500),
                new Transaction(rodolfo, 2011, 600), new Transaction(alex, 2003, 700));

    // 1 Encuentre todas las transacciones del año 2011 y ordénelas por valor (menor a mayor).

        List<Transaction> tr2001 = transactions.stream()
                .filter(transaction -> transaction.getAnio() == 2011)
                .sorted(comparing(Transaction::getValor))
                .collect(toList());


        // 2 ¿Cuáles son todas las ciudades (sin repetición) donde trabajan los traders?


        // O mediante toSet


    // 3 Encuentre todos los traders de Cambridge y ordénelos por nombre.


    // 4 Devuelva los nombres de todos los traders ordenados alfabéticamente en una sola cadena.


        // O mediante joining


    // 5 ¿Hay traders con sede en Milán? Sí o no


    // 6 Imprime los valores de todas las transacciones de los traders que viven en Cambridge.


    // 7 ¿Cuál es el valor más alto de todas las transacciones?


    // 8 Encuentra la transacción con el valor más pequeño.


    //-------------------------------------------------------------------------------------------------------------

    }
}
