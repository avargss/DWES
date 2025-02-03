<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 05/12/2024
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Departamento</title>
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
    <form action="${pageContext.request.contextPath}/gestion/departamento/crear" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Departamento</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Crear"/>
                </div>
            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Nombre
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Presupuesto
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input type="number" name="presupuesto"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Gastos
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input type="number" name="gastos"/>
            </div>
        </div>

    </form>
</div>

</body>
</html>