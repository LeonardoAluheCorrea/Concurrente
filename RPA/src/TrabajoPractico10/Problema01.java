/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico10;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema01 {
    public static String vidrieraFav(int belleza, int ropa, int accesorios){
        String mayor;
        mayor="Nada";
        if(belleza >= ropa && belleza >= accesorios)
            mayor="Belleza";
        if(ropa >= belleza && ropa >= accesorios)
            mayor="Ropa";
        if(accesorios >= ropa && accesorios >= belleza)
            mayor="Accesorios";
        return mayor;
    }
    
    
    public static void main(String[]args){
        String continuar,genero,vidriera;
        int ropaH = 0,accesorioH = 0,bellezaH = 0,ropaM = 0,accesorioM = 0,bellezaM = 0;
        continuar="Si";
        while("si".equalsIgnoreCase(continuar)){
            System.out.println("Es usted hombre o mujer?");
            genero=TecladoIn.readLine();
            if ("Hombre".equalsIgnoreCase(genero)){
                System.out.println("Que tipo de vidriera prefiere?");
                vidriera=TecladoIn.readLine();
                switch(vidriera){
                    case "belleza":
                        bellezaH++;
                        break;
                    case "ropa":
                        ropaH++;
                        break;
                    case "accesorios":
                        accesorioH++;
                        break;
                }
            }
            else{
                System.out.println("Que tipo de vidriera prefiere?");
                vidriera=TecladoIn.readLine();
                switch(vidriera){
                     case "belleza":
                        bellezaM++;
                        break;
                    case "ropa":
                        ropaM++;
                        break;
                    case "accesorios":
                        accesorioM++;
                        break;
                }
                }
            System.out.println("Desea continuar encuestado? si/no");
            continuar=TecladoIn.readLine();
            }
        System.out.println("Lo que mas prefieren las mujeres es: "+vidrieraFav(bellezaM,ropaM,accesorioM));
        System.out.println("Lo que mas prefieren los hombres es: "+vidrieraFav(bellezaH,ropaH,accesorioH));
        }
    

}
