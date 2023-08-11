/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema08 {
    public static boolean vocal(char letra){
        boolean tipoLetra;
        tipoLetra = letra=='a'||letra=='e'||letra=='i'||letra=='o'||letra=='u';
        return tipoLetra;
    }
    
    
    public static void main(String[]args){
        char letra, continuar;
        boolean tipoLetra;
        int cantVocales=0;
        continuar='s';
        while(continuar=='s'){
            System.out.println("Ingrese un caracter");
            letra=TecladoIn.readNonwhiteChar();
            tipoLetra=vocal(letra);
            if(tipoLetra==true)
                cantVocales++;
            System.out.println("Ingrese s o n dependiendo si desea continuar o no");
            continuar=TecladoIn.readNonwhiteChar();
        }
        System.out.println("La cantidad de vocales es: "+cantVocales);
    }
    
}
