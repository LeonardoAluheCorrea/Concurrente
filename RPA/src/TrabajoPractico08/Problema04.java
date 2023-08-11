/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico08;
import Utiles.TecladoIn;
import Utiles.BibliotecaIOElegante;
/**
 *
 * @author Leo
 */
public class Problema04 {
    public static void main(String[]args){
        String texto;
        int decoracion;
        System.out.println("Ingrese un numero del 1 al 3 para elegir el tipo de decoracion");
        decoracion=TecladoIn.readLineInt();
        System.out.println("Ingrese el texto que desee");
        texto=TecladoIn.readLine();
        switch(decoracion){
            case 1:
                BibliotecaIOElegante.recuadroGuiones(texto);
                break;
            case 2:
                BibliotecaIOElegante.recuadroCombinado(texto);
                break;
            case 3:    
                BibliotecaIOElegante.recuadroPuntos(texto);
                break;
            default:
                System.out.println("El tipo de decoracion elegida no existe");
                break;
        }
        
    }  
}
