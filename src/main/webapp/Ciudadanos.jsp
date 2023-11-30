<%-- 
    Document   : Ciudadanos
    Author     : Roi Baldomir
--%>

<%@page import="java.util.List"%>
<%@page import="com.pruebatecnica.baldomirroi_pruebatec2.logica.Ciudadano"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de ciudadanos</title>
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
                  <a class="nav-link" href="ListarTurnos.jsp">Listado de turnos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="FiltrarTurnos.jsp">Filtrado de turnos</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" href="Ciudadanos.jsp">Ciudadanos</a>
                </li>
              </ul>
            </div>
        </nav>
        
        <div class="container mt-5">
            <h2>Agregar ciudadano</h2>
            <form action="ciudadanoSV" method="post">
                <div class="form-group mt-4">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>
                <div class="form-group mt-4">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>
                </div>
                <div class="form-group mt-4">
                    <label for="dni">DNI:</label>
                    <input type="text" class="form-control" id="dni" name="dni" required>
                </div>
                <div class="form-group mt-4">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" required>
                </div>
                    
                <button type="submit" class="btn btn-success mt-4">Añadir ciudadano</button>
            </form>
        </div>
        
        <div class="container mt-5"> 
            <h2>Listado de ciudadanos</h2>
            <form action="ciudadanoSV" method="get">
                
                <button type="submit" class="btn btn-primary mt-4">Ver listado</button>
            </form>
        </div>
        
        <!-- Mostrar la tabla del listado de ciudadanos -->
        <div class="results-table container mt-4 mb-5">
            <% if (request.getAttribute("ciudadanos") != null) { %>     
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Dni</th>
                            <th>Teléfono</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Ciudadano ciudadano : (List<Ciudadano>) request.getAttribute("ciudadanos")) { %>
                            <tr>
                                <td><%=ciudadano.getId() %></td>
                                <td><%=ciudadano.getNombre() %></td>
                                <td><%=ciudadano.getApellido() %></td>
                                <td><%=ciudadano.getDni() %></td>
                                <td><%=ciudadano.getTelefono() %></td>
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
