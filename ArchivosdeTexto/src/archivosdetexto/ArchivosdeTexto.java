/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosdetexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Date;

/**
 *
 * @author Bruno
 */
public class ArchivosdeTexto {

    //se escribe la fecha actual al iniciar el programa
    // se leen todas las lineas (1ro)
    
    public static void main(String[] args)
    {
        //se podria solo crear sin inicialización
        File archivo = new File("log.txt");
        
        // despues del && pregunta si es verdaderamente un archivo y no
        //un directorio
        if(archivo.exists() && !archivo.isDirectory())
        {
         try(FileReader fr = new FileReader(archivo); 
             BufferedReader br = new BufferedReader(fr))
         {
             System.out.println("Ejecuciones anteriores... \n");
             
             //Leer lineas
             String linea;
             while((linea = br.readLine()) != null)
             {
                 System.out.println(linea);
             }
         }  
         catch (Exception ex)
         {
             System.out.println("Error al Leer el archivo 'log'");
         }
        }
        
        try (FileOutputStream fos = new FileOutputStream(archivo,true);
             PrintStream ps = new PrintStream(fos))
        {
            ps.println(new Date());
            
        } 
        catch (Exception ex)
        {
            System.out.println("Ocurrio un error al escribir el archivo 'log'");
        }
         
        }
    }
    
   
