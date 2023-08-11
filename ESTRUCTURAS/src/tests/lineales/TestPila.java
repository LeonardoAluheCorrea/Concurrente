/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import lineales.dinamicas.Pila;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class TestPila {
    public static void main (String []args){
        //Todos los metodos deben probarse para 3 casos, pila llena, pila vacia, pila medio llena.
        /*El metodo equals en particular requiere de mas casos de prueba:
        *Los tres casos anteriores para pilas iguales
        *Pilas con topes distintos
        *Pilas distintas con topes iguales
        */
        char continuar;
        Pila pila;
        pila = new Pila();
        continuar = 's';
        while (continuar == 's'){
        switch (menu()){
            case 1:
                caso1(pila);
                break;
            case 2:
                caso2(pila);
                break;
            case 3:
                caso3(pila);
                break;
            case 4:
                pila.vaciar();
                break;
            case 5:     
                caso5(pila);
                break;
            case 6:
                caso6(pila);
                break;
            case 7:
                System.out.println(pila.toString());
                break;
            case 8:
                caso8(pila);
                break;                       
            case 9:
                caso9(pila);
                break;
        }
            System.out.println("Desea continuar s/n");
            continuar = TecladoIn.readNonwhiteChar();
        }
    }
    
    public static void caso9(Pila pila){
        if(esCapicua(pila))
            System.out.println("La pila es capicua");
        else
            System.out.println("La pila no es capicua");
    }
    
    public static boolean verificarDigitos (Pila pilaClon){
        //Este metodo verifica que la pila contenga solo digitos del 0 al 9
        boolean soloDigitos;
        int tope;
        tope = 0;
        soloDigitos = true;
        while (soloDigitos && pilaClon.esVacia() == false){
            tope = (int)pilaClon.obtenerTope();
            soloDigitos = tope <= 9 && tope >= 0;
            pilaClon.desapilar();
        }
        return soloDigitos;
    }
    
    public static boolean esCapicua(Pila pila){
        //Este metodo verifica si una pila es capicua
        //Utilizamos 2 pilas auxiliares
        boolean capicua;
        Pila pilaAuxiliar;
        Pila pilaAuxiliar2;
        pilaAuxiliar = new Pila();
        capicua = true;
        //Primero vemos que la pila contenga solo digitos del 0 al 9
        if(verificarDigitos(pila.clone())){
            //Ahora colocamos en la pila auxiliar los elementos de la pila original, comenzando por el tope
            //Usamos un clon de la pila para conservar los valores de la original
            //Como el metodo verificarDigitos vacia la pila que le enviamos, debemos crear otra copia de la pila
            pilaAuxiliar2 = pila.clone();
            while(pilaAuxiliar2.esVacia() == false){
                pilaAuxiliar.apilar((int)pilaAuxiliar2.obtenerTope());
                pilaAuxiliar2.desapilar();
            }
            capicua = pila.equals(pilaAuxiliar);
        }
        else{
            System.out.println("La pila debe contener solo digitos del 0 al 9");
            capicua = false;
        }
        return capicua;
    }
    
    public static void caso8 (Pila pila){
        //realiza la octava opcion del menu
        if(pila.obtenerTope() == null)
            System.out.println("La pila esta vacia");
        else
            System.out.println("El tope es "+pila.obtenerTope());
    }
    
    public static void caso6 (Pila pila){
        //realiza la sexta opcion del menu
        int n;
        Pila pila2;
        pila2 = new Pila();
        System.out.println("Generamos una nueva pila para comparar con la anterior");
        System.out.println("Cuantos datos desea cargar en ella? max = 5");
        n = TecladoIn.readLineInt();
        for (int i = 0; i < n; i++){
            System.out.println("Ingrese un numero entero");
            pila2.apilar(TecladoIn.readLineInt());
        }
        if(pila.equals(pila2))
            System.out.println("La primer pila es igual a la segunda");
        else{
            System.out.println("Las pilas son distintas");
            System.out.println("Pila1 "+pila.toString());
            System.out.println("Pila2 "+pila.toString());
        }
    }
    
    public static void caso5 (Pila pila){
        //realiza la quinta opcion del menu
        if (pila.esVacia())
            System.out.println("La pila se encuentra vacia");
        else
            System.out.println("La pila no esta vacia");
    }
    
    public static void caso3 (Pila pila){
        //realiza el tercera opcion del menu
        //antes de probar esto debemos asegurarnos que funcione correctamene el metodo equals
        Pila pila2;
        pila2 = pila.clone();
        if(pila.equals(pila2))
            System.out.println("La pila se clono correctamente");
        else{
            System.out.println("La pila no se clono correctamente");
            System.out.println("Esta es la copia "+ pila2.toString()+" y esta la original "+ pila.toString());
        }
    }
    
    public static void caso2(Pila pila){
        //realiza la segunda opcion del menu
        if (pila.desapilar())
            System.out.println("El ultimo elemento de la pila se quito exitosamente");
        else
            System.out.println("No se pudo quitar un dato porque la pila esta vacia");
    }
    
    public static void caso1(Pila pila){
        //realiza la primera opcion de menu
        int i;
        System.out.println("Ingrese un numero entero");
        if (pila.apilar(TecladoIn.readLineInt()))
            System.out.println("El dato se apilo exitosamente");
        else
            System.out.println("El dato no se pudo apilar porque la pila esta llena");
    }

    public static int menu(){
        int eleccion;
        System.out.println("1. Apilar un dato");
        System.out.println("2. Desapilar un dato");
        System.out.println("3. Clonar la pila");
        System.out.println("4. Vaciar la pila");
        System.out.println("5. Verificar que la pila esta vacia");
        System.out.println("6. Ver si dos pilas son iguales");
        System.out.println("7. Listar todos los datos de la pila");
        System.out.println("8. Obtener el tope de la pila");
        System.out.println("9. Ver si la pila es capicua");
        eleccion = TecladoIn.readLineInt();
        return eleccion;
    }
}
