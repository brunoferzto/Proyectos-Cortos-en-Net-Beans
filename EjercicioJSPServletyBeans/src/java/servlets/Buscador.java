/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
public class Buscador extends HttpServlet {
    
    @Override
    public void init() throws ServletException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            throw new UnavailableException("No se pudo inicializar el servlet Buscador");
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
      Connection conection = null; 
      PreparedStatement consulta = null; 
      ResultSet resultado = null; 
        try {
            int codigo = 0;
            
            try {
                codigo = Integer.parseInt(request.getParameter("codigo"));
            } catch (Exception e) {
                throw new ServletException("El codigo no es valido");
            }
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjercicioJSPServletyBeans", "root", "Rodo1125");
            consulta = conection.prepareStatement("SELECT * FROM Producto WhERE Codigo = ?;");
            consulta.setInt(1, codigo);
            
            resultado = consulta.executeQuery();
            
            if(resultado.next()) 
            {
            String descripcion = resultado.getString("Descripcion");
            double costo = resultado.getDouble("Costo");
            int stock = resultado.getInt("Stock");
                        
                        
            Producto producto = new Producto (codigo,descripcion,costo,stock);
            request.setAttribute("producto", producto);
            
            RequestDispatcher rd = request.getRequestDispatcher("MostrarProducto.jsp");
            
            if(rd != null) rd.forward(request, response);
            
            }
            else  {
            
                response.sendError(404);
            }
            
        } catch (Exception e) {
           throw new ServletException("Error en la BD"); 
        }
         finally 
        {
            try {
                if(resultado != null)
                    resultado.close(); 
                if(consulta != null)
                    consulta.close(); 
                if(conection != null) 
                    conection.close(); 
                
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos");
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
