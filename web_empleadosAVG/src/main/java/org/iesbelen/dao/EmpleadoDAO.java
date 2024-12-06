package org.iesbelen.dao;

import java.util.List;
import java.util.Optional;

import org.iesbelen.model.Empleado;

public interface EmpleadoDAO {
		
	public void create(Empleado empleado);
	public List<Empleado> getAll();
	public Optional<Empleado> find(int id);
	public void update(Empleado empleado);

	public Optional<Integer> getCountDepartamentos(int id);
	// public void delete(int id);

}
