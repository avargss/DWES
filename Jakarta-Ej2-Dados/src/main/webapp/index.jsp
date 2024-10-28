<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Comparator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Ordenar dados</h1>
<p>Actualice la página para ver una nueva tirada</p>
<p>Tirada de 7 dados desordenados:</p>
<%

    String dadosSVG[] = {
            "1.svg",
            "2.svg",
            "3.svg",
            "4.svg",
            "5.svg",
            "6.svg",
    };

    /* Creo un array en donde guardo los svg de los dados para usarlos más tarde. Luego hago otro array donde
    * voy a seleccionar los dados que voy a mostrar desordenados, y otro array numérico donde voy a almacenar
    * los valores numéricos de los dados.
    *
    * Hago un bucle for en el que creo un índice aleatorio para que los dados se impriman sin orden y parseo
    * el array de los svg a Integer en un nuevo atributo valoresDados, en los que se guardarán los mismos valores
    * reemplazando los .svg con "" para que estén vacíos y solo se guarde el número.
    *
    * Creo un nuevo array valoresOrdenasos en donde clono el array valoresDados y lo ordeno.
    *
    * Ahora creo un nuevo array dadosOrdenados y le indico que tendrá 7 posiciones. Después hago un bucle for que
    * se repetirá 7 veces, y asigno el array clonado a un nuevo array dadosOrdenados en el que al final le añado
    * + ".svg"
    *
    * Ahora uso un forEach para imprimir por pantalla los dados desordenados, y luego hago lo mismo con los ordenados.*/

    String[] dadosDesordenados = new String[7];
    Integer[] valoresDados = new Integer[7]; //Array para almacenar los valores numéricos de los dados

    for (int i = 0; i < 7; i++) {
        int indiceAleatorio = (int) (Math.random() * dadosSVG.length);
        dadosDesordenados[i] = dadosSVG[indiceAleatorio];
        valoresDados[i] = Integer.parseInt(dadosSVG[indiceAleatorio].replace(".svg", ""));
    }
    // Clonar y ordenar el array de valores para obtener el orden ascendente
    Integer[] valoresOrdenados = valoresDados.clone();
    Arrays.sort(valoresOrdenados);

    // Crear un nuevo array para los SVG ordenados
    String[] dadosOrdenados = new String[7];
    for (int i = 0; i < 7; i++) {
        dadosOrdenados[i] = valoresOrdenados[i] + ".svg";
    }

    for (String dadoDes : dadosDesordenados) {
%>
<img src="image/<%= dadoDes %>" alt="">
<%
    }
%>
<p>Dados ordenados:</p>
<%
    // AQUÍ VAN LOS DADOS ORDENADOS
    for (String dadoOrd : dadosOrdenados) {
%>
<img src="image/<%= dadoOrd %>" alt="">
<%
    }
%>

</body>
</html>