
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leo
 */
public class AdivinarNumero {
    
    /* 
    Si un usuario sigue la logica del juego entonces podria tomar como maximo n intentos, ya
    que en el peor caso el numero a adivinar sera n y el usuario comenzara en ingresara 1, luego 2, 3 y asi
    sucesivamente. Este comportamiento del usuario no seria inteligente pero si seguiria la logica del juego
    
    Busqueda Binaria: Consiste en seleccionar elemento medio de un conjunto para separarlo
    en 2 partes, una que contine el elemento buscado y otra que no. Luego repetimos el proceso con el nuevo
    conjunto que tiene el elemento y asi hasta obtener el elemento buscado
    
    */
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int li, ls, n, ad;
        System.out.println("Ingrese el limite inferior");
        li = s.nextInt();
        System.out.println("Ingrese el limite superior");
        ls = s.nextInt();
        if (ls < li) {
            System.out.println("ERROR");
        } else {
            Random r = new Random();
            n = r.nextInt(li, ls);
            do {
                System.out.println("Ingrese un numero entero");
                ad = s.nextInt();
                if (ad < n) {
                    System.out.println("Mayor");
                } else if (ad > n) {
                    System.out.println("Menor");
                } else {
                    System.out.println("Acerto!");
                }
            } while (ad != n);
        }
    }
}
