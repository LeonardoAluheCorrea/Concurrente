/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoObligatorio;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class TestInmobiliaria {
    public static void main(String[]args){
        Propiedad prop;
        int opcion;
        prop = new Propiedad(1);
        do{
            menu();
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                case 1:
                    cargarDato(prop);
                    break;
                case 2 :
                    System.out.println(prop.toString());
                    break;
                case 3:
                    if(verificarCasa(prop))
                        System.out.println(prop.toString());
                    else
                        System.out.println("La propiedad no cumple las condiciones dadas");
                    break;
                case 4:
                    if(verificarDepartamento(prop))
                        System.out.println(prop.toString());
                    else
                        System.out.println("La propiedad no cumple las condiciones dadas");
            }
        }while (opcion < 5 && opcion > 0);
    }
    
    public static void menu(){
        System.out.println("1. Cargar datos de una propiedad");
        System.out.println("2. Listar los datos de la propiedad");
        System.out.println("3. Verificar si la propiedad es una casa a la venta con de mas de 100 metros cuadrados, si lo es, listarla");
        System.out.println("4. Verificar si la propiedad es un departamento en alquiler con 1 ambiente y por menos de 20000, si lo es, listarla");
    }
    
    
    public static boolean verificarCasa(Propiedad p){
        return p.getDisponibilidad() && p.getTipo() == 'c' && p.getSuperficie() > 100
                && p.getOperacion() == 'v';
    }
    public static boolean verificarDepartamento (Propiedad p){
        return p.getTipo() == 'd' && p.getOperacion() == 'a' && p.getCantAmbientes() == 1 && p.getPrecio() < 20000;
    }
    
    public static void cargarDato(Propiedad prop){
        System.out.println("Ingrese la direccion");
        prop.setDireccion(TecladoIn.readLine());
        System.out.println("Ingrese true o false dependiendo si la propiedad esta disponible");
        prop.setDisponibilidad(TecladoIn.readLineBoolean());
        System.out.println("Ingrese el tipo de operacion a realizar con la propiedad");
        prop.setOperacion(TecladoIn.readNonwhiteChar());
        System.out.println("Ingrese el precio");
        prop.setPrecio(TecladoIn.readLineInt());
        System.out.println("Ingrese la superficie en metros cuadrados");
        prop.setSuperficie(TecladoIn.readLineInt());
        System.out.println("Ingrese la cantidad de ambientes");
        prop.setCantAmbientes(TecladoIn.readLineInt());
        System.out.println("Ingrese el tipo de propiedad");
        prop.setTipo(TecladoIn.readNonwhiteChar());
    }
    
}
