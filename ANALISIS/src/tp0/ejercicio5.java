package tp0;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Random;

/**
 *
 * @author rauzer
 */
    public class ejercicio5 {
    public static void main (String[]args){
        //Genera numeros del 1 al 1000 sin repetidos
        boolean[] b = new boolean[1000];//Usamos un arreglo de booleanos para ver que numeros han sido escritos
        Random r = new Random();
        for (int i=0; i<100; i++){
            int n = r.nextInt(1000);
            while(b[n]){//Genera hasta encontrar uno que no haya salido
                n = r.nextInt(1000);
            }
            b[n]=true; //Marcamos que salio
            System.out.println(n);
        }
    }
}
