package org.iesbelen.dao;

import org.iesbelen.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl extends AbstractDAOImpl implements ProductoDAO {

    @Override
    public void create(Producto producto) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO producto (idcat, nombre, precio, stock) values (?, ?, ?, ?)");

            int idx = 1;
            ps.setInt(idx++, producto.getIdCat());
            ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setInt(idx, producto.getStock());

            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Error: no se insertaron filas en la tabla producto.");
            }

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) {
                producto.setIdProd(rsGenKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rsGenKeys);
        }
    }

    @Override
    public List<Producto> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Producto> listaProducto = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM producto");

            while (rs.next()) {
                Producto producto = new Producto();
                int idx = 1;

                producto.setIdProd(rs.getInt(idx++));
                producto.setIdCat(rs.getInt(idx++));
                producto.setNombre(rs.getString(idx++));
                producto.setPrecio(rs.getDouble(idx++));
                producto.setStock(rs.getInt(idx));
                listaProducto.add(producto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listaProducto;
    }

    @Override
    public Optional<Producto> find(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM producto WHERE idprod = ?");

            int idx = 1;
            ps.setInt(idx++, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProd(rs.getInt(idx++));
                producto.setIdCat(rs.getInt(idx++));
                producto.setNombre(rs.getString(idx++));
                producto.setPrecio(rs.getDouble(idx));
                producto.setStock(rs.getInt(idx));

                return Optional.of(producto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<String> getNombreCategoria(int idcat) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = connectDB();

            ps = conn.prepareStatement("SELECT nombre FROM categoria WHERE idcat = ?");
            ps.setInt(1, idcat);

            rs = ps.executeQuery();

            if (rs.next()) {
                String nombreCategoria = rs.getString(1);
                return Optional.of(nombreCategoria);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

    @Override
    public List<Producto> filtrarPorStock(int number) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Producto> producto = new ArrayList<>();

        String sql = "SELECT * FROM producto WHERE stock = ?";

        try {
            conn = connectDB();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, number);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                int idx = 1;
                prod.setIdProd(rs.getInt(idx++));
                prod.setIdCat(rs.getInt(idx++));
                prod.setNombre(rs.getString(idx++));
                prod.setPrecio(rs.getDouble(idx++));
                prod.setStock(rs.getInt(idx));

                producto.add(prod);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return producto;
    }

    @Override
    public List<Producto> filtrarPorPrecio(int menor, int mayor) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Producto> listaProducto = new ArrayList<>();

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM producto WHERE precio >= ? AND precio <= ?");

            ps.setInt(1, menor);
            ps.setInt(2, mayor);

            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                int idx = 1;
                prod.setIdProd(rs.getInt(idx++));
                prod.setIdCat(rs.getInt(idx++));
                prod.setNombre(rs.getString(idx++));
                prod.setPrecio(rs.getDouble(idx++));
                prod.setStock(rs.getInt(idx));

                listaProducto.add(prod);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return listaProducto;
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(int id) {

    }
}
