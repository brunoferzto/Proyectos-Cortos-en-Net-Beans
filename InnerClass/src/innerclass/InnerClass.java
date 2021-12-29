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
public class InnerClass {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClaseHuesped ch = new ClaseHuesped(); 
        
        ch.unMetodo();
        
        System.out.println(ch.unAtributo);
        System.out.println(ch.getOtroAtributo());
        
    }
    
}
