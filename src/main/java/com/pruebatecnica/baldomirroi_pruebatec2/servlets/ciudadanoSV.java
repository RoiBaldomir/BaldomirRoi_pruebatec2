
package com.pruebatecnica.baldomirroi_pruebatec2.servlets;

import com.pruebatecnica.baldomirroi_pruebatec2.logica.Ciudadano;
import com.pruebatecnica.baldomirroi_pruebatec2.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ciudadanoSV", urlPatterns = {"/ciudadanoSV"})
public class ciudadanoSV extends HttpServlet {
    
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
            out.println("<title>Servlet ciudadanoSV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ciudadanoSV at " + request.getContextPath() + "</h1>");
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
        
        // Se trae la lista de ciudadanos de la BD 
        List<Ciudadano> listaCiudadanos = control.traerCiudadanos();

        // Se establecen los resultados en la solicitud para que se muestren en el sitio
        request.setAttribute("ciudadanos", listaCiudadanos);

        // Se redirige al usuario a la página correspondiente para ver el resultado
        request.getRequestDispatcher("Ciudadanos.jsp").forward(request, response);
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
        
        // Se traen los datos del ciudadano introducidos por el usuario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        
        // Se crea un objeto ciudadano
        Ciudadano ciudadano = new Ciudadano(1, nombre, apellido, dni, telefono);
        
        // Se persiste el turno en la BD
        control.crearCiudadano(ciudadano);

        // Se redirige al usuario a la página correspondiente una vez persistido el turno en la BD
        request.getRequestDispatcher("Ciudadanos.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Permite la creación y listado de turnos";
    }// </editor-fold>

}
