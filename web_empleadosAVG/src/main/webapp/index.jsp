<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        #contenedor {
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>

</head>
<body>

<main>
    <section>
        <div class="d-grid gap-2" style="margin: 100px 100px 210px 100px" id="contenedor">
            <a class="btn btn-primary btn-lg"
               href="<%=application.getContextPath()%>/gestion/departamento/">DEPARTAMENTOS</a>
            <a class="btn btn-success btn-lg" href="<%=application.getContextPath()%>/gestion/empleado">EMPLEADOS</a>
        </div>
    </section>
</main>


</body>
</html>