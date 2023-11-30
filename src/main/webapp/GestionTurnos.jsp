<%-- 
    Document   : AgregarTurno
    Author     : Roi Baldomir
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de turnos</title>
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
                  <a class="nav-link active" href="GestionTurnos.jsp">Gestión de turnos</a>
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
        
        <div class="container mt-5">
            <h2>Agregar turno</h2>
            <form action="turnoSV" method="post">
                <div class="form-group mt-4">
                    <label for="numTurno">Número turno:</label>
                    <input type="number" class="form-control" id="numTurno" name="numTurno" required>
                </div>
                <div class="form-group mt-4">
                    <label for="fecha">Fecha:</label>
                    <input type="date" class="form-control" id="fecha" name="fecha" required>
                </div>
                <div class="form-group mt-4">
                    <label for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                </div>
                <div class="form-group mt-4">
                    <label for="id">ID Ciudadano:</label>
                    <input type="number" class="form-control" id="id" name="id" required>
                </div>
                    
                <button type="submit" class="btn btn-success mt-4">Añadir turno</button>
            </form>
        </div>
        
        <div class="container mt-5">
            <h2>Eliminar turno</h2>
            <form action="borrarTurnoSV" method="post">
                <div class="form-group mt-4">
                    <label for="numTurno">Número turno:</label>
                    <input type="number" class="form-control" id="numTurno" name="numTurno" required>
                </div>
                
                <button type="submit" class="btn btn-danger mt-4">Eliminar turno</button>
            </form>
        </div>
        
        
        <!-- JS de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
