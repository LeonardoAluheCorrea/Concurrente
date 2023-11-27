/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinalanalisis;

import Utiles.GrafoEtiquetado;

/**
 *
 * @author Leo
 */
public class TrabajoFinalAnalisis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrafoEtiquetado grafoDeFrobenius;
        int[] A = new int[]{6,9,20};
        int maxCosto = -1;
        //Construimos el grafo circulante y lo mostramos
        grafoDeFrobenius = construirGrafoDeFrobenius(A);
        System.out.println(grafoDeFrobenius.toString());
        
        //Ahora buscamos el camino menos costoso desde 0 hasta todos los otros vertices y nos quedamos con el mas costoso de todos
        for (int i = 1; i < A[0]; i++){
            maxCosto = maximo(maxCosto,grafoDeFrobenius.costoCaminoMasRapido(0,i));
        }
        System.out.println("El nro de Frobenius es: " + (maxCosto - A[0]));
    }
    
    private static int maximo(int x, int y){
        int maximo = x;
        if (y > x)
            maximo = y;
        return maximo;
    }
    
    private static GrafoEtiquetado construirGrafoDeFrobenius(int[] A){
        GrafoEtiquetado grafoF = new GrafoEtiquetado();
        int a0 = A[0];
        int n = A.length;
        for (int i = 0; i < a0; i++){ //Primero insertamos todos los vertices
            grafoF.insertarVertice(i);
        }
        
        for (int i = 0; i < a0; i++){ //Ahora insertamos todos los arcos
            for (int j = 0; j < a0; j++){ //Recorremos todos vertices para ver si tenemos arcos i -> j
                for (int k = 1; k < n; k++){ //Recorremos A buscando el elemento ak para formar los arcos 
                    int ak = A[k];
                    if ((((i + A[k]) - j) % a0) == 0){ //Si se cumple esta condicion entonces hay un arco i -> j con peso ak
                        grafoF.insertarArco(i, j, ak, false);
                    }
                }
            }
        }
        return grafoF;
    }

}
