package org.iesbelen.dao;

import org.iesbelen.model.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO {

    @Override
    public void create(Departamento departamento) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {

            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setDouble(idx++, departamento.getPresupuesto());
            ps.setDouble(idx, departamento.getGastos());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de departamento con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                departamento.setCodigo(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public List<Departamento> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamento> listDept = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento");
            while (rs.next()) {
                Departamento dep = new Departamento();
                int idx = 1;
                dep.setCodigo(rs.getInt(idx++));
                dep.setNombre(rs.getString(idx++));
                dep.setGastos(rs.getDouble(idx++));
                dep.setPresupuesto(rs.getDouble(idx));
                listDept.add(dep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDept;
    }

    @Override
    public Optional<Integer> getCountEmpleados(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT COUNT(*) FROM empleado WHERE codigo_departamento = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return Optional.of(count);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

}
