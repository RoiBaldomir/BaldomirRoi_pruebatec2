
package com.pruebatecnica.baldomirroi_pruebatec2.servlets;

import com.pruebatecnica.baldomirroi_pruebatec2.logica.Controladora;
import com.pruebatecnica.baldomirroi_pruebatec2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roi Baldomir
 */
@WebServlet(name = "borrarTurnoSV", urlPatterns = {"/borrarTurnoSV"})
public class borrarTurnoSV extends HttpServlet {
    
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
            out.println("<title>Turno no existente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>El turno con el valor introducido no existe en la BD. Introduzca otro valor, por favor.</p>");
            out.println("<a href='AgregarTurno.jsp'><button>Volver a la página anterior</button></a>");
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
        
        // Se trae el id turno introducido por el usuario
        long numTurno = Long.parseLong(request.getParameter("numTurno"));
        
        // Se comprueba si existe un turno con esa id en la BD
        Turno comprobarTurno = control.traerTurno(numTurno);
        
        // Si existe, se elimina el turno de la BD, si no, se dirigirá al usuario a una página de error
        if (comprobarTurno != null) {
            control.borrarTurno(numTurno);
            
            // Se redirige al usuario a la página correspondiente una vez eliminado el turno en la BD
            request.getRequestDispatcher("GestionTurnos.jsp").forward(request, response);
        }else{
            processRequest(request, response);
        }   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Permite el borrado de los turnos";
    }// </editor-fold>

}
