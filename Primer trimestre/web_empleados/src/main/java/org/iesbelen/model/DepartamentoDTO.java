package org.iesbelen.model;

public class DepartamentoDTO extends Departamento{

    private int numEmpleados;

    public DepartamentoDTO(int codigo, String nombre, double presupuesto, double gastos, int numEmpleados) {
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setPresupuesto(presupuesto);
        this.setGastos(gastos);
        this.numEmpleados = numEmpleados;
    }

    public DepartamentoDTO(Departamento departamento, int numEmpleados) {
        this.setCodigo(departamento.getCodigo());
        this.setNombre(departamento.getNombre());
        this.setNumEmpleados(numEmpleados);
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }
}
