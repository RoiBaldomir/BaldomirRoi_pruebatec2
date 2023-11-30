
package com.pruebatecnica.baldomirroi_pruebatec2.servlets;

import com.pruebatecnica.baldomirroi_pruebatec2.logica.Ciudadano;
import com.pruebatecnica.baldomirroi_pruebatec2.logica.Controladora;
import com.pruebatecnica.baldomirroi_pruebatec2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roi Baldomir
 */
@WebServlet(name = "turnoSV", urlPatterns = {"/turnoSV"})
public class turnoSV extends HttpServlet {
    
    // Llamada a la controladora de la lógica para trabajar con la BD
    Controladora control = new Controladora();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param paginaError
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String paginaError)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Páginas de error según el error ocurrido
            switch (paginaError) {
                case "turno":
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Turno ya existente</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<p>El turno con el valor introducido ya existe. Introduzca otro valor, por favor.</p>");
                    out.println("<a href='AgregarTurno.jsp'><button>Volver a la página anterior</button></a>");
                    out.println("</body>");
                    out.println("</html>");
                    break;
                case "ciudadano":
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Ciudadano no existente</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<p>El ciudadano con la id introducida no existe. Introduzca otra id, por favor.</p>");
                    out.println("<a href='AgregarTurno.jsp'><button>Volver a la página anterior</button></a>");
                    out.println("</body>");
                    out.println("</html>");
                    break;
            }           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Se trae la fecha de filtrado introducida por el usuario
        String filtroFecha = request.getParameter("filtroFecha");

        // Se convierte a LocalDate la fecha introducida
        LocalDate fechaFormateada = LocalDate.parse(filtroFecha);

        //Se trae la lista de turnos de la BD pasando la fecha formateada como parámetro para filtrar los turnos
        List<Turno> listaTurnos = control.traerTurnos(fechaFormateada);

        // Se establecen los resultados en la solicitud para que se muestren en el sitio
        request.setAttribute("turnos", listaTurnos);

        // Se redirige al usuario a la página correspondiente para ver el resultado
        request.getRequestDispatcher("ListarTurnos.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Se traen los datos del turno introducidos por el usuario
        long numTurno = Long.parseLong(request.getParameter("numTurno"));
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        long idCiudadano = Long.parseLong(request.getParameter("id"));
        
        Turno comprobarTurno = control.traerTurno(numTurno);
        
        // Si la id del turno introducido por el usuario coincide con uno existente en la BD se dirigirá al usuario a un página de error
        if (comprobarTurno != null) {
            processRequest(request, response, "turno");
        }
        
        // Se trae el ciudadano correspondiente a la id introducida de la BD
        Ciudadano ciudadano = control.traerCiudadano(idCiudadano);
        
        // Si el ciudadano no se encuentra en la BD se dirigirá al usuario a un página de error
        if (ciudadano == null) {
            processRequest(request, response, "ciudadano");
        }else {
            // Se convierte a LocalDate la fecha introducida
            LocalDate fechaFormateada = LocalDate.parse(fecha);

            // Se crea un objeto turno
            Turno turno = new Turno(numTurno, fechaFormateada, descripcion, ciudadano);

            // Se persiste el turno en la BD
            control.crearTurno(turno);

            // Se redirige al usuario a la página correspondiente una vez persistido el turno en la BD
            request.getRequestDispatcher("GestionTurnos.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Permite la creación y listado de los turnos.";
    }// </editor-fold>

}
