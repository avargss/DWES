package org.iesbelen.dao;

import java.util.List;
import java.util.Optional;

import org.iesbelen.model.Departamento;

public interface DepartamentoDAO {
		
	public void create(Departamento departamento);
	public List<Departamento> getAll();

	public Optional<Integer> getCountEmpleados(int id);
//	public Optional<Departamento> find(int id);
//	public void update(Departamento departamento);
//	public void delete(int id);

}
