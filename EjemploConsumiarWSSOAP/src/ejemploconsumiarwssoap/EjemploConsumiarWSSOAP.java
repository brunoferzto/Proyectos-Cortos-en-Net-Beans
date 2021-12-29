/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploconsumiarwssoap;

import java.util.List;
import servicios.Producto;
import servicios.ServicioProductos;
import servicios.ServicioProductos_Service;

/**
 *
 * @author Bruno
 */
public class EjemploConsumiarWSSOAP {

    private static ServicioProductos_Service servicio; 
    private static ServicioProductos puerto;
    
    private static Producto producto;
    private static Producto producoBuscar; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        servicio = new ServicioProductos_Service();
        puerto = servicio.getServicioProductosPort();
        // TODO code application logic here
        listar(); 
    }
    
    private static void listar()
    {
        try {
            List<Producto> productos = puerto.listar();
    
        for(Producto p : productos){
            System.out.println("Codigo: " + p.getCodigo() + ", Descripcion: " + p.getDescripcion() + ", Precio : " + p.getPrecio());
        } 
        } catch (Exception e) {
            System.out.println("No se pudo listar los productos");
        }
        
    }
    
    
}
