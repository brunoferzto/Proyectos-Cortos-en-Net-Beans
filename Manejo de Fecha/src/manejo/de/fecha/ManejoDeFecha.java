/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejo.de.fecha;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class ManejoDeFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.text.ParseException       
    {
        
      

        Date fechaActual = new Date(); //por defecto toma el valor de la fecha actual, similar a Datetime.Now;

          
        System.out.println("Fecha actual en el formato por defecto... \n");
        System.out.println(fechaActual);
        
  //                  FECHA  ACTUAL EN DIFERENTES FORMATOS              // 

        //   Se mostró Sat Apr 04 13:30:16 UYT 2020
        //Entonces quiero cambiar la forma en cual se presenta
        System.out.println("\n\nFecha actual en Diferentes Formatos... \n");
        
        DateFormat formateador;
        
        //Formato Default (solo fecha)
        formateador = DateFormat.getDateInstance(DateFormat.DEFAULT);
        System.out.println("DEFAULT: "+ formateador.format((fechaActual)));
        
        //Formato SHORT (solo fecha)
        formateador = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("SHORT: "+ formateador.format((fechaActual)));  
        
        
        //Formato MEDIUM (solo fecha)
        formateador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("MEDIUM: "+ formateador.format((fechaActual)));
        
        //Formato LONG (solo fecha)
        formateador = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("LONG: "+ formateador.format((fechaActual)));
        
        //Formato FULL (solo fecha)
        formateador = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("FULL: "+ formateador.format((fechaActual)));
        
        // FORMATO PERSONALIZADO
            // dd/MMM/ yyy es codigo ver Documentación. 
        formateador = new SimpleDateFormat("---> dd / MMM / yyy <---");
        System.out.println("PERSONALIZADO : "+ formateador.format((fechaActual)));

        System.out.println();
                
                
                
                
//                  HORA ACTUAL EN DIFERENTES FORMATOS              // 
               
                
        System.out.println("Hora  actual en Diferentes Formatos... \n");
             //SOLO CAMBIA AL METODO GET TIME
        formateador = DateFormat.getTimeInstance(DateFormat.DEFAULT);              
        System.out.println("DEFAULT: "+ formateador.format((fechaActual)));
        
        //Formato SHORT (solo fecha)
        formateador = DateFormat.getTimeInstance(DateFormat.SHORT);
        System.out.println("SHORT: "+ formateador.format((fechaActual)));  
        
        //Formato MEDIUM (solo fecha)
        formateador = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        System.out.println("MEDIUM: "+ formateador.format((fechaActual)));
        
        //Formato LONG (solo fecha)
        formateador = DateFormat.getTimeInstance(DateFormat.LONG);
        System.out.println("LONG: "+ formateador.format((fechaActual)));
        
        //Formato FULL (solo fecha)
        formateador = DateFormat.getTimeInstance(DateFormat.FULL);
        System.out.println("FULL: "+ formateador.format((fechaActual)));
       

        System.out.println();
        
        System.out.println("Fecha y Hora  actual en formato default... \n");
        //getDateTimeInstance recibe dos parametros y el formato de fecha puede ser distinto 
        //del de hora ejemplo (FECHACORTA,HORALARGA)
        formateador = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);              
        System.out.println("DEFAULT: "+ formateador.format((fechaActual)));
        
        ///////////////////////////////////////////////////////////////////////////
        /// A PARTIR DE UN STRING PARSEARLO Y OBTENER LA FECHA
       System.out.println("/////////////////////////////////////////");
       System.out.println("A PARTIR DE UN STRING PARSEARLO Y OBTENER LA FECHA\n");
       
       Scanner teclado = new Scanner(System.in);
       System.out.println("\n\n Ingrese su fecha de nacimiento (dd/mm/aaaa): ");       
       formateador = DateFormat.getDateInstance(DateFormat.SHORT);
       formateador.setLenient(false); //Menos permisivo.No permite overflow
       Date fechaNacimiento = formateador.parse(teclado.nextLine());
       
       // SEPARAR LO QUE FUÉ INGRESADO EN DIA MES Y AÑO E IMPRIMIRLO SEPARADO
       
       Calendar calendario = Calendar.getInstance();
       calendario.setTime(fechaNacimiento);
       
        System.out.println("\n Día de Nacimiento: " + calendario.get(Calendar.DAY_OF_MONTH));
        System.out.println("\n Més de Nacimiento: " + (calendario.get(Calendar.MONTH) + 1));
        //ENERO ES 0 POR ESO SE SUMA UNO. 
        System.out.println("\n Año de Nacimiento: " + calendario.get(Calendar.YEAR));

       
       
       // 32/enero/1995 no existe dia, si no le pongo SetLenient(FALSE) lo admite
       //lee la fecha como el 1 de febrero. 
       
       teclado.close();
       
       
       
       
       
       
       
       
       
       
       
    }           
    
    
    
    
}
