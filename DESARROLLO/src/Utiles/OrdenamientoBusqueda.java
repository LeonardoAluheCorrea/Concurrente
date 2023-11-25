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
    
    public static int particion(Object[]a, int inicio, int fin){
        int pivote, masPequenio;
        Object temp;
        pivote = (int)a[fin]; //Usamos de pivote el ultimo elemento
        masPequenio = inicio-1; //Iniciamos el elemento mas pequeño en -1
        for (int j = inicio; j < fin; j++) { //Recorremos el arreglo desde inicio hasta fin
            if ((int) a[j] <= pivote) {//Si el elemento actual es <= al pivote lo intercambiamos con el elemento mas pequeño
                masPequenio++;
                temp = a[masPequenio+1];
                a[masPequenio+1] = a[j];
                a[j] = temp;
            }
        }
        temp = a[masPequenio+1];
        a[masPequenio+1] = a[fin];
        a[fin] = temp;
        return masPequenio+1;
    }
    
    public static void quickSort(Object[]a, int inicio, int fin){
        int indice;
        if (inicio < fin){
            indice = particion (a,inicio,fin);        
            quickSort(a,inicio,indice-1);
            quickSort(a,indice+1,fin);
        }
    }
    
}
