public class Main {

    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto("HazardTech.inc");
        System.out.println(empresa.toString());
    }
}
