package anotaciones2;

public class Main {

    public static void main(String[] args) {
        Empresa empresa = new Empresa("HazardTech.INC");

        System.out.println(empresa);
        Empresa.cargadorDirectivo(empresa);
        Empresa.cargadorOficial(empresa);
        Empresa.cargadorTecnico(empresa);

    }
}