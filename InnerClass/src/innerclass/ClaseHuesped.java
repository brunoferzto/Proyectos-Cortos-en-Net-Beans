/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerclass;

/**
 *
 * @author Bruno
 */
public class ClaseHuesped 
{
    public String unAtributo; 
    private int otroAtributo; 
    
    public int getOtroAtributo()
    {
        return otroAtributo; 
    }
    
    public void unMetodo ()
    {
        ClaseAnidada ca = new ClaseAnidada(); // uso el metodo de clase anidada
        ca.metodoEnAnidada();
    }
    private class ClaseAnidada // Inner Class
    {
        public void metodoEnAnidada()
        {
            unAtributo = "unvalor"; // USO LOS MISMOS ATRIBUTOS
            otroAtributo = 1;
        }
        
        } // fin clase anidada
    }    // fin clase huesped
    

