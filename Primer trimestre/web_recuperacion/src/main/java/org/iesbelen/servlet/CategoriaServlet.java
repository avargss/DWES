package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.model.Categoria;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "categoriaServlet", value = "/recuperacion/categoria/*")
public class CategoriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {

            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            List<Categoria> listaCategoria = categoriaDAO.getAll();

            request.setAttribute("listaProducto", listaCategoria);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/categoria.jsp");

        } else {
            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 3 && "editar".equals(pathParts[1])) {
                CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

                try {
                    request.setAttribute("nombre", categoriaDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/editar-categoria.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/categoria.jsp");
                }

            } else {
                System.out.println("Opción GET no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categorias/categoria.jsp");
            }
        }
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ == null) {
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            // Dado que los forms de html solo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
            doPut(request, response);

        } else {
            System.out.println("Opción POST no soportada.");
        }

        //response.sendRedirect(request.getContextPath() + "/recuperacion/categoria");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
        Optional<Categoria> categoriaOptional = categoriaDAO.find(Integer.parseInt(request.getParameter("idcat")));

        String idcat = request.getParameter("idcat");
        String nombre = request.getParameter("nombre");

        Categoria categoriaNew = new Categoria();

        try {
            int id = Integer.parseInt(idcat);
            categoriaNew.setIdcat(id);
            categoriaNew.setNombre(nombre);

            categoriaDAO.update(categoriaNew);
            response.sendRedirect(request.getContextPath() + "/recuperacion/categoria");

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
