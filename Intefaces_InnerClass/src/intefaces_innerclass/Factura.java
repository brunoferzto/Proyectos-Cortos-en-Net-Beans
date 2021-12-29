/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaces_innerclass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Factura extends Documento implements Numerable, Serializable
{
    private int numero; 
    private List<LineaFactura> lineas;
    
     public List<LineaFactura> getLinea()
    {
                return new ArrayList(lineas); // Creo uno nuevo para no retornar la coleccion original (seguridad)
    }
     
   
   
   public double getTotl()
   {
       double total = 0; 
       
       for (LineaFactura lf : lineas)
       {
           total += lf.getImporte();
       }   
       return total; 
   }
   
    public Factura ()
   {
   numero = 0; 
   lineas = new ArrayList(); 
   }

   public void agregarLinea (int cantidad, int codigoProducto, String descripcion, double precioUnitario)
   {
     LineaFactura linea = new LineaFactura(cantidad, codigoProducto,descripcion,precioUnitario);
     lineas.add(linea);
     
    // lineas.sort(new ComparadorLineasFacturaxPrecioUnitario()); Para ordenar
    lineas.sort(new Comparator<LineaFactura>() // definir clase sin nombre, con interfaz
    {        
         @Override
         public int compare(LineaFactura l1, LineaFactura l2) 
         {
             return ((Integer)l1.getCodigoProducto()).compareTo(l2.getCodigoProducto());
         }
     });
    }
   
    @Override
    public  void numerar(int numero)
    {
        this.numero = numero; 
    }

    @Override
    public int leerNumero() 
    {
        return numero; 
    }
    
      ///////////////////////////////////////////////////////      
    /// Se puede ver pero no  crear instancias desde afuera
    public class LineaFactura // inner class
    {
    private int cantidad; 
    private int codigoProducto; 
    private String descripcion; 
    private double precioUnitario;

        public int getCantidad() {
            return cantidad;
        }
        
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        
        public int getCodigoProducto() {
            return codigoProducto;
        }
        
        public void setCodigoProducto(int codigoProducto) {
            this.codigoProducto = codigoProducto;
        }
        
        public String getDescripcion() {
            return descripcion;
        }
        
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        
        public double getPrecioUnitario() {
            return precioUnitario;
        }
        
        public void setPrecioUnitario(double precioUnitario) {
            this.precioUnitario = precioUnitario;
        }
        
        public double getImporte()
        {
            return getCantidad() * getPrecioUnitario();         
        }

        public LineaFactura(int cantidad, int codigoProducto, String descripcion, double precioUnitario) {
            
            setCantidad(cantidad);
            setCodigoProducto(codigoProducto);
            setDescripcion(descripcion);
            setPrecioUnitario(precioUnitario);
        }

        @Override
        public String toString() {
            return "Cantidad: " + getCantidad() + ", Codigo de producto: " + getCodigoProducto() + ", Descripcion: "
                    + ", Precio Unitario: " + getPrecioUnitario() + ", Importe: " + getImporte(); 
        }               
        
    }
}
