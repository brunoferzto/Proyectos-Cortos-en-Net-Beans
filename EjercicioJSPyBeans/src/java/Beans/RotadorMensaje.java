/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class RotadorMensaje implements Serializable {
    
   private List<String> mensajes;
   private int indiceActual;
   
   public String getMensaje()
   {    String mensaje; 
   
       if(mensajes.size() > 0){
          mensaje = mensajes.get(indiceActual);
           indiceActual = indiceActual < mensajes.size() - 1 ? indiceActual +1 : 0;
       }
       else{
           mensaje = "Error, No hay Mensajes para mostrar";}
       
       return mensaje;
   }
   
   public RotadorMensaje ()
   {
    mensajes = new ArrayList();
    /*
   mensajes.add("Mensaje 1");
   mensajes.add("Mensaje 2");
   mensajes.add("Mensaje 3");
   mensajes.add("Mensaje 4");
   mensajes.add("Mensaje 5");
   
   
    */
       try {
           Class.forName("com.mysql.jdbc.Driver");
                   
       } catch (Exception e) {
           System.out.println("Error al instanciar el driver de MySQL");
       }
       
       try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjercicioJSPyBeans", "root", "Rodo1125");
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("SELECT * FROM Mensajes;")){
           while(resultado.next())
           {
               mensajes.add(resultado.getString("mensaje"));
           }
           
       } catch (Exception e) {
           System.out.println("Error, Se produjo un error con la BD.");
       }

        indiceActual = 0;
   }
   
}
