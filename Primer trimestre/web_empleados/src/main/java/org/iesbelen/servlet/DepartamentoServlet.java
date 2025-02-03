package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.DepartamentoDAO;
import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.model.Departamento;
import org.iesbelen.model.DepartamentoDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "departamentosServlet", value = "/gestion/departamento/*")
public class DepartamentoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {

            DepartamentoDAO deptDAO = new DepartamentoDAOImpl();

            List<Departamento> dept = deptDAO.getAll();

            List<DepartamentoDTO> listaDepartamentosDTO = dept.stream()
                    .map(departamento -> new DepartamentoDTO(departamento, deptDAO.getCountEmpleados(departamento.getCodigo()).orElse(0)
                    ))
                    .toList();

            request.setAttribute("listaEmpleados", listaDepartamentosDTO);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamento.jsp");

        } else {

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/crear-departamento.jsp");

            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamento.jsp");
            }
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ == null) {
            // Crear uno nuevo
            DepartamentoDAO deptDAO = new DepartamentoDAOImpl();

            String nombre = request.getParameter("nombre");
            Departamento nuevoDept = new Departamento();
            nuevoDept.setNombre(nombre);
            deptDAO.create(nuevoDept);
        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/gestion/departamento");
    }
}
