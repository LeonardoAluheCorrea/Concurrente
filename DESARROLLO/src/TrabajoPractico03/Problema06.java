/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico03;
import Utiles.TecladoIn;
import Utiles.Arreglos;
import Utiles.ModulosTP1;
/**
 *
 * @author Leo
 */
public class Problema06 {
    public static void main(String[]args){
        //Genera dos arreglos, uno para las capitales provinciales del pais y CABA, otro para sus respectivas temperaturas minimas, luego llama a modulos para realizar diversas operaciones
        String[]ciudad;
        double[]tempMinima;
        ciudad = new String[24];
        tempMinima = new double [24];
        for (int i = 0; i < ciudad.length; i++){
            System.out.println("Ingrese la ciudad");
            ciudad[i] = TecladoIn.readLine();
            System.out.println("Ingrese la temperatura minima registrada en esa ciudad");
            tempMinima[i] = TecladoIn.readLineDouble();
        }
        do
            switch(menu()){
                case 1:
                    System.out.println("La capital con la menor temperatura del pais es "+ciudad[Arreglos.posicionMenor(tempMinima)]);
                    break;
                case 2:
                    System.out.println("El promedio de temperaturas minimas de las capitales del pais es"+Arreglos.promedioArray(tempMinima));
                    break;
                case 3:
                    System.out.println("Las ciudades con temperaturas menores a 0 grados son");
                    for(int k = 0; k < Arreglos.todosNegativos(tempMinima).length; k++){                        
                        System.out.print(ciudad[Arreglos.todosNegativos(tempMinima)[k]]+", ");
                    }
                    break;
                case 4:
                    
        }
        while(menu() < 5 || menu() > 0);
    }
    
    public static int menu(){
        //Presenta un menu de opciones y devuelve la eleccion del usuario
        int opcion;
        System.out.println("1. Mostrar la ciudad que presenta la menor temperatura del país");
        System.out.println("2. Calcular y mostrar el promedio de temperaturas mínimas del país");
        System.out.println("3. Mostrar todas las ciudades que tienen temperaturas mínimas bajo 0 grados");
        System.out.println("4. Mostrar todas las ciudades que tienen temperaturas mínimas mayores a 7 grados");
        System.out.println("Ingrese cualquier otro numeor para terminar");
        opcion = TecladoIn.readLineInt();
        return opcion;
    }
}
