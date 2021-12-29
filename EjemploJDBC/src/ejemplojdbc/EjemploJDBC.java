/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Bruno
 */
public class EjemploJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try {
            // con algunos drivers no es necesario el newInstance()
            Class.forName("com.mysql.jdbc.Driver"); /*.newInstance();*/
                   
        } catch (Exception e) 
        {
            System.out.println("Error al instanciar el Driver");
        }
        
       /*agregarEmpleado2();*/
       /*agregarEmpleadoConTelefonos2();
      /* modificarEmpleado2(); */
     /* eliminarEmpleado2();*/
      //listarEmpleado2();
      //ObtenerMayorSueldo2();
      buscarNombreEmpleado2();
    }
    
    private static void agregarEmpleado()
    { // implemento la interfaz "java.sql.Connection;"
        Connection conexion = null; 
        // USARE statement simple "import java.sql.Statement;"
        Statement consulta = null; 
        
        try {
            //LE PEDIMOS AL DRIVER MANAGER LA CONEXION Y LA GUARDAMOS EN LA VARIABLE
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
            // LUEGO LE PEDIMOS A LA CONEXION QUE NOS CRE UN STATEMENT SIMPLE
                    consulta = conexion.createStatement(); /*NO SE LE PASA NADA POR QUE ES SIMPLE*/
            // LE PEDIMOS AL STATEMENT QUE SE EJECUTE CON EL METODO EXECUTEUPDATE    
                    int filasAfectadas = consulta.executeUpdate("INSERT INTO EMPLEADOS VALUES (4,'Maria José',25,2700,0)");// 
                                                                   //COMO ES STATEMENT SIMPLE SE PASA ACA LA CONSULTA
                    if(filasAfectadas == 1)
                        System.out.println("Empleado Agregado");
                    else
                        System.out.println("Error, No se agregó el Empleado");
        } catch (Exception e) 
        {
            System.out.println("Error, No se agregó el Empleado");
        }
        finally 
        {
            try
            {
             if(consulta != null) consulta.close();
              if(conexion != null) consulta.close();   
            } catch (Exception e)
            {
                System.out.println("Error al cerrar los recursos");
            }
            
            
        }
        
    }
    
     private static void agregarEmpleado2(){try 
         (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
          Statement consulta = conexion.createStatement();){
         
          int filasAfectadas = consulta.executeUpdate("INSERT INTO EMPLEADOS VALUES (5,'Mara',50,30000,1)");
          
          if(filasAfectadas == 1)
                        System.out.println("Empleado Agregado");
                    else
                        System.out.println("Error, No se agregó el Empleado");
         
             } catch (Exception ex )
             {
                 System.out.println("Error, No se agregó el Empleado");
             }
 }
     
     private static void agregarEmpleadoConTelefonos()
     {
         Connection conexion = null; 
         Statement consulta = null; 
         try {
             conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC","root","Rodo1125");
             conexion.setAutoCommit(false);
             
             consulta = conexion.createStatement();
             
             consulta.executeUpdate("INSERT INTO Empleados VALUES (6,'Arturo',35,150000,1);");
             consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL,55555551,6);");
             consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL,55555552,6);");
             
             conexion.commit();
             System.out.println("Empleado Agregado con Exito");
             
         } catch (Exception e) 
         {
             try {
                 if (conexion != null) conexion.rollback();
             } catch (Exception ex) {
                 System.out.println("Error al deshacer los cambios");
             }
             System.out.println("ERR  ");
         } 
         finally{ 
             try {
                 if(consulta != null) consulta.close();
                if(conexion != null) consulta.close();
             } catch (Exception e) {
             }
 
              
         }
     }
     
     private static void agregarEmpleadoConTelefonos2(){    
         try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC","root","Rodo1125");
              Statement consulta = conexion.createStatement();)
              {
                  try {
                      
             conexion.setAutoCommit(false);
                                    
             consulta.executeUpdate("INSERT INTO Empleados VALUES (7,'vidal',30,850000,0);");
             
             
             
             consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL,22222,7);");
             consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL,5552,7);");
             
             conexion.commit();
             System.out.println("Empleado Agregado con Exito");
                  } catch (Exception e) 
                  {
                      try {
                          if (conexion != null) conexion.rollback();
                      }catch (Exception exR)
                      {
                          System.out.println("ERROR AL DESHACER CAMBIOS");
                      }
                      
                      
                  }
            
             
         } catch (Exception e) 
         {

             System.out.println("ERRor no se agrego  ");
         }          
         }
     
     private static void modificarEmpleado()
     {
         // CONSULTA PREPARADAS
         
         Connection conexion = null;
         //uso la INTERFAZ import java.sql.PreparedStatement;
         PreparedStatement consulta = null;
         try {
             
             
             conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
              
             consulta = conexion.prepareStatement("UPDATE Empleados SET Nombre = ? WHERE Cedula = ?");
             consulta.setString(1, "Bruno");
             consulta.setLong(2, 3);
             
             int filasAfectadas = consulta.executeUpdate();
             
             if(filasAfectadas == 1)
                 System.out.println("Empleado Modificado");
             else
                 System.out.println("Error, No se modificó Empleado");
             
         } catch (Exception e) {
             System.out.println("Error, No se modificó Empleado");
         } finally
         {
             try {
                 if(consulta!= null) consulta.close();
                 if(conexion != null) conexion.close();
             } catch (Exception e) {
                 System.out.println("Error al cerrar recursos");
             }
         }
     }
     
      private static void modificarEmpleado2()
     {
         // CONSULTA PREPARADAS
         
         
         try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
              PreparedStatement consulta = conexion.prepareStatement("UPDATE Empleados SET Nombre = ? WHERE Cedula = ?");) 
         {
                       
             consulta.setString(1, "Bruno2");
             consulta.setLong(2, 3);
             
             int filasAfectadas = consulta.executeUpdate();
             
             if(filasAfectadas == 1)
                 System.out.println("Empleado Modificado");
             else
                 System.out.println("Error, No se modificó Empleado");
             
         } catch (Exception e) {
             System.out.println("Error, No se modificó Empleado");
         }
     }
      
      private static void eliminarEmpleado()
      {
       Connection conexion = null; 
       CallableStatement consulta = null; 
       // procedimientos ALMACENADOS 
       
          try {              
              conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
              consulta = conexion.prepareCall("{ CALL EliminarEmpleado (?, ?) }");
              consulta.setLong(1, 2); 
              consulta.registerOutParameter(2, java.sql.Types.VARCHAR); // parametro de salida
              
              consulta.executeUpdate();  
              
              String error = consulta.getString(2);
              
              if(error == null) System.out.println("Empleado Eliminado");
              else System.out.println(error);
                  
          } catch (Exception e) {
              System.out.println("No se Eliminó Empleado");
          }finally{
              try {
                  if(consulta != null) consulta.close(); 
                  if(conexion != null) conexion.close(); 
              } catch (Exception e) {
                  System.out.println("Error al cerrar recursos");
              }
          }
      }
      private static void eliminarEmpleado2()
      {
          try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
               CallableStatement consulta = conexion.prepareCall("{ CALL EliminarEmpleado (?, ?) }");) {
              
               consulta.setLong(1, 3); 
              consulta.registerOutParameter(2, java.sql.Types.VARCHAR); 
              
              consulta.executeUpdate();  
              
              String error = consulta.getString(2);
              
              if(error == null) System.out.println("Empleado Eliminado");
              else System.out.println(error);
              
          } catch (Exception e) 
          {
              System.out.println("No se Eliminó Empleado");
          }
      }
      
      private static void listarEmpleado()
      {
          Connection conexion = null; 
          CallableStatement consulta = null;
          ResultSet resultadoConsulta = null; 
          
         // leer result set con SP (tmb se puede con cualquier statment        
          try {
              
                      
              conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
              consulta = conexion.prepareCall("{ CALL ListarTodos () }");
              
              resultadoConsulta = consulta.executeQuery();
              
              System.out.println();
              
              long cedula; 
              String nombre; // No se usa primitivos por que en la db puede venir un nul, (los NO primitivos no admiten null)
              Integer edad;
              Double sueldo; 
              Boolean casado;
              
              while(resultadoConsulta.next())
              {
                  cedula = resultadoConsulta.getLong(1);
                  nombre = resultadoConsulta.getString("Nombre"); 
                  // USO OBJECT POR QUE GETINT DEVUELVE 0 SI ES NULL, 
                  // LUEGO NO SE SABE SI EL 0 ES UN VALOR REAL DE LA DB O NO
                  edad =  (Integer)resultadoConsulta.getObject("Edad");
                  sueldo = (Double)resultadoConsulta.getObject("Sueldo");
                  // USAR WASNULL
                  casado = resultadoConsulta.getBoolean("Casado");
                   
                  if(casado == false)
                  {
                      // si el false era null va null, si es false va lo que se
                      // encuentra en la variable
                      casado = resultadoConsulta.wasNull() ? null : casado;
                  }
                  
                  System.out.println("Cédula: " + cedula + ", Nombre: " + nombre + 
                                    ", Edad: " +(edad != null ? edad : "N/D") + ", Sueldo : " 
                          + (sueldo != null ? sueldo : "N/D") 
                          + ", Casado : " + (casado != null ? (casado  ? "Si" : "NO"): "N/D"));
                  
              }
              
              System.out.println();
              
                                                                    
          } catch (Exception e) {
              System.out.println("Error no se puede Listar");
          } finally
          {
              try {
                if(resultadoConsulta != null) resultadoConsulta.close();
                if (consulta != null) consulta.close();
                if (conexion != null) conexion.close();
              } catch (Exception e) {
                  System.out.println("Error al Cerrar los recursos");
              }
          }
          
         
      }
      
         private static void listarEmpleado2()
      {
          
         // leer result set con SP (tmb se puede con cualquier statment        
          try ( Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
                CallableStatement  consulta = conexion.prepareCall("{ CALL ListarTodos () }");
                ResultSet   resultadoConsulta = consulta.executeQuery();  ) {
              
              System.out.println();
              
              long cedula; 
              String nombre; // No se usa primitivos por que en la db puede venir un nul, (los NO primitivos no admiten null)
              Integer edad;
              Double sueldo; 
              Boolean casado;
              
              while(resultadoConsulta.next())
              {
                  cedula = resultadoConsulta.getLong(1);
                  nombre = resultadoConsulta.getString("Nombre"); 
                  // USO OBJECT POR QUE GETINT DEVUELVE 0 SI ES NULL, 
                  // LUEGO NO SE SABE SI EL 0 ES UN VALOR REAL DE LA DB O NO
                  edad =  (Integer)resultadoConsulta.getObject("Edad");
                  sueldo = (Double)resultadoConsulta.getObject("Sueldo");
                  // USAR WASNULL
                  casado = resultadoConsulta.getBoolean("Casado");
                   
                  if(casado == false)
                  {
                      // si el false era null va null, si es false va lo que se
                      // encuentra en la variable
                      casado = resultadoConsulta.wasNull() ? null : casado;
                  }
                  
                  System.out.println("Cédula: " + cedula + ", Nombre: " + nombre + 
                                    ", Edad: " +(edad != null ? edad : "N/D") + ", Sueldo : " 
                          + (sueldo != null ? sueldo : "N/D") 
                          + ", Casado : " + (casado != null ? (casado  ? "Si" : "NO"): "N/D"));
                  
              }
              
              System.out.println();
              
                                                                    
          } catch (Exception e) {
              System.out.println("Error no se puede Listar");
          }      
         
          
      }
         
         
         private static void ObtenerMayorSueldo()
         {
            Connection conexion = null; 
            CallableStatement consulta = null; 
            
             try {
                 
                 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
                 consulta = conexion.prepareCall("{CALL ObtenerMayorSueldo (?)}");
                 consulta.registerOutParameter(1, java.sql.Types.DOUBLE);
                 // el select del sp no devuelve filas. devuelve un unico valor. No uso resultset
                 consulta.executeUpdate();
                 
                 double mayorSueldo = consulta.getDouble(1);
                 
                 System.out.println("Mayor Sueldo: " + mayorSueldo);
                 
             } catch (Exception e) {
                 System.out.println("Error al obtener mayor sueldo");
             }
             finally
             {
                 try {
                     if(consulta != null) consulta.close();
                     if(conexion != null) conexion.close();;
                 } catch (Exception e) {
                     System.out.println("Error al cerrar los recursos");
                 }
             }
                    
            
         }
         
         private static void ObtenerMayorSueldo2()
         {           
             try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
                  CallableStatement consulta = conexion.prepareCall("{CALL ObtenerMayorSueldo (?)}");  ) {
                                  
                 consulta.registerOutParameter(1, java.sql.Types.DOUBLE);
                 // el select del sp no devuelve filas. devuelve un unico valor. No uso resultset
                 consulta.executeUpdate();
                 
                 double mayorSueldo = consulta.getDouble(1);
                 
                 System.out.println("Mayor Sueldo: " + mayorSueldo);
                 
             } catch (Exception e) {
                 System.out.println("Error al obtener mayor sueldo");
             }                                
            
         }
         
         private static void buscarNombreEmpleado()
         {
             Connection conexion = null; 
             CallableStatement consulta = null; 
             try {
                 
                 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
                 consulta = conexion.prepareCall("{ ? = CALL Buscar (?)}");
                 consulta.registerOutParameter(1, java.sql.Types.VARCHAR);
                 consulta.setLong(2, 3);
                 
                 consulta.executeUpdate();
                 
                 String nombre = consulta.getString(1);
                 
                 System.out.println("Nombre del empleado con cedula 3 :" + nombre);
                 
             } catch (Exception e) {
                 System.out.println("Error al obtener el Nombre");
             } finally
             {
                 try {
                     if(consulta != null) consulta.close();
                     if(conexion != null) conexion.close();
                     
                 } catch (Exception e) {
                     System.out.println("ERROR");
                 }
             }
             
         }
      
       private static void buscarNombreEmpleado2()
         {
             try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "Rodo1125");
                CallableStatement consulta = conexion.prepareCall("{ ? = CALL Buscar (?)}");){                
                
                 consulta.registerOutParameter(1, java.sql.Types.VARCHAR);
                 consulta.setLong(2, 3);
                 
                 consulta.executeUpdate();
                 
                 String nombre = consulta.getString(1);
                 
                 System.out.println("Nombre del empleado con cedula 3 :" + nombre);
                 
             } catch (Exception e) {
                 System.out.println("Error al obtener el Nombre");
             } 
             
         }
     
}
