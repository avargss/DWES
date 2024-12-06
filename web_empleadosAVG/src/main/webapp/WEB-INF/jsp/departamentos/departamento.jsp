<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.model.DepartamentoDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Departamentos</title>
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
                    <h1>Departamentos</h1>
                </div>
                <div style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">
                    <div style="position: absolute; left: 39%; top: 39%;">
                        <form action="${pageContext.request.contextPath}/gestion/departamento/crear">
                            <input type="submit" value="Crear">
                        </form>
                    </div>
                </div>
            </div>

            <div class="clearfix">
                <hr/>
            </div>

            <div class="clearfix">
                <div style="float: left; width: 20%">Código</div>
                <div style="float: left; width: 20%">Nombre</div>
                <div style="float: left; width: 20%">Empleados</div>
                <div style="float: left; width: 20%">Presupuesto</div>
                <div style="float: none; width: 20%; overflow: hidden;">Gastos</div>
            </div>

            <div class="clearfix">
                <hr/>
            </div>

                <%
        if (request.getAttribute("listaEmpleados") != null) {
            List<DepartamentoDTO> listaDepartamento = (List<DepartamentoDTO>) request.getAttribute("listaEmpleados");

            for (DepartamentoDTO departamento : listaDepartamento) {
    %>

            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left; width: 20%">
                    <%= departamento.getCodigo() %>
                </div>
                <div style="float: left; width: 20%">
                    <%= departamento.getNombre() %>
                </div>
                <div style="float: left; width: 20%">
                    <%= departamento.getNumEmpleados() %>
                </div>
                <div style="float: left; width: 20%">
                    <%= departamento.getPresupuesto() %>
                </div>
                <div style="float: left; width: 20%">
                    <%= departamento.getGastos() %>
                </div>
            </div>

                <%
        }
    } else {
    %>
            No hay registros de departamentos
                <% } %>
    </section>
</main>

</body>
</html>