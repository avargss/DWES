<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17/01/2025
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="form-container">
        <h1 class="text-center mb-4">Crear Producto</h1>
        <form action="${pageContext.request.contextPath}/recuperacion/producto/crear/" method="post">

            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>

            <div style="margin-top: 6px;" class="clearfix">
                <div style="float: left;width: 50%">
                    ID Categoria
                </div>
                <div style="float: none;width: auto;overflow: hidden;">
                    <select name="idcat" id="idcat">
                        <% if (request.getAttribute("listaCategoria") != null) {
                            List<Categoria> ca = (List<Categoria>) request.getAttribute("listaCategoria");
                            for (Categoria cat : ca) {

                        %>
                        <option value="<%=cat.getIdcat()%>">
                            <%=cat.getNombre()%>
                        </option>
                        <%
                            }
                        } else {
                        %>
                        No hay registros de categoria
                        <% } %>
                    </select>
                </div>
            </div>

            <%--            <div class="mb-3">--%>
            <%--                <label for="idcat" class="form-label">Categoría</label>--%>
            <%--                <select class="form-select" id="idcat" name="idcat" required>--%>
            <%--                    <option value="" selected disabled>Seleccione Categoría</option>--%>
            <%--                    <option value="1">LINEA BLANCA</option>--%>
            <%--                    <option value="2">MENAJE</option>--%>
            <%--                    <option value="3">CAMA</option>--%>
            <%--                    <option value="4">MUEBLES</option>--%>
            <%--                    <option value="5">ROPA DE DAMAS--%>
            <%--                    </option>--%>
            <%--                    <option value="6">ROPA DE CABALLEROS--%>
            <%--                    </option>--%>
            <%--                    <option value="7">ROPA DE SEÑORITAS--%>
            <%--                    </option>--%>
            <%--                    <option value="8">ROPA DE NIÑOS--%>
            <%--                    </option>--%>
            <%--                    <option value="9">ROPA DE NIÑAS--%>
            <%--                    </option>--%>
            <%--                    <option value="10">ELECTRODOMESTICOS--%>
            <%--                    </option>--%>
            <%--                    <option value="11">COMPUTO--%>
            <%--                    </option>--%>
            <%--                </select>--%>
            <%--            </div>--%>

            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="number" class="form-control" id="precio" name="precio" required>
            </div>

            <div class="mb-3">
                <label for="stock" class="form-label">Stock</label>
                <input type="number" class="form-control" id="stock" name="stock" required>
            </div>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-custom-yellow">Crear</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
