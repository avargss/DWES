package org.iesbelen.dao;

import org.iesbelen.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDAOImpl extends AbstractDAOImpl implements CategoriaDAO {

    @Override
    public void create(Categoria categoria) {

    }

    @Override
    public List<Categoria> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Categoria> listaCategoria = new ArrayList<>();

        try {
            conn = connectDB();
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM categoria");

            while (rs.next()) {
                Categoria categoria = new Categoria();
                int idx = 1;

                categoria.setIdcat(rs.getInt(idx++));
                categoria.setNombre(rs.getString(idx));
                listaCategoria.add(categoria);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listaCategoria;
    }

    @Override
    public Optional<Categoria> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM categoria WHERE idcat = ?");

            int idx = 1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Categoria categoria = new Categoria();

                categoria.setIdcat(rs.getInt(idx++));
                categoria.setNombre(rs.getString(idx));
                return Optional.of(categoria);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public void update(Categoria categoria) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE categoria SET nombre = ? WHERE idcat = ?");

            int idx = 1;
            ps.setString(idx++, categoria.getNombre());
            ps.setInt(idx, categoria.getIdcat());
            ps.executeUpdate();

            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Update de categoria con 0 registros actualizados.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

    }
}
