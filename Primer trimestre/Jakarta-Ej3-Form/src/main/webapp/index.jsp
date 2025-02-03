<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html style="background-color: darkgrey">
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<form action="form" method="post" style="background-color: #f0f0ff; padding: 20px; width: 400px; font-family: Arial, sans-serif;">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" style="margin-right: 20px; width: 100px;"><br><br>

    <label for="apellidos">Apellidos:</label>
    <input type="text" id="apellidos" name="apellidos" style="margin-right: 20px; width: 150px;"><br><br>

    <label for="edad">Edad:</label>
    <select id="edad" name="edad" style="width: 60px;">
        <option value="...">...</option>
        <option value="18-25">18-25</option>
        <option value="26-35">26-35</option>
        <option value="36-45">36-45</option>
        <option value="46-60">46-60</option>
        <option value="60+">60+</option>
    </select><br><br>

    <label for="peso">Peso:</label>
    <input type="number" id="peso" name="peso" style="width: 60px;">
    <label>kg</label><br><br>

    <label>Sexo:</label>
    <input type="radio" id="hombre" name="sexo" value="Hombre">
    <label for="hombre">Hombre</label>
    <input type="radio" id="mujer" name="sexo" value="Mujer">
    <label for="mujer">Mujer</label><br><br>

    <label>Estado Civil:</label>
    <input type="radio" id="soltero" name="estado_civil" value="soltero">
    <label for="soltero">Soltero</label>
    <input type="radio" id="casado" name="estado_civil" value="casado">
    <label for="casado">Casado</label>
    <input type="radio" id="otro" name="estado_civil" value="otro">
    <label for="otro">Otro</label><br><br>

    <label>Aficiones:</label><br>
    <input type="checkbox" id="cine" name="aficiones" value="cine">
    <label for="cine">Cine</label>
    <input type="checkbox" id="literatura" name="aficiones" value="literatura">
    <label for="literatura">Literatura</label>
    <input type="checkbox" id="tebeos" name="aficiones" value="tebeos">
    <label for="tebeos">Tebeos</label><br>

    <input type="checkbox" id="deporte" name="aficiones" value="deporte">
    <label for="deporte">Deporte</label>
    <input type="checkbox" id="musica" name="aficiones" value="musica">
    <label for="musica">Música</label>
    <input type="checkbox" id="television" name="aficiones" value="television">
    <label for="television">Televisión</label><br><br>

    <button type="submit" style="margin-right: 10px;">Enviar</button>
    <button type="reset">Borrar</button>
</form>

</body>
</html>