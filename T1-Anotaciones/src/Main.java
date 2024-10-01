public class Main {

    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto("SeVendeUranio");
        System.out.println(empresa.toString());
    }
}
