/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico06;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema05 {
    public static void main(String[]args){
        double precio,descu1,descu2,precioFinal1;
        int pago,marca,dia;
        System.out.println("Ingrese el precio de el producto");
        precio=TecladoIn.readLineDouble();
        System.out.println("Si el producto es de marca propia ingrese '1'. Si no lo es ingrese'2'");
        marca=TecladoIn.readLineInt();
        System.out.println("Si pago con tarjeta naranja ingrese '1'. Si no lo hizo ingrese '2' ");
        pago=TecladoIn.readLineInt();
        System.out.println("Ingrese el dia de la semana en numeros");
        dia=TecladoIn.readLineInt();
        switch(pago){
            case 2: 
                if(marca==1&&dia==2){
                descu1=precio*10/100;
                precioFinal1=precio-descu1;
                System.out.println("El precio final es: "+precioFinal1);
                }
                else{
                    System.out.println("El precio final es: "+precio);
                }break;
            case 1:
                if(marca==1&&dia==2){
                    descu1=precio*10/100;
                    descu2=precio*5/100;
                    precioFinal1=precio-descu1-descu2;
                    System.out.println("El precio final es: "+precioFinal1);
                }
                else{
                    descu2=precio*5/100;
                    precioFinal1=precio-descu2;
                    System.out.print("El precio final es: "+precioFinal1);
                }
                
            
        }
        
    }
    
}
