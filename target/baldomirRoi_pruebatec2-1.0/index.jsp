<%-- 
    Document   : index
    Author     : Roi Baldomir
--%>

<%@page import="java.util.List"%>
<%@page import="com.pruebatecnica.baldomirroi_pruebatec2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicaci�n de gesti�n de turnos</title>
        <!-- Estilos de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid d-flex justify-content-center pt-4 bg-dark">
            <h1 class="text-light">Aplicaci�n turnos</h1>
        </div>
        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid justify-content-center">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" href="index.jsp">P�gina principal</a>
                </li>
               <li class="nav-item">
                  <a class="nav-link" href="GestionTurnos.jsp">Gesti�n de turnos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="ListarTurnos.jsp">Listado de turnos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="FiltrarTurnos.jsp">Filtrado de turnos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Ciudadanos.jsp">Ciudadanos</a>
                </li>
              </ul>
            </div>
        </nav>
        
        <div class="container mt-5 text-center">
            <h1>Bienvenid@ a la aplicaci�n de gesti�n de turnos</h1>
            <p>En el men� superior podr� encontrar las operaciones soportadas por la aplicaci�n.</p>
        </div>
        
        <!-- JS de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
