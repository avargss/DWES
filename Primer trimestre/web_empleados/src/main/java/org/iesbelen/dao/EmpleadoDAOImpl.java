package org.iesbelen.dao;

import org.iesbelen.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadoDAO {


    @Override
    public void create(Empleado empleado) {

    }

    @Override
    public List<Empleado> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Empleado> listaEmp = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM empleado");
            while (rs.next()) {
                Empleado emp = new Empleado();
                int idx = 1;
                emp.setCodigo(rs.getInt(idx++));
                emp.setNif(rs.getString(idx++));
                emp.setNombre(rs.getString(idx++));
                emp.setApellido1(rs.getString(idx++));
                emp.setApellido2(rs.getString(idx++));
                emp.setCodigo_departamento(rs.getInt(idx));

                listaEmp.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listaEmp;
    }

    @Override
    public Optional<Empleado> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM empleado WHERE codigo_departamento = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Empleado emp = new Empleado();
                idx = 1;
                emp.setCodigo(rs.getInt(idx++));
                emp.setNif(rs.getString(idx++));
                emp.setNombre(rs.getString(idx));
                emp.setApellido1(rs.getString(idx++));
                emp.setApellido2(rs.getString(idx++));
                emp.setCodigo_departamento(rs.getInt(idx));

                return Optional.of(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

    @Override
    public void update(Empleado empleado) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE empleado SET nif = ?, nombre = ?, apellido1 = ?, apellido2 = ?, codigo_departamento = ? WHERE codigo = ?");
            int idx = 1;
            ps.setString(idx++, empleado.getNif());
            ps.setString(idx++, empleado.getNombre());
            ps.setString(idx++, empleado.getApellido1());
            ps.setString(idx++, empleado.getApellido2());
            ps.setInt(idx, empleado.getCodigo_departamento());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de empleado con 0 registros actualizados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
