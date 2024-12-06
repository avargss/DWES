package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.EmpleadoDAO;
import org.iesbelen.dao.EmpleadoDAOImpl;
import org.iesbelen.model.Empleado;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "empleadosServlet", value = "/gestion/empleado/*")
public class EmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || "/".equals(pathInfo)) {

            EmpleadoDAO empDAO = new EmpleadoDAOImpl();

            List<Empleado> listaEmpleados = empDAO.getAll();

            request.setAttribute("listaEmpleados", listaEmpleados);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleado.jsp");

        } else {

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 3 && "editar".equals(pathParts[1])) {

                EmpleadoDAO empDAO = new EmpleadoDAOImpl();

                try {
                    request.setAttribute("empleado", empDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/editar-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleado.jsp");
                }
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
            EmpleadoDAO empDAO = new EmpleadoDAOImpl();

            String nif = request.getParameter("nif");
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");


            Empleado nuevoEmp = new Empleado();
            nuevoEmp.setNif(nif);
            nuevoEmp.setNombre(nombre);
            nuevoEmp.setApellido1(apellido1);
            nuevoEmp.setApellido2(apellido2);
            empDAO.create(nuevoEmp);

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            //Dado que los forms de html solo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
            doPut(request, response);

        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/gestion/empleados");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpleadoDAO empDAO = new EmpleadoDAOImpl();
        String codigo = request.getParameter("codigo");
        String nif = request.getParameter("nif");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String codigo_departamento = request.getParameter("codigo_departamento");
        Empleado emp = new Empleado();

        try {
            int id = Integer.parseInt(codigo);
            emp.setCodigo(id);
            emp.setNif(nif);
            emp.setNombre(nombre);
            emp.setApellido1(apellido1);
            emp.setApellido2(apellido2);
            emp.setCodigo_departamento(Integer.parseInt(codigo_departamento));
            empDAO.update(emp);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
