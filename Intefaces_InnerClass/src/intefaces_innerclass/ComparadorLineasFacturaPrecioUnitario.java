/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefaces_innerclass;

import java.util.Comparator;

/**
 *
 * @author Bruno
 */
public class ComparadorLineasFacturaPrecioUnitario implements Comparator <Factura.LineaFactura>
{

    @Override
    public int compare(Factura.LineaFactura l1, Factura.LineaFactura l2)
    {
        if(l1.getPrecioUnitario() > l2.getPrecioUnitario())
            return 1;
        else if (l1.getPrecioUnitario() < l2.getPrecioUnitario())
               return -1; 
        else
            return 0;
    }
    
}