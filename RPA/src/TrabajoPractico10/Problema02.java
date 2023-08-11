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
public class Problema02 {
    public static double costoTotal (int menuCom, int menuVeg){
        double resultado;
        menuCom=menuCom*230;
        menuVeg=menuVeg*150;
        resultado=menuVeg+menuCom;
        return resultado;
    }
    
    
    public static void main(String[]args){
        int menuCom=0,menuVeg=0,tipoMenu;
        String continuar;
        continuar="Si";
        while("si".equalsIgnoreCase(continuar)){
            System.out.println("Ingrese 1 para menu vegetariano, 2 para menu comun");
            tipoMenu=TecladoIn.readLineInt();
            if(tipoMenu==1)
                menuVeg++;
            else
                menuCom++;
            System.out.println("Hay mas personas que desean elegir menu? si/no");
            continuar=TecladoIn.readLine();
        }
        System.out.println("El gasto necesario para comprar todos los menus es: "+costoTotal(menuCom,menuVeg));
    }
}
