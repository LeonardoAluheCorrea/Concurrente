/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.FuncionalidadEInterfaz;
import TDAEspecificos.GrafoEtiquetado;
import TDAEspecificos.Diccionario;
import trabajofinal.Objetos.ClavePersona;
import java.util.HashMap;
import Utiles.TecladoIn;
import java.io.IOException;
import lineales.dinamicas.Lista;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.aniadirALog;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.cargarDatos;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.cargarDatosAeropuerto;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.cargarDatosCliente;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.cargarDatosPasaje;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.cargarDatosVuelo;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.eliminarAeropuerto;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.eliminarCliente;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.eliminarPasaje;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.eliminarVuelo;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.modificarAeropuerto;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.modificarCliente;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.modificarPasaje;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.modificarVuelo;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.obtenerCiudadesVisitadas;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.obtenerClientesFieles;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.obtenerContactoCliente;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.obtenerRangoCodigos;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.obtenerVueloEnFecha;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.rutaMasRapida;
import static trabajofinal.FuncionalidadEInterfaz.Funcionalidad.verificarRuta;
/**
 *
 * @author Leo
 */
public class EDATViajes {
    
    public static void main(String[]args) throws IOException{
        GrafoEtiquetado mapaAeropuertos;
        HashMap <ClavePersona, Lista> pasajesComprados;
        Diccionario tablaVuelos, tablaClientes;
        int continuar;
        pasajesComprados = new HashMap <>();
        tablaClientes = new Diccionario();
        tablaVuelos = new Diccionario();
        mapaAeropuertos = new GrafoEtiquetado();
        continuar = menuGeneral();
        while (continuar < 11){
            switch(continuar){
                case 1:
                    menuABMAeropuertos(mapaAeropuertos);
                    break;
                case 2:
                    menuABMVuelos(tablaVuelos, mapaAeropuertos);
                    break;
                case 3: 
                    menuABMPasajes(tablaClientes, tablaVuelos, pasajesComprados);
                    break;
                case 4:
                    menuABMClientes(tablaClientes, pasajesComprados);
                    break;
                case 5:
                    menuConsultasClientes(mapaAeropuertos, tablaVuelos, tablaClientes, pasajesComprados);
                    break;
                case 6: 
                    menuConsultasVuelos(tablaVuelos);
                    break;
                case 7:
                    menuConsultasTiemposViaje(mapaAeropuertos);
                    break;
                case 8:
                    System.out.println(obtenerClientesFieles(pasajesComprados, tablaClientes).toString());
                    break;
                case 9:
                    mostrarSistema(tablaVuelos, tablaClientes, mapaAeropuertos, pasajesComprados);
                    break;
                case 10:
                    cargarDatos(mapaAeropuertos, tablaVuelos, tablaClientes, pasajesComprados);
                    break;
            }
            continuar = menuGeneral();
        }
        //Al terminar ponemos todas las estructuras en el LOG
        if (continuar >= 11){
            aniadirALog(mapaAeropuertos.toString() + "\n\n" + tablaVuelos.toString() + "\n\n" + tablaClientes.toString() + "\n\n");
            pasajesComprados.forEach((ClavePersona k, Lista v) -> {
                aniadirALog(k.toString() + v.toString() + "\n");
            });
        }
    }
       
    
    
    
    public static void mostrarSistema(Diccionario tablaVuelos, Diccionario tablaClientes, GrafoEtiquetado mapa, HashMap <ClavePersona, Lista> pasajesComprados){
        //Convierte todas las estructuras a String y muestra el contenido por pantalla
        System.out.println("Mapa de aeropuertos:\n" + mapa.toString());
        System.out.println("\n");
        System.out.println("Tabla de clientes:\n" + tablaClientes.toString());
        System.out.println("\n");
        System.out.println("Tabla de vuelos:\n" + tablaVuelos.toString());
        System.out.println("\n");
        System.out.println("Mapeo pasajes comprados:\n" );
        pasajesComprados.forEach((ClavePersona k, Lista v)  -> {
            System.out.println(k.toString() + v.toString() + "\n");
        });
        System.out.println("\n");
    }
    
    public static int menuGeneral(){
        int opcion;
        System.out.println("1. Menu ABM Aeropuerto");
        System.out.println("2. Menu ABM Vuelos");
        System.out.println("3. Menu ABM Pasajes");
        System.out.println("4. Menu ABM Clientes");
        System.out.println("5. Menu de consultas sobre clientes");
        System.out.println("6. Menu de consultas sobre vuelos");
        System.out.println("7. Menu de consultas sobre tiempos de viaje");
        System.out.println("8. Obtener un listado de los clientes que mas pasajes han comprado ordenado de mayor a menor ");
        System.out.println("9. Mostrar sistema");
        System.out.println("10. REALIZAR CARGA INICIAL POR TXT");
        System.out.println("11. Salir");
        opcion = TecladoIn.readLineInt();
        return opcion;
    }
    

    
    public static void menuConsultasTiemposViaje(GrafoEtiquetado mapa){
        int opcion;
        Lista ruta;
        System.out.println("1. Dados dos aeropuertos A y B, mostrar si es posible que el cliente que parte del\n" +
        "aeropuerto A llegue al B en como máximo X vuelos");
        System.out.println("2. Dados dos aeropuertos A y B, obtener el camino que llegue de A a B en menor tiempo\n" +
        "de vuelo");
        System.out.println("3. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1:
                ruta = verificarRuta(mapa);
                if (ruta.longitud() > 1){
                    System.out.println("La siguiente ruta es la mas corta: " + ruta.toString());
                }
                else{
                    System.out.println("No se puede hacer en menos vuelos que los pedidos");   
                }
                break;
            case 2: 
                ruta = rutaMasRapida(mapa);
                if (ruta.longitud() < 1){
                    System.out.println("No existe ruta entre los aeropuertos dados");
                }
                else{
                    System.out.println("La ruta mas rapida es: " + ruta.toString());
                }
                break;
        }
    }
    
    public static void menuConsultasVuelos(Diccionario tablaVuelos){
        int opcion;
        System.out.println("1. Dado un código de vuelo y una fecha, mostrar toda la información del mismo");
        System.out.println("2. Dados dos códigos de vuelo, mostrar todos los códigos existentes que están en el\n" +
                                "rango entre el menor y el mayor de ambos códigos");
        System.out.println("3. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1:
                System.out.println(obtenerVueloEnFecha(tablaVuelos));
                break;
            case 2: 
                System.out.println(obtenerRangoCodigos(tablaVuelos));
                break;
        }
    }
    
    public static void menuConsultasClientes(GrafoEtiquetado mapaAeropuertos,Diccionario tablaVuelos, Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados){
        int opcion;
        System.out.println("1. Dado tipo y Nro de DNI, verificar y mostrar información de contacto de un cliente,\n" +
                                "incluyendo un listado de los pasajes comprados pendientes de volar");      
        System.out.println("2. Dado un cliente, mostrar qué ciudades ha visitado, según su historial de vuelos");
        System.out.println("3. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1:
                System.out.println(obtenerContactoCliente(tablaClientes, pasajesComprados));
                break;
            case 2:
                System.out.println(obtenerCiudadesVisitadas(mapaAeropuertos, tablaVuelos, pasajesComprados));
                break;
        }
    }
    
    
    public static void menuABMClientes(Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados){
        int opcion;
        System.out.println("1. Agregar un cliente");
        System.out.println("2. Eliminar un cliente");
        System.out.println("3. Modificar un cliente");
        System.out.println("4. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1:
                //Agregamos un cliente
                if(cargarDatosCliente(tablaClientes, pasajesComprados)){
                    System.out.println("El cliente se agrego correctamente");
                }
                else{
                    System.out.println("No se pudo agregar el cliente");
                }
                break;
            case 2:
                //Eliminamos un cliente
                if(eliminarCliente(tablaClientes, pasajesComprados)){
                    System.out.println("El cliente se elimino correctamente");
                }
                else{
                    System.out.println("No se pudo eliminar el cliente");
                }
                break;
            case 3:
                //Modificamos un cliente
                if (modificarCliente(tablaClientes)){
                    System.out.println("El cliente se modifico correctamente");
                }
                else{
                    System.out.println("No se pudo modificar el cliente");
                }
                break;
        }
    }
    
    public static void menuABMPasajes(Diccionario tablaClientes, Diccionario tablaVuelos, HashMap <ClavePersona, Lista> pasajesComprados){
        int opcion;
        System.out.println("1. Asociar un pasaje a un cliente");
        System.out.println("2. Desasociar un pasaje de un cliente");
        System.out.println("3. Modificar un pasaje");
        System.out.println("4. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1: 
                //Asociamos un pasaje a un cliente
                if (cargarDatosPasaje(tablaClientes, tablaVuelos, pasajesComprados)){
                    System.out.println("Pasaje se asocio a su cliente comprador con exito");
                }
                else{
                    System.out.println("No se puedo asociar el pasaje al cliente comprador");
                }
                break;
            case 2:
                //Eliminamos un pasaje de la lista de pasajes comprados por el cliente
                if (eliminarPasaje(pasajesComprados)){
                    System.out.println("El pasaje se elimino correctamente");
                }
                else{
                    System.out.println("No se pudo eliminar el pasaje");
                }
                break;
            case 3:
                //Modificamos un pasaje
                if (modificarPasaje(pasajesComprados, tablaVuelos)){
                    System.out.println("El pasaje fue modificado con exito");
                }
                else{
                    System.out.println("El pasaje no se pudo modificar");
                }
                break;
        }
    }
    
    public static void menuABMVuelos (Diccionario tablaVuelos, GrafoEtiquetado mapaAeropuertos){
        int opcion;
        System.out.println("1. Agregar un vuelo");
        System.out.println("2. Eliminar un vuelo");
        System.out.println("3. Modificar un vuelo");
        System.out.println("4. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1:
                //Añadimos un vuelo
                if (cargarDatosVuelo(tablaVuelos, mapaAeropuertos)){
                    System.out.println("Se cargo el vuelo y el arco que lo representa correctamente");
                }
                else{
                    System.out.println("No se puedo cargar el vuelo");
                }
                break;
            case 2:
                //Eliminamos un vuelo
                if (eliminarVuelo(tablaVuelos, mapaAeropuertos)){
                        System.out.println("El vuelo y el arco que lo representa se eliminaron correctamente");
                }
                else{
                    System.out.println("No se pudo eliminar el vuelo");
                }
                break;
            case 3:
                //Modificamos un vuelo
                if (modificarVuelo(tablaVuelos, mapaAeropuertos)){
                    System.out.println("Se modifico el vuelo y el arco que lo representa correctamente");
                }
                else{
                    System.out.println("No se pudo modificar el vuelo");
                }
        }
    }
    
    public static void menuABMAeropuertos(GrafoEtiquetado mapaAeropuertos){
        int opcion;
        System.out.println("1. Agregar un aeropuerto");
        System.out.println("2. Eliminar un aeropuerto");
        System.out.println("3. Modificar un aeropuerto");
        System.out.println("4. Salir");
        opcion = TecladoIn.readLineInt();
        switch(opcion){
            case 1:
                //Añadimos un aeropuerto
                if (cargarDatosAeropuerto(mapaAeropuertos)){
                    System.out.println("Se cargo el aeropuerto exitosamente");
                }
                else{
                    System.out.println("No se pudo cargar el aeropuerto");
                }
                break;
            case 2:
                //Eliminamos un aeropuerto
                if (eliminarAeropuerto(mapaAeropuertos)){
                    System.out.println("Se elimino el aeropuerto exitosamente");
                }
                else{
                    System.out.println("No se pudo eliminar el aeropuerto");
                }
                break;
            case 3:
                //Modificamos los datos de un aeropuerto existente
                if (modificarAeropuerto(mapaAeropuertos)){
                    System.out.println("Se modifico el aeropuerto correctamente");
                }
                else{
                    System.out.println("No se pudo modificar el aeropuerto");
                }
                break;
        }
    }
    
    
    
}
