<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%
    String animales[] = {
            "ballena.svg", "caballito-mar.svg", "camello.svg", "cebra.svg", "elefante.svg",
            "hipopotamo.svg", "jirafa.svg", "leon.svg", "leopardo.svg", "medusa.svg",
            "mono.svg", "oso.svg", "oso-blanco.svg", "pajaro.svg", "pinguino.svg",
            "rinoceronte.svg", "serpiente.svg", "tigre.svg", "tortuga.svg", "tortuga-marina.svg"
    };

    String nombresAnimales[] = {
            "ballena", "caballito-mar", "camello", "cebra", "elefante",
            "hipopotamo", "jirafa", "leon", "leopardo", "medusa",
            "mono", "oso", "oso-blanco", "pajaro", "pinguino",
            "rinoceronte", "serpiente", "tigre", "tortuga", "tortuga-marina"
    };

    int indiceAleatorio = (int) (Math.random() * animales.length);

    String animalSVG1 = animales[indiceAleatorio];
    String nombreAnimal1 = nombresAnimales[indiceAleatorio];

%>

<h1>Animal Aleatorio</h1>

<!--Mostrar el nombre y la imagen del animal -->

<h2><strong>Nombre:</strong> <%= nombreAnimal1 %></h2>
<img src="images/<%= animalSVG1 %>" alt="<%= nombreAnimal1 %>">

</body>
</html>