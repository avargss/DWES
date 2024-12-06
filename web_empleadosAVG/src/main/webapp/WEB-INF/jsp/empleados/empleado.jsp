<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Empleado" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }

    </style>

</head>
<body>

<main>
    <section>
        <div id="contenedora" style="float:none; margin: 0 auto; width: 900px;">
            <div class="clearfix">
                <div style="float: left; width: 50%">
                    <h1>Empleados</h1>
                </div>
            </div>

            <div class="clearfix">
                <hr/>
            </div>

            <div class="clearfix">
                <div style="float: left; width: 14.28%">Código</div>
                <div style="float: left; width: 14.28%">Nif</div>
                <div style="float: left; width: 14.28%">Nombre</div>
                <div style="float: left; width: 14.28%">Apellido 1</div>
                <div style="float: left; width: 14.28%">Apellido 2</div>
                <div style="float: left; width: 14.28%">CodigoDep</div>
                <div style="float: none; width: 14.28%; overflow: hidden;">Accion</div>
            </div>

            <div class="clearfix">
                <hr/>
            </div>

            <%
                if (request.getAttribute("listaEmpleados") != null) {
                    List<Empleado> listaEmpleados = (List<Empleado>) request.getAttribute("listaEmpleados");

                    for (Empleado empleado : listaEmpleados) {
            %>

            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left; width: 14.28%">
                    <%= empleado.getCodigo() %>
                </div>
                <div style="float: left; width: 14.28%">
                    <%= empleado.getNif() %>
                </div>
                <div style="float: left; width: 14.28%">
                    <%= empleado.getNombre() %>
                </div>
                <div style="float: left; width: 14.28%">
                    <%= empleado.getApellido1() %>
                </div>
                <div style="float: left; width: 14.28%">
                    <%= empleado.getApellido2() %>
                </div>
                <div style="float: left; width: 14.28%">
                    <%= empleado.getCodigo_departamento() %>
                </div>
                <div style="float: none; width: auto; overflow: hidden;">

                    <form action="${pageContext.request.contextPath}/gestion/empleado/editar<%= empleado.getCodigo() %>"
                          style="display: inline;">
                        <input type="submit" value="Editar"/>
                    </form>

                </div>
            </div>
        </div>

        <%
            }
        } else {
        %>
        No hay registros de empleados
        <% } %>
    </section>
</main>

</body>
</html>