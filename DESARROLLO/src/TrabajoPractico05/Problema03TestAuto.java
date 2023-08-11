/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico05;
import Utiles.TecladoIn;
import ClasesTP5.Auto;
/**
 *
 * @author Leo
 */
public class Problema03TestAuto {
   public static void main (String[]args){
       Auto[]agencia;
       String pat, modelo;
       int cantAutos,opcion, km;
       System.out.println("Ingrese la cantidad de autos de la agencia");
       cantAutos = TecladoIn.readLineInt();
       agencia = new Auto[cantAutos];
       do{
           menu();
           opcion = TecladoIn.readLineInt();
           switch(opcion){
               case 1: 
                   loadCarArray(agencia);
                   break;
               case 2:
                   System.out.println("Ingrese la patente del auto que desea consultar");
                   pat = TecladoIn.readLineWord();
                   System.out.println(findCar(agencia,pat).toString());
                   break;
               case 3:
                   System.out.println("Ingrese el modelo de auto que desea");
                   modelo = TecladoIn.readLineWord();
                   alquilar(modelo,agencia);
                   break;
               case 4:
                   System.out.println("Ingrese la patente del auto a devolder");
                   pat = TecladoIn.readLineWord();
                   System.out.println("Ingrese el nuevo kilometraje del auto");
                   km = TecladoIn.readLineInt();
                   devolucion(agencia,pat,km);
                   break;
               case 5:   
                   mostrarDatos(agencia);
                   break;
               case 6:
                   mostrarDisponible(agencia);
                   break;
           }
       }
       while(opcion != 7);
   } 
   
   public static void mostrarDisponible(Auto[]vector){
       //Muestra los datos de los autos que estan disponibles
       int tamaño;
       tamaño = vector.length;
       for (int i = 0; i < tamaño; i++){
           if(vector[i].getDisponible())
               System.out.println(vector[i].toString());
       }
}
   
   public static void mostrarDatos(Auto[]vector){
       //Muestra los datos de todos los autos de la agencia
       int tamaño;
       tamaño = vector.length;
       for (int i = 0; i < tamaño; i++){
           System.out.println(vector[i].toString());
       }
   }
   
   public static void devolucion(Auto[]vector, String pat, int km){
       //Busca el auto que entra por parametro, lo marca como disponible y le añade el nuevo kilometraje
       int tamaño, i;
       boolean continuar;
       Auto devuelto;
       devuelto = new Auto(pat);
       tamaño = vector.length;
       i = 0;
       do{
           continuar = vector[i].equals(devuelto);
           if (continuar){
               vector[i].setDisponible(true);
               vector[i].setCuentaKm(km);
           }
       }
       while(i < tamaño && !continuar);
   }
   
   public static void alquilar(String modelo, Auto[]vector){
       //Busca el auto del modelo ingresado por parametro y lo marca como no disponible
       int i, tamaño;
       boolean continuar;
       tamaño = vector.length;
       i = 0;
       do{
           continuar = vector[i].getModelo().equalsIgnoreCase(modelo);
           if (continuar){
               vector[i].setDisponible(false);
               System.out.println("El auto fue alquilado con exito");
           }
           i++;
       }
       while(i < tamaño && !continuar);
       if (!continuar)
           System.out.println("No hay autos disponible de ese modelo");
   }
   
   public static Auto findCar(Auto[]vector, String pat){
       //Busca dentro de un arreglo de autos uno que tenga determinada patente
       int tamaño, i;
       Auto deseado;
       boolean continuar;
       deseado = new Auto(pat);
       i = 0;
       tamaño = vector.length;
       do{
           continuar = !deseado.equals(vector[i]);
           if (!continuar)
               deseado = vector[i]; 
           i++;
       }
       while(i < tamaño && continuar);
       return deseado;
   }
   
   
   public static void loadCarArray(Auto[]vector){
       int km, tamaño;
       String patente, modelo;
       boolean disp;
       tamaño = vector.length;
       for (int i = 0; i < tamaño; i++){
           System.out.println("Ingrese la patente del auto");
           patente = TecladoIn.readLineWord();
           System.out.println("Ingrese el kilometraje");
           km = TecladoIn.readLineInt();
           System.out.println("Ingrese el modelo");
           modelo = TecladoIn.readLineWord();
           System.out.println("Ingrese la disponibilidad del vehiculo. true si esta disponible, false si no lo esta");
           disp = TecladoIn.readLineBoolean();
           vector[i] = new Auto(patente,km,modelo,disp);
       }
   }
   
   public static void menu(){
       System.out.println("1. Cargar los datos de un auto");
       System.out.println("2. Listar los datos de un auto");
       System.out.println("3. Alquilar un auto de determinado modelo");
       System.out.println("4. Marcar la devolucion de un auto");
       System.out.println("5. Mostar todos los datos de todos los autos que posee la agencia");
       System.out.println("6. Mostar los datos de los autos que estan disponibles");
   }
}
