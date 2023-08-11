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
public class Problem07 {
    public static void main(String[]args){
        double caja1,caja2,caja3,caja4,caja5,caja6,caja7,recaudacionDia,recaudacionSem=0;
        for(int i=0;i<=7;i++){
            System.out.println("Ingrese el dinero recaudado por las 7 cajas en 1 dia");
            caja1=TecladoIn.readLineInt();
            caja2=TecladoIn.readLineInt();
            caja3=TecladoIn.readLineInt();
            caja4=TecladoIn.readLineInt();
            caja5=TecladoIn.readLineInt();
            caja6=TecladoIn.readLineInt();
            caja7=TecladoIn.readLineInt();
            recaudacionDia=caja1+caja2+caja3+caja4+caja5+caja6+caja7;
            System.out.println("La recaudacion del dia es "+recaudacionDia);
            recaudacionSem=recaudacionSem+recaudacionDia;
        }
        System.out.println("La recaudacion de la semana es "+recaudacionSem);
    }
}
