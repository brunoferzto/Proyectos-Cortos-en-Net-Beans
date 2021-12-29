/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaejemplo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "Asalariados")
//En la tabla de los asalariados habra una columna cedula que se vinculara con 
//otra columna llamada Cedula en Empleados, segun la estrategia de herencia
@PrimaryKeyJoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
public class Asalariado extends Empleado implements Serializable
{
    private double salario; 

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Asalariado()
     {
         this(1,"N/D",null,null,0);
     }
    public Asalariado(long cedula, String nombre, Integer edad, Boolean casado, double salario)
    {
        super(cedula,nombre,edad,casado);
        setSalario(salario);
    }
}
