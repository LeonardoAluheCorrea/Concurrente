/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utiles;

import TrabajoObligatorio.Propiedad;

/**
 *
 * @author Leo
 */
public class OrdenamientoBusqueda {
    
    public static boolean busquedaBinaria (Propiedad[]a, int pri, int ult, int valor){
        boolean rta;
        int medio;
            medio =(int) Math.floor((pri + ult)/2);
            if (pri > ult)
                rta = false;
            else{
                if (a[medio].getPrecio() == valor)
                    rta = true;
                else{
                    if (a[medio].getPrecio() < valor)
                        rta = busquedaBinaria(a,medio+1,ult,valor);
                    else
                        rta = busquedaBinaria(a,pri,medio-1,valor);
                }
            }                    
        return rta;
    }
    
}
