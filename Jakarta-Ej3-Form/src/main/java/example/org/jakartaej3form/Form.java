package example.org.jakartaej3form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "form", value = "/form")
public class Form extends HttpServlet {
    List<String> formInd = new ArrayList<>();
    List<String[]> formArr = new ArrayList<>();

    @Override
    public void init() {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        formInd.add(req.getParameter("Nombre: "));
        formInd.add(req.getParameter("Apellidos: "));
        formInd.add(req.getParameter("Edad: "));
        formInd.add(req.getParameter("Peso: "));
        formInd.add(req.getParameter("Sexo: "));
        formInd.add(req.getParameter("Estado Civil: "));
        formArr.add(req.getParameterValues("Aficiones: "));
    }
}
