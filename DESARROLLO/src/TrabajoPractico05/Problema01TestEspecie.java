/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;
import Utiles.TecladoIn;
import ClasesTP5.Especie;
import java.util.Random;
/**
 *
 * @author Leo
 */
public class Problema01TestEspecie {
    //Aqui creamos una clase diseñada para probar la clase especie
    public static void main (String []args){
        String nombreEspecie;
        int poblacion, opcion, años;
        double crecimiento;
        Especie e1, e2;
        e1 = new Especie();
        e2 = new Especie();
        System.out.println("Ingrese la especie");
        nombreEspecie = TecladoIn.readLine();
        e1.setNombre(nombreEspecie); 
        System.out.println("Ingrese la segunda especie");
        nombreEspecie = TecladoIn.readLine();
        
        e2.setNombre(nombreEspecie);
        
        System.out.println("Ingrese la poblacion de la primera especie");
        poblacion = TecladoIn.readLineInt();
        e1.setPoblacion(poblacion);
        System.out.println("Ingrese la poblacion de la segunda especie");
        poblacion = TecladoIn.readLineInt();
        e2.setPoblacion(poblacion);
        System.out.println("Ingrese la tasa de crecimiento de la primera especie");
        crecimiento = TecladoIn.readLineInt();
        e1.setTasaDeCrecimiento(crecimiento);
        System.out.println("Ingrese la tasa de crecimiento de la segunda especie");
        crecimiento = TecladoIn.readLineInt();
        e2.setTasaDeCrecimiento(crecimiento);
        do{
            menu();
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                case 1:
                    System.out.println("Desea cambiar la primera o segunda especie?");
                    opcion = TecladoIn.readLineInt();
                    if (opcion == 1){
                        e1.setNombre(TecladoIn.readLine());
                        e1.setPoblacion(TecladoIn.readLineInt());
                        e1.setTasaDeCrecimiento(TecladoIn.readLineDouble());
                    }
                    else{
                        e2.setNombre(TecladoIn.readLine());
                        e2.setPoblacion(TecladoIn.readLineInt());
                        e2.setTasaDeCrecimiento(TecladoIn.readLineDouble());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese que especie desea proyectar en el tiempo");
                    opcion = TecladoIn.readLineInt();
                    System.out.println("Ingrese la cantidad de años en que quiere proyectar la poblacion de la especie");
                    años = TecladoIn.readLineInt();
                    System.out.println("La poblacion en "+años+" años sera "+e1.poblacionProyectada(años));;
                    break;
                case 3:
                    System.out.println("Sobre que especie desea calcular?");
                    opcion = TecladoIn.readLineInt();
                    if (opcion == 1){
                        System.out.println("Le tomara a la especie 1 "+superarPoblacion(e1,e2)+" superar a la especie 2");
                    }
                    else
                        System.out.println("Le tomara a la especie 2 "+superarPoblacion(e2,e1)+" superar a la especie 1");
            }
        }
        while(opcion < 4 && opcion > 0);
    }
    
    public static void menu(){
        System.out.println("1. Cambiar los datos de una especie ya ingresada en el sistema");
        System.out.println("2. Calcular el aumento de la poblacion en una determinada cantidad de años");
        System.out.println("3. Calcular cuanto tiempo le tomara a una especie superar la poblacion de la otra");
    }
    
    public static int superarPoblacion(Especie e1, Especie e2){
        //Calcula cuantos años le tomara a una especie superar la poblacion de la otra
        int i;
        i = 0;
        while (e1.poblacionProyectada(i) <= e2.poblacionProyectada(i)){
            i++;
        }
        return i;
    }
    
}
