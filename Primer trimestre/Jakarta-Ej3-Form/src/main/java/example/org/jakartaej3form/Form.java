package example.org.jakartaej3form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "form", value = "/form")
public class Form extends HttpServlet {

    private String nombre;
    private String apellido;
    private String edad;
    private String peso;
    private String sexo;
    private String estado_civil;
    private String[] aficiones;

    @Override
    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellidos");
        edad = request.getParameter("edad");
        peso = request.getParameter("peso");
        sexo = request.getParameter("sexo");
        estado_civil = request.getParameter("estado_civil");
        aficiones = request.getParameterValues("aficiones");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Nombre: " + nombre + "</h1>");
        out.println("<h2>" + "Apellido: " + apellido + "</h2>");
        out.println("<h2>" + "Edad: " + edad + "</h2>");
        out.println("<h2>" + "Peso: " + peso + "</h2>");
        out.println("<h2>" + "Sexo: " + sexo + "</h2>");
        out.println("<h2>" + "Estado Civil: " + estado_civil + "</h2>");
        out.println("<h2>" + "Aficiones: " + "</h2>");

        for (String aficion : aficiones) {
            if (aficion != null) {
                out.println("<h2>" + aficion + "</h2>");
            }
        }

        out.println("</body></html>");

    }
}
