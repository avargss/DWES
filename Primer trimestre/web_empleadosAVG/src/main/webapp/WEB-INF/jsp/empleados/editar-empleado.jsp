<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Empleado" %>
<%@page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    <style>
        .clearfix::after {
            content: "";
            display: block;
            clear: both;
        }

    </style>
</head>
<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <form action="${pageContext.request.contextPath}/gestion/empleado/editar/" method="get">
        <input type="hidden" name="__method__" value="put"/>
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Editar Empleado</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Guardar"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <% Optional<Empleado> optEmp = (Optional<Empleado>) request.getAttribute("empleado");
            if (optEmp.isPresent()) {
        %>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Código</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="codigo" value="<%= optEmp.get().getCodigo() %>" readonly="readonly"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>NIF</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nif" value="<%= optEmp.get().getNif() %>"/>
            </div>
            <div style="float: left;width: 50%">
                <label>Nombre</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre" value="<%= optEmp.get().getNombre() %>"/>
            </div>
            <div style="float: left;width: 50%">
                <label>Apellido 1</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="apellido1" value="<%= optEmp.get().getApellido1() %>"/>
            </div>
            <div style="float: left;width: 50%">
                <label>Apellido 2</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="apellido2" value="<%= optEmp.get().getApellido2() %>"/>
            </div>
            <div style="float: left;width: 50%">
                <label>CodigoDep</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="codigodep" value="<%= optEmp.get().getCodigo_departamento() %>" readonly="readonly"/>
            </div>
        </div>

        <% } else { %>

        request.sendRedirect("empleado/");

        <% } %>
    </form>
</div>

</body>
</html>