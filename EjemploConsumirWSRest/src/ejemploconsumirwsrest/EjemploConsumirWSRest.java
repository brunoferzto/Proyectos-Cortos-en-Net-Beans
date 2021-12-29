/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploconsumirwsrest;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sistema.Producto;

/**
 *
 * @author Bruno
 */
public class EjemploConsumirWSRest {
    
    private static Producto producto; 
    private static  Producto productoBuscado; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println();
        // TODO code application logic here
       
        listar();
        
        buscar();
        
        agregar();

        listar();
        
        modificar();
        
        listar();
        
        eliminar();
        
        listar();

    }
    
    private static void listar(){
        try {
            Client cliente = ClientBuilder.newClient();
            WebTarget objetivo = cliente.target("http://localhost:8084/EjemploWSREST/rest/productos");
            Response respuesta = objetivo.request(MediaType.APPLICATION_JSON).get();
            
            if(respuesta.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()){
               MensajeErrorApiRest mensajeError = respuesta.readEntity(MensajeErrorApiRest.class);
                       
                System.out.println(mensajeError.getMensajeAmigable());
 
            }else{
                List<Producto> productos = respuesta.readEntity(new GenericType<List<Producto>>(){});
                for(Producto p: productos){
                    System.out.println("Codigo: " + p.getCodigo() + ", Descripcion: " + p.getDescripcion() + ", Precio: " + p.getPrecio());
                }
            }
        } catch (Exception e) {
            System.out.println("Error, no se pudo listar los productos");
        }
        System.out.println();
    }
    
    private static void buscar(){
        try {
            Client cliente = ClientBuilder.newClient();
            WebTarget objetivo = cliente.target("http://localhost:8084/EjemploWSREST/rest/productos/4");
            Response respuesta = objetivo.request(MediaType.APPLICATION_JSON).get();
            
            if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
                System.out.println("NO SE ENCONTRÓ PRODUCTO");
            }
            else if(respuesta.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()){
               MensajeErrorApiRest mensajeError = respuesta.readEntity(MensajeErrorApiRest.class);
                       
                System.out.println(mensajeError.getMensajeAmigable());
 
            }else
            {
                productoBuscado = respuesta.readEntity(Producto.class);
                System.out.println("Datos del Producto :");
                System.out.println("Codigo: " + productoBuscado.getCodigo() + ", Descripcion: " + productoBuscado.getDescripcion()
                        + ", Precio: " + productoBuscado.getPrecio());

                
            }
        } catch (Exception e) {
            System.out.println("Error, no se pudo buscar el producto");
        }
        System.out.println();
    }
     
    private static void agregar(){
        
        producto = new Producto();
        producto.setCodigo(4);
        producto.setDescripcion("Producto 4");
        producto.setPrecio(400);
               
        try {
            Client cliente = ClientBuilder.newClient();
            WebTarget objetivo = cliente.target("http://localhost:8084/EjemploWSREST/rest/productos/");
            Invocation.Builder constructorSolicitud = objetivo.request(MediaType.APPLICATION_JSON);
            Response respuesta = constructorSolicitud.post(Entity.entity(producto, MediaType.APPLICATION_JSON));
            
            
            if(respuesta.getStatus() == Response.Status.CONFLICT.getStatusCode()){
                System.out.println("El producto ya existe");
            }
            else if(respuesta.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()){
               MensajeErrorApiRest mensajeError = respuesta.readEntity(MensajeErrorApiRest.class);
                       
                System.out.println(mensajeError.getMensajeAmigable());
 
            }else
            {
                System.out.println("Se agregó el Producto");

                
            }
        } catch (Exception e) {
            System.out.println("Error, no se pudo agregar el producto");
        }
        System.out.println();
    }
    
    private static void modificar(){
       
        producto.setDescripcion("Otro Producto 4");
   
               
        try {
            Client cliente = ClientBuilder.newClient();
            WebTarget objetivo = cliente.target("http://localhost:8084/EjemploWSREST/rest/productos/");
            Invocation.Builder constructorSolicitud = objetivo.request(MediaType.APPLICATION_JSON);
            Response respuesta = constructorSolicitud.put(Entity.entity(producto, MediaType.APPLICATION_JSON));
            
            
            if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
                System.out.println("El producto no existe");
            }
            else if(respuesta.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()){
               MensajeErrorApiRest mensajeError = respuesta.readEntity(MensajeErrorApiRest.class);
                       
                System.out.println(mensajeError.getMensajeAmigable());
 
            }else
            {
                System.out.println("Se Modificó el Producto");

                
            }
        } catch (Exception e) {
            System.out.println("Error, no se pudo modificar el producto");
        }
        System.out.println();
    }
     
    private static void eliminar(){
                     
        try {
            Client cliente = ClientBuilder.newClient();
            WebTarget objetivo = cliente.target("http://localhost:8084/EjemploWSREST/rest/productos/4");
            Invocation.Builder constructorSolicitud = objetivo.request(MediaType.APPLICATION_JSON);
            Response respuesta = constructorSolicitud.delete();
            
            
            if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
                System.out.println("El producto no existe");
            }
            else if(respuesta.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()){
               MensajeErrorApiRest mensajeError = respuesta.readEntity(MensajeErrorApiRest.class);
                       
                System.out.println(mensajeError.getMensajeAmigable());
 
            }else
            {
                System.out.println("Se Eliminó el Producto");

                
            }
        } catch (Exception e) {
            System.out.println("Error, no se pudo eliminar el producto");
        }
        System.out.println();
    }
     
}
