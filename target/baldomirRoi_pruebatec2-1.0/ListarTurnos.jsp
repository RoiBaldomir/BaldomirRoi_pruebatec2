<%-- 
    Document   : ListarTurnos
    Author     : Roi Baldomir
--%>

<%@page import="java.util.List"%>
<%@page import="com.pruebatecnica.baldomirroi_pruebatec2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de turnos</title>
        <!-- Estilos de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid d-flex justify-content-center pt-4 bg-dark">
            <h1 class="text-light">Aplicación turnos</h1>
        </div>
        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid justify-content-center">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="index.jsp">Página principal</a>
                </li>
               <li class="nav-item">
                  <a class="nav-link" href="GestionTurnos.jsp">Gestión de turnos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="ListarTurnos.jsp">Listado de turnos</a>
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
        
        <div class="container mt-5"> 
            <h2>Listado de turnos por fecha</h2>
            <form action="turnoSV" method="get">
                <div class="form-group mt-4">
                    <label for="filtroFecha">Fecha:</label>
                    <input type="date" class="form-control" id="filtroFecha" name="filtroFecha" required>
                </div>
                
                <button type="submit" class="btn btn-primary mt-4">Ver listado</button>
            </form>
        </div>
        
        <!-- Mostrar la tabla del listado de turnos -->
        <div class="results-table container mt-4 mb-5">
            <% if (request.getAttribute("turnos") != null) { %>     
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nº turno</th>
                            <th>Fecha</th>
                            <th>Descripción</th>
                            <th>Ciudadano</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) { %>
                            <tr>
                                <td><%= turno.getNumeroTurno() %></td>
                                <td><%= turno.getFecha()%></td>
                                <td><%= turno.getDescripcionTramite()%></td>
                                <td><%= turno.getCiudadanoSolicitante()%></td>
                                    <% if (turno.isEstadoTurno() == false) { %>
                                        <td>En espera</td>
                                    <% }else { %>
                                        <td>Ya atendido</td>
                                    <% } %>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <% } %>
        </div>
        
        
        <!-- JS de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
