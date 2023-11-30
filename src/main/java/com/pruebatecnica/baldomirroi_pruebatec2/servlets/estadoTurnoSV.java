
package com.pruebatecnica.baldomirroi_pruebatec2.servlets;

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
@WebServlet(name = "estadoTurnoSV", urlPatterns = {"/estadoTurnoSV"})
public class estadoTurnoSV extends HttpServlet {
    
    // Llamada a la controladora de la lógica para trabajar con la BD
    Controladora control = new Controladora();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet estadoTurnoSV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet estadoTurnoSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String estadoTurno = request.getParameter("estadoTurno");

        // Se convierte a LocalDate la fecha introducida
        LocalDate fechaFormateada = LocalDate.parse(filtroFecha);

        //Se trae la lista de turnos de la BD pasando la fecha formateada como parámetro para filtrar los turnos
        if (estadoTurno.equalsIgnoreCase("Ya atendidos")) {
            boolean turno = true;
            List<Turno> listaTurnos = control.traerTurnos(fechaFormateada, turno);
            // Se establecen los resultados en la solicitud para que se muestren en el sitio
            request.setAttribute("estadoTurnos", listaTurnos);
        }else if(estadoTurno.equalsIgnoreCase("En espera")) {
            boolean turno = false;
            List<Turno> listaTurnos = control.traerTurnos(fechaFormateada, turno);
            // Se establecen los resultados en la solicitud para que se muestren en el sitio
            request.setAttribute("estadoTurnos", listaTurnos);
        }

        // Se redirige al usuario a la página correspondiente para ver el resultado
        request.getRequestDispatcher("FiltrarTurnos.jsp").forward(request, response);
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
        
        // Se recibe la id del turno a cambiar el estado
        long idTurno = Long.parseLong(request.getParameter("cambiarEstado"));
        
        // Se trae de la BD el turno correspondiente
        Turno turno = control.traerTurno(idTurno);
        
        // Se cambia el valor del turno
        if (!turno.isEstadoTurno()) {
            turno.setEstadoTurno(true);
        }else {
            turno.setEstadoTurno(false);
        }
        
        // Se persiste el turno en la BD
        control.editarTurno(turno);
        
        // Se redirige al usuario a la página correspondiente para ver el resultado
        request.getRequestDispatcher("FiltrarTurnos.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Permite la gestión de los estados de los turnos.";
    }// </editor-fold>

}
