<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.iesbelen.dto.ProductoDTO" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17/01/2025
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>

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

<div id="contenedora" style="float:none; margin: 0 auto; width: 1200px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Productos</h1>
        </div>
        <div style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">


            <div style="position: absolute; left: 39%; top: 39%;">
                <form action="${pageContext.request.contextPath}/recuperacion/producto/crear/"
                      style="display: inline-block; margin-right: 10px;">
                    <button class="btn btn-primary">Crear</button>
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
        <div style="float: left; width: 10%;">ID Producto</div>
        <div style="float: left; width: 10%;">ID Categoria</div>
        <div style="float: left; width: 20%;">Nombre</div>
        <div style="float: left; width: 20%;">Categoria</div>
        <div style="float: left; width: 5%;">Precio</div>
        <div style="float: left; width: 5%;">Stock</div>
        <div style="float: left; width: auto;">Acción</div>
    </div>


    <div class="clearfix">
        <hr/>
    </div>

    <%
        if (request.getAttribute("listaProducto") != null) {
            List<ProductoDTO> listaProducto = (List<ProductoDTO>) request.getAttribute("listaProducto");

            for (ProductoDTO producto : listaProducto) {
    %>

    <div style="display: flex; align-items: center; margin-top: 6px; gap: 10px;">
        <div style="flex: 1; text-align: left;">
            <%= producto.getIdProd() %>
        </div>
        <div style="flex: 1; text-align: left;">
            <%= producto.getIdCat() %>
        </div>
        <div style="flex: 1; text-align: left;">
            <%= producto.getNombre() %>
        </div>
        <div style="flex: 1; text-align: left;">
            <%= producto.getNombreCategoria() %>
        </div>
        <div style="flex: 1; text-align: left;">
            <%= producto.getPrecio() %>
        </div>
        <div style="flex: 1; text-align: left;">
            <%= producto.getStock() %>
        </div>

        <div style="flex: 1; text-align: left;">
            <div style="display: flex; gap: 5px;">
                <form action="${pageContext.request.contextPath}/recuperacion/producto/<%= producto.getIdProd() %>"
                      style="display: inline;">
                    <input type="submit" value="Ver Detalle"/>
                </form>

                <form action="${pageContext.request.contextPath}/recuperacion/producto/editar/<%= producto.getIdProd() %>"
                      style="display: inline;">
                    <input type="submit" value="Editar"/>
                </form>
                <form action="${pageContext.request.contextPath}/recuperacion/producto/borrar/" method="post"
                      style="display: inline;">
                    <input type="hidden" name="__method__" value="delete"/>
                    <input type="hidden" name="idprod" value="<%= producto.getIdProd() %>"/>
                    <input type="submit" value="Eliminar"/>
                </form>
            </div>
        </div>
    </div>

    <%
        }
    } else {
    %>
    No hay registros de productos
    <% } %>

    <div>
        <form action="${pageContext.request.contextPath}/recuperacion/producto/" method="get"
              style="display: inline-block;">
            <div class="input-group">
                <input type="number" name="search" class="form-control" placeholder="Buscar por stock"
                       value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">
                <button class="btn btn-primary" type="submit">Buscar</button>
            </div>
        </form>

        <form method="get" action="${pageContext.request.contextPath}/recuperacion/producto/">
            <fieldset>
                <legend>Filtrar por precio</legend>
                <input type="number" name="menor" id="menor" placeholder="Min">
                <input type="number" name="mayor" id="mayor" placeholder="Max">

                <button type="submit" id="botonFinal">Aplicar</button>
            </fieldset>
        </form>
    </div>

    <div>

    </div>

</div>

</body>
</html>
