<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17/01/2025
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categorias</title>

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

<div id="contenedora" style="float:none; margin: 0 auto; width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Categorias</h1>
        </div>
        <div style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">
            <div style="position: absolute; left: 39%; top: 39%;">
                <form action="${pageContext.request.contextPath}/recuperacion/categoria/crear/"
                      style="display: inline-block; margin-right: 10px;">
                    <button class="btn btn-primary" disabled>Crear</button>
                </form>

                <form action="${pageContext.request.contextPath}" style="display: inline-block;">
                    <button class="btn btn-primary">Volver</button>
                </form>
            </div>
        </div>
    </div>

    <div class="clearfix">
        <hr/>
    </div>

    <div class="clearfix">
        <div style="float: left; width: 33%;">ID Categoria</div>
        <div style="float: left; width: 33%;">Nombre</div>
        <div style="float: left; width: 33%;">Acción</div>
    </div>


    <div class="clearfix">
        <hr/>
    </div>

    <%
        if (request.getAttribute("listaProducto") != null) {
            List<Categoria> listaCategoria = (List<Categoria>) request.getAttribute("listaProducto");

            for (Categoria categoria : listaCategoria) {
    %>

    <div style="display: flex; align-items: center; margin-top: 6px; gap: 10px;">
        <div style="flex: 1; text-align: left;">
            <%= categoria.getIdcat() %>
        </div>
        <div style="flex: 1; text-align: left;">
            <%= categoria.getNombre() %>
        </div>

        <div style="flex: 1; text-align: left;">
            <div style="display: flex; gap: 5px;">
                <form action="${pageContext.request.contextPath}/recuperacion/categoria/<%= categoria.getIdcat() %>"
                      style="display: inline;">
                    <input type="submit" value="Ver Detalle"/>
                </form>

                <form action="${pageContext.request.contextPath}/recuperacion/categoria/editar/<%= categoria.getIdcat() %>"
                      style="display: inline;">
                    <input type="submit" value="Editar"/>
                </form>
                <form action="${pageContext.request.contextPath}/recuperacion/categoria/borrar/" method="post"
                      style="display: inline;">
                    <input type="hidden" name="__method__" value="delete"/>
                    <input type="hidden" name="idcat" value="<%= categoria.getIdcat() %>"/>
                    <input type="submit" value="Eliminar"/>
                </form>

            </div>
        </div>
    </div>


    <%
        }
    } else {
    %>
    No hay registros de categorias
    <% } %>

</div>

</body>
</html>
