/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
public class FormularioConPaises extends HttpServlet {
    
protected ArrayList<String> paises;
protected boolean incluirItemPaisNulo;

    //SE EJECUTA SOLO UNA VEZ AL INICIALIZAR EL SERVLET.
    @Override
    public void init() throws ServletException {
        try {
             paises =  new ArrayList();
       
       paises.add("Argentina");
       paises.add("Brasil");
       paises.add("Paraguay");
       paises.add("Uruguay");
       paises.add("Venezuela");
       
       //leo los parameros de inicio del servlet (web.xml)
       ServletConfig configuracion = getServletConfig(); 
       incluirItemPaisNulo = configuracion.getInitParameter("IncluirItemPaisNulo").equals("S");
        } catch (Exception e) 
        {
            throw new UnavailableException("No se pudo Inicializar el Servlet");
        }
    
      
    }
    
        
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
            out.println("<title>Formulario Con Paises</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            
            out.println("<p>Pa??s: ");
            out.println("<select name=  \"pais\">");
            
        if(incluirItemPaisNulo)
            out.println("<option value= \"\">Seleccione un pa??s...</option>");
            
            String pais = request.getParameter("pais");
            for(String p : paises)
            {
                out.println("<option" + (p.equals(pais) ? " selected = \"selected\"" : "") + ">"+p+" </option>");
            }
            
            out.println("</select>");
            out.println("<input type = \"submit\" value = \"Enviar\"/> </p>");
                       
            out.println("</form>");   
            
            if(pais!= null && !"".equals(pais))
                out.println("<p> Pa??s seleccionado: " + pais + "</p`>");

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
