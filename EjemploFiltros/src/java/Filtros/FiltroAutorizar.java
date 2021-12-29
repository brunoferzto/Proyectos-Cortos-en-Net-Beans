/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import java.io.IOException;
import static java.lang.System.out;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
public class FiltroAutorizar implements Filter {

    protected String usuario;
    protected String contrasena;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
        usuario = filterConfig.getInitParameter("usuario");
        contrasena = filterConfig.getInitParameter("contrasena");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
           if(request instanceof HttpServletRequest && response instanceof HttpServletResponse)
           {
               //hay que castear para obtener el httpservletrequest para obtener el get session. 
               HttpSession sesion = ((HttpServletRequest)request).getSession();
               
               //Logueamos el Usuario
               if(sesion.getAttribute("usuario") == null && usuario.equals(request.getParameter("usuario")) 
                            && contrasena.equals(request.getParameter("contrasena")))
               {                  
                 sesion.setAttribute("usuario", usuario);
               }
               
               // si esta en la sesion el atributo usuario
               if(sesion.getAttribute("usuario") != null) 
               {
                   // continua su camino hacia el otro filter o hacia el servlet donde se produjo
                   chain.doFilter(request, response);
               } 
               
               // no está logueado
               else
               {
                   System.out.println("LOG [" + new Date() + "] >Intento de acceso no autorizado.");
               
               ((HttpServletResponse)response).sendRedirect("/EjemploFiltros/AccesoNoAutorizado");
               
               }
           }
           else 
           {
               chain.doFilter(request, response);
           }                 
    }

    @Override
    public void destroy()
    {
    }
    
}
