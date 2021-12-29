/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coleccionesdinamicas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class ColeccionesDinamicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
       ArrayList miArrayList = new ArrayList();
            List masGeneraliList = new ArrayList();
            //List es una interfaz de la cual salen implementaciones
            //como ArrayList & LinkedList
            
            miArrayList.add("hola");
            miArrayList.add(10); //agregar x indice
            System.out.println("Elementos en miArrayList: " + miArrayList.size());
            System.out.println(miArrayList.get(0)); //obtener elemento x
            miArrayList.remove(0); // quitar x indice 
            System.out.println("Elementos en miArrayList: " + miArrayList.size());

            System.out.println("");
            
            List<String> otroArrayList = new ArrayList(); // solo admite string
            otroArrayList.add("hola");
           // otroArrayList.add(1);  Error de tipo
           
           System.out.println("");  
           
           LinkedList miLinkedList = new LinkedList();
           
           miLinkedList.add("chau");
           // miLinkedList.add(100);
           miLinkedList.addFirst(20);// Añade al principio
           
           System.out.println("Elementos en miLinkedList: " + miLinkedList.size());
           System.out.println(miLinkedList.get(0)); // Devuelve 78
           
           miLinkedList.removeFirst(); // borra el primero =  miLinkedList.remove()
           
           // miLinkedList.removeLast();
           
           System.out.println("Elementos en miLinkedList: " + miLinkedList.size());
           System.out.println(miLinkedList.get(0)); 
           
           
           
           //metodo first y last solo disponible en linkedlist array e interfa list no
    }
    
}
