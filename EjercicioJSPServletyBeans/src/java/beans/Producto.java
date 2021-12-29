/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class Producto implements Serializable
{
    int codigo; 
    String descripcion; 
     double costo; 
    private int stock; 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto(int codigo, String descripcion, double costo, int stock) {
       setCodigo(codigo);
       setDescripcion(descripcion);
       setCosto(costo);
       setStock(stock);
    }

    public Producto() 
    {
        this(1,"N/D",0,0);
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
    
    
    
    
}
