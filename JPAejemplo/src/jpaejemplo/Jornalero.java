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
@Table(name = "Jornalero")
//IGUAL QUE ASALARIADOS
@PrimaryKeyJoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
public class Jornalero extends Empleado implements Serializable
{
    private double jornal;
    
    private int diasTrabajados;

    public double getJornal() {
        return jornal;
    }

    public void setJornal(double jornal) {
        this.jornal = jornal;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }
    
    public Jornalero()
     {
         this(1,"N/D",null,null,0,0);
     }
    public Jornalero(long cedula, String nombre, Integer edad, Boolean casado,double jornal, int diasTrabajados)
    {
        super(cedula,nombre,edad,casado);
        setJornal(jornal);
        setDiasTrabajados(diasTrabajados);
    }
}
