<%@ page import="org.iesbelen.model.Categoria" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17/01/2025
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Categorias</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="form-container">
        <h1 class="text-center mb-4">Editar Usuario</h1>
        <form action="${pageContext.request.contextPath}/recuperacion/categoria/editar/" method="post">
            <input type="hidden" name="__method__" value="put"/>

            <%
                Optional<Categoria> optCat = (Optional<Categoria>) request.getAttribute("nombre");
                if (optCat != null && optCat.isPresent()) {
            %>

            <div class="mb-3">
                <label for="idcat" class="form-label">ID Categoria</label>
                <input type="text" class="form-control" id="idcat" name="idcat" value="<%= optCat.get().getIdcat() %>"
                       readonly>
            </div>
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre"
                       value="<%= optCat.get().getNombre() %>">
            </div>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-custom-yellow">Guardar</button>
            </div>

            <% } else {
                response.sendRedirect("categoria/");
            } %>
        </form>
    </div>
</div>

</body>
</html>
