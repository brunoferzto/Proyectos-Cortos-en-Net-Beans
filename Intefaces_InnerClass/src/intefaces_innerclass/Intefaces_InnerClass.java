/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaces_innerclass;

/**
 *
 * @author Bruno
 */
public class Intefaces_InnerClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Numerable numerable = new Factura(); 
        numerable.numerar(1010);
        
        Factura factura = (Factura)numerable; 
        
        System.out.println("\n Número de la factura: " + factura.leerNumero());
        
        factura.agregarLinea(10, 50, "Reloj Cucú", 900);
        factura.agregarLinea(2, 22, "Sombrero Bombín", 440);
        factura.agregarLinea(7, 37, "Todasicos RCA Victor", 1500);
        
        System.out.println();
        
        for(Factura.LineaFactura lf: factura.getLinea())
        {
            System.out.println(lf);
        }
        System.out.println("\n Total: " + factura.getTotl());

    }
    
}
