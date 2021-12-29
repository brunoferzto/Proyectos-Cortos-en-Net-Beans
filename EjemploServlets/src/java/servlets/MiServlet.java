/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
public class MiServlet extends HttpServlet // <-- Hace la clase un Servlets y contiene los
{                           // y contiene metodos para Web
    
    protected void procesarSolicitud(HttpServletRequest request,HttpServletResponse response )
       throws ServletException, IOException   
    {
        //Manejar el pedido y generamos respuesta
        
        // seteamos que tipo de contenido vamos a enviar en la respuesta mediante String
        response.setContentType("text/html;charse=UTF-8"); // <- En la respuesta va codigo html
        
        /// escribimos el html en el objeto response
        PrintWriter salida = response.getWriter();
        try {
            
            salida.println("<!DOCTYPE html>");
            salida.println("<html>");
            salida.println("<head>");
            salida.println("<title>Mi Servlet </title>");
            salida.println("</head>");
            salida.println("<body>");
            salida.println("<p>¡Mi Servlet funciona bien!</p>");
            salida.println("</body>");
            salida.println("</html>");

            
        } finally  {
            salida.close();
        }
   
        
    }

    //redefinimos los metodos para que hagan lo que queramos
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        procesarSolicitud(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        procesarSolicitud(req,resp);
    }
    
    
    
            
    
    
}
