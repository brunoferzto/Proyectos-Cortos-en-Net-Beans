/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holanetbeans;

//import Java.util.Scanner - Manual

import java.util.Scanner;


/**
 *
 * @author Bruno
 */
public class HolaNetBeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        System.out.println("\n ¡Hola NetBeans!");
        //sout + tab
        System.out.println("Mundoooo");
        
        //Pedir Datos
        
         Scanner teclado = new Scanner(System.in);
         
         System.out.print("\nIngresa tu nombre: ");
         String nombre = teclado.nextLine();
         
         int anioActual; 
         
         System.out.print("Ingresa el año actual : ");
         anioActual = Integer.parseInt(teclado.nextLine());
         // si no es numero la 'NumberFormatException'
         
         System.out.print("Ingrese el año de nacimiento: ");
         int anioNacimiento = Integer.parseInt(teclado.nextLine());
         
         int edad = anioActual - anioNacimiento;
         
         System.out.println("\n¡Hola " + nombre + "!");
         System.out.println("Tu edad es: " +edad);
         
         if(edad < 18)
         {
             System.out.println("\nEres menor de edad");    
         }
         else 
             System.out.println("\nEres mayor de edad");
         
         //Condicion 
         System.out.println("Eres " + (edad < 18? "menor" : "mayor") + " de edad.");
         
         System.out.println("");
         
         for(int i = anioNacimiento; i <= anioActual; i++)
             System.out.println(i);
         
                  System.out.println("");
         
                  //Incremento (muestra la misma edad por que se incrementa
                    //despues. El post incremento, suma un valor a la variable
                       //despues que se ejecuto la sentencia. por eso no esta 
                       //actualizada. 
                  //System.out.println("El próximo año tu edad será: " +edad++);
                  
                  //Ahora se ve actualizada, es otra sentencia. 
                  //System.out.println("El próximo año tu edad será: " +edad);
                   
                  //Pre-Incremento
                  // se ejecuta el incremento en la misma línea
                  System.out.println("El próximo año tu edad será: " + ++edad);
                  
                  
                  
         teclado.close();// Forma correcta cerrarlo al finalizar. 
    }
    
}
