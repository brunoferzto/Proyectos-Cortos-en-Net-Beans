/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author Bruno
 */
public class WrapperRequestParametrosAMayusculas extends HttpServletRequestWrapper {
    
    public WrapperRequestParametrosAMayusculas(HttpServletRequest request) {
        super(request);
    }
    
    @Override  //LLAMA A REQUEST (SUPER) Y SE LE SOLICITAN LOS PARAMETROS, LUEGO SE PASAN A MAYUSCULAS
    public String getParameter (String name){
      return super.getParameter(name).toUpperCase();}
            
    
    
    
    
}
