package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.dto.ProductoDTO;
import org.iesbelen.model.Categoria;
import org.iesbelen.model.Producto;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productoServlet", value = "/recuperacion/producto/*")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;
        String pathInfo = request.getPathInfo();
        ProductoDAO prodDao = new ProductoDAOImpl();

        if (pathInfo == null || "/".equals(pathInfo)) {
            List<Producto> listaProducto;

            String searchParam = request.getParameter("search");
            String menor = request.getParameter("menor");
            String mayor = request.getParameter("mayor");

            Integer stock = null;
            Integer menorValue = null;
            Integer mayorValue = null;

            try {
                if (searchParam != null && !searchParam.isEmpty()) {
                    stock = Integer.parseInt(searchParam);
                }
                if (menor != null && !menor.isEmpty()) {
                    menorValue = Integer.parseInt(menor);
                }
                if (mayor != null && !mayor.isEmpty()) {
                    mayorValue = Integer.parseInt(mayor);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error en los parámetros de búsqueda: " + e.getMessage());
            }

            if (stock != null) {
                listaProducto = prodDao.filtrarPorStock(stock);
            } else if (menorValue != null && mayorValue != null && mayorValue >= menorValue) {
                listaProducto = prodDao.filtrarPorPrecio(menorValue, mayorValue);
            } else {
                listaProducto = prodDao.getAll();
            }

            List<ProductoDTO> listaProductoDTO = listaProducto.stream()
                    .map(producto -> new ProductoDTO(
                            producto,
                            prodDao.getNombreCategoria(producto.getIdCat()).orElse("Sin categoría")
                    ))
                    .toList();

            request.setAttribute("listaProducto", listaProductoDTO);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/producto.jsp");

        } else {

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
                CategoriaDAO catDao = new CategoriaDAOImpl();
                List<Categoria> listaCategoria = catDao.getAll();

                request.setAttribute("listaCategoria", listaCategoria);
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/crear-producto.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/producto.jsp");
            }
        }

        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ == null) {
            // Crear un nuevo producto
            ProductoDAO prodDAO = new ProductoDAOImpl();

            String nombre = request.getParameter("nombre");
            int idcat = Integer.parseInt(request.getParameter("idcat"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            Producto nuevoProducto = new Producto();
            nuevoProducto.setIdCat(idcat);
            nuevoProducto.setNombre(nombre);
            nuevoProducto.setPrecio(precio);
            nuevoProducto.setStock(stock);

            prodDAO.create(nuevoProducto);
        } else {
            System.out.println("Opción POST no soportada.");
        }
        response.sendRedirect(request.getContextPath() + "/recuperacion/producto");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
