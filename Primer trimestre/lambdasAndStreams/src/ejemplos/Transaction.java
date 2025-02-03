package ejemplos;

public class Transaction {

    private final Trader trader;
    private final int anio;
    private final int valor;

    public Transaction(Trader trader, int anio, int valor) {
        this.trader = trader;
        this.anio = anio;
        this.valor = valor;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getAnio() {
        return anio;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "{" + this.trader + ", " + this.anio + ", " + this.valor + "}";
    }
}
