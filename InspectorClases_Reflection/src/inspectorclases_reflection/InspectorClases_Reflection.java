/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inspectorclases_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author Bruno
 */
public class InspectorClases_Reflection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
           Class clase = Class.forName("inspectorclases_reflection.Empleado");
           
            System.out.println("Nombre Completo Clase: "+ clase.getName());
            System.out.println("Nombre Clase: " + clase.getSimpleName());
            
            System.out.println("\n\nAtributos:\n");
            
            // obtengo los atributos publicos
            Field[] atributos = clase.getFields();
            
            for (Field a : atributos)
            {
                System.out.println("+ " + a.getName() + " : " + a.getType().getSimpleName());
            }
            
            System.out.println();
            
                        // obtengo todos los atributos 
            
            Field[] atributosDeclarados = clase.getDeclaredFields();
            
            for (Field a : atributosDeclarados)
            {
                    // el metodo getModifiers del atriburo del objeto field
                // nos devuelve un numero diciendo si es public o no
                // el metodo 'ispublic' recibe el numeor y devuelve si el
                //atributo es public (true) o privado (false)
                System.out.println((Modifier.isPublic(a.getModifiers()) ? "+ " : "- ") + a.getName() + " : " + a.getType().getSimpleName());
            }
            
            System.out.println("\n\n Constructores:\n");
            
            Constructor[] constructores = clase.getConstructors();
            
            String parametros;
            
            for(Constructor c : constructores)
            {
                parametros = "";
                
                    for(Class p : c.getParameterTypes())
                    {
                        if(parametros.length() > 0)
                        {
                            parametros += ", ";
                        }
                        parametros += p.getSimpleName();
                    }
                    
                    System.out.println("+ " + clase.getSimpleName() + "(" + parametros + ")");
            }
                    System.out.println();
                    
                   //METODOS Publicos
                    System.out.println("\n\n Metodos Publicos:\n");
                    
                    Method[] metodos = clase.getMethods();
                    
                    for(Method m : metodos)
                    {
                        parametros = "";
                        
                        for(Class p : m.getParameterTypes())
                        {
                            if(parametros.length() > 0)
                            {
                                parametros += ", ";
                            }
                            parametros += p.getSimpleName();
                        }
                        
                System.out.println("+ " + m.getName() + "(" + parametros + ") : " + m.getReturnType().getSimpleName());
                    }
                    
                      //TODOS LOS METODOS 
                    System.out.println("\n\n Todos los Metodos:\n");
                    
                    Method[] metodosDeclarados = clase.getDeclaredMethods();
                    
                    for(Method m : metodosDeclarados)
                    {
                        parametros = "";
                        
                        for(Class p : m.getParameterTypes())
                        {
                            if(parametros.length() > 0)
                            {
                                parametros += ", ";
                            }
                            parametros += p.getSimpleName();
                        }
                        
                System.out.println((Modifier.isPublic(m.getModifiers()) ? "+ " : "- ") + m.getName() + "(" + parametros + ") : " + m.getReturnType().getSimpleName());
                        
                    }      
                    
                    System.out.println("\n\n Pruebas con una instancia : \n");
                    
                    Empleado e = new Empleado(); 
                    // ES LO MISMO 
                    Object objeto = clase.newInstance();
                    // Obtengo edad
                        Field atributoEdad = clase.getField("edad");
                    // LE PASO LA INSTANCIA DE LA CUAL QUIEOR MOSTRAR EL ATRIBUTO
                        System.out.println("Edad antes de cumplir años: " + atributoEdad.getInt(objeto));
                        
                        //INVOCAR AL METODO PRIVADO 
                        Method metodoCumplirAnios = clase.getDeclaredMethod("cumplirAnios");
                        metodoCumplirAnios.setAccessible(true);
                        // SE INVOCA EL METODO DE INSTANCIA, SE LE PASA ENTONCES LA INSTANCIA 
                        metodoCumplirAnios.invoke(objeto);
                        
                        System.out.println("Edad luego de cumplir años: " + atributoEdad.getInt(objeto));

                    
        }                      
        catch (ClassNotFoundException ex)
        {
            System.out.println("¡ERROR! No se encontró la clase.");
        }
        catch (Exception ex)
        {
            System.out.println("¡ERROR! Ha ocurrido un error al realizar las pruebas con la instancia");
        }
        }
    }
    

