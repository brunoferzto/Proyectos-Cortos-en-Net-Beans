/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaejemplo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bruno
 */
public class JPAejemplo {

    private static EntityManagerFactory fabricaGestorEntidades;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        fabricaGestorEntidades  = Persistence.createEntityManagerFactory("UnidadPersistencia");   // TODO code application logic here
         
        //agregarEmpleado();
        
        //agregarEmpleadoconTelefonos();
        
        //ModificarEmpleado ();
        
        //EliminarEmpledo();
        
       // ListarEmpleados();
       
       //ObtenerMayorSalario();
       
       BuscarNombreEmpleado();
    }
    
    private static void agregarEmpleado()
    {
      EntityTransaction transaccion = null;
      
        try 
        {
           EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
           transaccion = gestorEntidades.getTransaction();
           
           Empleado empleado = new Asalariado(4,"Maria José",25,false,2700.0);
           
           transaccion.begin(); // empieza la transaccion
           
           gestorEntidades.persist(empleado); // lo guarda
           
           transaccion.commit(); // termina la transaccion
           
            System.out.println("Empleado Agregado");
           
        } catch (Exception ex)
        {
            try {
                if(transaccion != null && transaccion.isActive())
                    transaccion.rollback();
            } catch (Exception e) {
                System.out.println("Error al deshacer los cambios");
            }
            System.out.println("Error al agregar el empleado");
        
        }
    }
    
     private static void agregarEmpleadoconTelefonos()
    {
      EntityTransaction transaccion = null;
      
        try 
        {
           EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
           transaccion = gestorEntidades.getTransaction();
           
           Empleado empleado = new Jornalero(5,"Arturo",35,true,150.0,10);
           
           empleado.getTelefonos().add(new Telefono("55555551", empleado));
           empleado.getTelefonos().add(new Telefono("55555552", empleado));

           transaccion.begin(); // empieza la transaccion
           
           gestorEntidades.persist(empleado); // lo guarda
           // tmb guarda los telefonos por que indicamos cascada al agregar (tmb al borrar)
           transaccion.commit(); // termina la transaccion
           
            System.out.println("Empleado Agregado");
           
        } catch (Exception ex)
        {
            try {
                if(transaccion != null && transaccion.isActive())
                    transaccion.rollback();
            } catch (Exception e) {
                System.out.println("Error al deshacer los cambios");
            }
            System.out.println("Error al agregar el empleado");
        
        }
    }
     
     private static void ModificarEmpleado ()
     {
         
      EntityTransaction transaccion = null;
      
        try 
        {
           EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
           transaccion = gestorEntidades.getTransaction();
           
           //obtenemos el empleado
          Empleado empleado = gestorEntidades.find(Empleado.class, 4L);

           transaccion.begin(); 
           
          // gestorEntidades.merge(empleado); si el objeto se construye por fuera. no se hace con el FIND
           
           empleado.setNombre("María Pia");
           
           transaccion.commit();
           
            System.out.println("Empleado Modificado");
           
        } catch (Exception ex)
        {
            try {
                if(transaccion != null && transaccion.isActive())
                    transaccion.rollback();
            } catch (Exception e) {
                System.out.println("Error al deshacer los cambios");
            }
            System.out.println("Error al Modificar el empleado");
        
        
        }
     }
     
     private static void EliminarEmpledo()
     {            
           EntityTransaction transaccion = null;      
        try 
        {
           EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
           transaccion = gestorEntidades.getTransaction();
           
           //obtenemos el empleado
          Empleado empleado = gestorEntidades.find(Empleado.class, 4L);
          // gestorEntidades.merge(empleado); si el objeto se construye por fuera. no se hace con el FIND
           transaccion.begin(); 
           
          gestorEntidades.remove(empleado);
                    
           
           transaccion.commit();
           
            System.out.println("Empleado Eliminado");
           
        } catch (Exception ex)
        {
            try {
                if(transaccion != null && transaccion.isActive())
                    transaccion.rollback();
            } catch (Exception e) {
                System.out.println("Error al deshacer los cambios");
            }
            System.out.println("Error al Eliminar el empleado");
        
        
        
        }
     }
     
     private static void ListarEmpleados()
     {
         try {
             EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
             Query consulta = gestorEntidades.createQuery("SELECT e From Empleado e");
                // la e al final son todos los datos, la e al principio es todos los empleados
                List<Empleado> empleados = consulta.getResultList();
                
                for(Empleado e : empleados)
                    System.out.println("Cédula: " + e.getCedula() + ", Nombre: " + e.getNombre());
                
         } catch (Exception e) {
             System.out.println("Error al Listar");
         }
     }
     
      private static void ObtenerMayorSalario()
     {
         try {
             EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
             Query consulta = gestorEntidades.createQuery("select max(a.salario) from Asalariado a");
             
             Double mayorSalario = (Double)consulta.getSingleResult(); // devuelve un unico valor
             
             System.out.println("Mayor Salario: " + mayorSalario);
                
                
         } catch (Exception e) {
             System.out.println("Error al Obtener al mayor Salario");
         }
     }
     
      private static void BuscarNombreEmpleado()
     {
         try {
             EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
             
             Query consulta = gestorEntidades.createQuery("select e.nombre from Empleado e where e.cedula = 5");
             
             String nombre = (String)consulta.getSingleResult(); // devuelve un unico valor
             
             System.out.println("Nombre del Empleado Cedula 5 : " + nombre);
                
                
         } catch (Exception e) {
             System.out.println("Error al Buscar Nombre del Empleado");
         }
     }
     
}
