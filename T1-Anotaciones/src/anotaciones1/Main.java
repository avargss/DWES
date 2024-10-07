package anotaciones1;

public class Main {

    public static void main(String[] args) {

        Empresa empresa = Empresa.cargadorDeContexto("HazardTech.INC");
        System.out.println(empresa.toString());
    }
}
