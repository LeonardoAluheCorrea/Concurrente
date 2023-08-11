/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.FuncionalidadEInterfaz;

import TDAEspecificos.Diccionario;
import TDAEspecificos.GrafoEtiquetado;
import trabajofinal.Objetos.Aeropuerto;
import trabajofinal.Objetos.ClavePersona;
import trabajofinal.Objetos.Cliente;
import trabajofinal.Objetos.Pasaje;
import trabajofinal.Objetos.Viaje;
import trabajofinal.Objetos.Vuelo;
import Utiles.TecladoIn;
import conjuntistas.Heap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import lineales.dinamicas.Lista;

/**
 *
 * @author Leo
 */
public class Funcionalidad {
    public static boolean eliminarVuelo(Diccionario tablaVuelos, GrafoEtiquetado mapa){
        //tablaVuelos es el diccionario de donde eliminaremos un vuelo
        //mapa es el mapa de aeropuertos. Deberemos eliminar la ruta que representa al vuelo
        boolean exito;
        String codigo;
        exito = false;
        System.out.println("Ingrese el codigo del vuelo");
        codigo = TecladoIn.readLine();
        //Chequeamos que el codigo sea valido
        if (codigo.length() == 6){
            //Antes de eliminar el vuelo lo guardamos, para poder obtener los aeropuertos de origen, destino y su duracion
            Vuelo porEliminar;
            porEliminar = (Vuelo) tablaVuelos.obtenerInformacion(codigo);
            //Chequeamos que porEliminar no sea null
            if (porEliminar != null){
                //Como porEliminar no es null quiere decir que el vuelo existe en la estructura
                //Eliminamos el vuelo
                exito = tablaVuelos.eliminar(codigo);
                //Luego eliminamos las rutas que lo representan en el mapa de aeropuertos
                exito = exito && mapa.eliminarArco(new Aeropuerto(porEliminar.getOrigen()),
                        new Aeropuerto(porEliminar.getDestino()), porEliminar.getHoraLlegada() - porEliminar.getHoraSalida());
                //Si se elimino correctamente damos aviso al log
                if(exito){
                    String aviso = "Se elimino el vuelo: " + porEliminar.toString() + "\n";
                    aniadirALog(aviso);
                }
            }
            //Si porEliminar es null entonces significa que el vuelo no esta en la estructura, por lo tanto no es necesario hacer ningun cambio
        }
        return exito;
    }
    
    public static boolean modificarVuelo(Diccionario tablaVuelos, GrafoEtiquetado mapa){
        //Permite modificar los atributos de un vuelo
        //tablaVuelos es el diccionario que contiene nuestros vuelos
        //mapa es el mapa de aeropuertos.
        boolean exito;
        String codigo;
        exito = false;
        System.out.println("Ingrese el codigo del vuelo que desea modificar");
        codigo = TecladoIn.readLine();
        //Verificamos el largo del codigo para no hacer un recorrido innecesario del diccionario
        if (codigo.length() == 6){
            //Usamos el codigo para buscar el objeto en el diccionario
            Vuelo porModificar;
            porModificar = (Vuelo) tablaVuelos.obtenerInformacion(codigo); 
            //Chequeamos que el vuelo no sea null
            if (porModificar != null){
                int opcion;
                //Si no es null entonces se puede modificar
                String nombreOrigenViejo, nombreDestinoViejo;
                int horaSalidaVieja, horaLlegadaVieja;
                boolean modificado;
                //Guardamos los valores actuales del vuelo
                //Usaremos una variable boolean para saber si las cosas han sido modificadas
                nombreOrigenViejo = porModificar.getOrigen();
                nombreDestinoViejo = porModificar.getDestino();
                horaSalidaVieja = porModificar.getHoraSalida();
                horaLlegadaVieja = porModificar.getHoraSalida();
                modificado = false;
                opcion = 1;
                while (opcion < 5){
                    System.out.println("1. Modificar el aeropuerto de origen");
                    System.out.println("2. Modificar el aeropuerto de destino");
                    System.out.println("3. Modificar la hora de salida y llegada");
                    System.out.println("4. Anadir viajes");
                    System.out.println("5. Salir");
                    opcion = TecladoIn.readLineInt();
                    switch(opcion){
                        case 1:
                            String origenNuevo;
                            System.out.println("Ingrese el nuevo aeropuerto de origen");
                            origenNuevo = TecladoIn.readLine();
                            //Chequeamos que el nombre sea valido
                            if (origenNuevo.length() == 3){
                                //Chequeamos que el aeropuerto nuevo este en el mapa de aeropuertos
                                if (mapa.existeVertice(new Aeropuerto(origenNuevo))){
                                    //Colocamos el nuevo aeropuerto de origen al vuelo
                                    porModificar.setOrigen(origenNuevo);
                                    modificado = true;
                                }
                                else{
                                    System.out.println("Error. El aeropuerto nuevo no esta en el mapa de aeropuertos");
                                }
                            }
                            break;
                        case 2: 
                            String destinoNuevo;
                            System.out.println("Ingrese el nuevo aeropuerto de destino");
                            destinoNuevo = TecladoIn.readLine();
                            //Chequeamos que el nombre sea valido
                            if (destinoNuevo.length() == 3){
                                //Chequeamos que el aeropuerto de origen este en el mapa de aeropuertos
                                    if (mapa.existeVertice(new Aeropuerto(destinoNuevo))){
                                    //Colocamos el nuevo aeropuerto de destino al vuelo
                                    porModificar.setDestino(destinoNuevo);
                                    modificado = true;
                                    }
                                    else{
                                        System.out.println("Error. El aeropuerto nuevo no esta en el mapa de aeropuertos");
                                    }
                            }
                            break;
                        case 3:
                            int horaLlegadaNueva, horaSalidaNueva;
                            System.out.println("Ingrese la nueva hora de salida");
                            horaSalidaNueva = TecladoIn.readLineInt();
                            System.out.println("Ingrese la nueva hora de llegada");
                            horaLlegadaNueva = TecladoIn.readLineInt();
                            //Chequeamos que la hora de salida sea menor a la hora de llegada
                            if (horaSalidaNueva < horaLlegadaNueva){
                                //Añadimos los nuevos horarios al vuelo
                                porModificar.setHoraLlegada(horaLlegadaNueva);
                                porModificar.setHoraSalida(horaSalidaNueva);
                                modificado = true;
                            }
                            break;
                        case 4:
                            //Llamamos otro mensaje para añadir los viajes al vuelo
                            agregarViajesAVuelo(porModificar);
                            exito = true;
                            break;
                    }
                }
                //Una vez hechas las modificaciones al vuelo debemos modificar la ruta en el mapa de aeropuertos
                //Debemos cambiar la ruta entre aeropuertos y la etiqueta que marca la duracion del vuelo 
                int duracionVuelo;
                //Calculamos la duracion aproximada del vuelo en minutos
                duracionVuelo = porModificar.getHoraLlegada() - porModificar.getHoraSalida();
                //Nos fijamos si el vuelo fue modificado
                if (modificado){
                    //Como fue modificado entonces debemos eliminar la ruta vieja, añadir la nueva y actualizar la duracion del vuelo
                    mapa.eliminarArco(new Aeropuerto(nombreOrigenViejo), new Aeropuerto(nombreDestinoViejo), horaLlegadaVieja - horaSalidaVieja);
                    mapa.insertarArco(new Aeropuerto(porModificar.getOrigen()), new Aeropuerto(porModificar.getDestino()), duracionVuelo);
                    //Avisamos la modificacion por el log
                    String aviso = "El vuelo: " + new Vuelo(porModificar.getCodigo(), nombreOrigenViejo, nombreDestinoViejo, horaSalidaVieja, horaLlegadaVieja)
                            + "  fue modificado. Nuevo vuelo: " + porModificar.toString() + "\n";
                    aniadirALog(aviso);
                    exito = true;
                }
            }
        }
        return exito;
    }
    
    public static boolean cargarDatosVuelo(Diccionario tablaVuelos, GrafoEtiquetado mapa){
        //Solicita al usuario los datos para añadir un vuelo y llama a otro mensaje para añadir este vuelo
        String codigo, origen, destino;
        int horaSalida, horaLlegada;
        boolean exito;
        exito = false;
        System.out.println("Ingrese el codigo del vuelo");
        codigo = TecladoIn.readLine();
        //Chequeamos que el codigo sea de largo valido
        //Chequeamos el vuelo no exista antes de pedir mas datos
        if (codigo.length() == 6 && tablaVuelos.obtenerInformacion(codigo) == null){
            System.out.println("Ingrese el nombre aeronautico del aeropuerto de origen");
            origen = TecladoIn.readLine();
            //Chequeamos que el nombre sea de largo valido
            if (origen.length() == 3){
                System.out.println("Ingrese el nombre aeronautico del aeropuerto de destino");
                destino = TecladoIn.readLine();
                //Chequeamos que sea valido
                if(destino.length() == 3){
                    System.out.println("Ingrese la hora de salida del vuelo. EJ: 1430 serian las 2:30 pm, 0600 las 6 am");
                    horaSalida = TecladoIn.readLineInt();
                    System.out.println("Ingrese la hora de llegada del vuelo. EJ: 1430 serian las 2:30 pm, 0600 las 6 am");
                    horaLlegada = TecladoIn.readLineInt();
                    //Chequeamos que la hora de salida sea > a la de llegada
                    if (horaSalida < horaLlegada){
                        Vuelo nuevo;
                        nuevo = new Vuelo(codigo,origen,destino,horaSalida,horaLlegada);
                        exito = agregarVuelo(tablaVuelos, mapa, nuevo);
                    }
                }
            }
        }
        return exito;
    }
    
    public static void agregarViajesAVuelo(Vuelo unVuelo){
        //Añade viajes a la lista de viajes que tiene cada vuelo
        //unVuelo es el vuelo al cual le vamos a añadir viajes
        char opcion;
        System.out.println("Cada vuelo cuenta con una lista de los viajes que realiza. Desea añadir mas viajes? s/n ");
        opcion = TecladoIn.readLineNonwhiteChar();
        if (opcion == 's'){
            String fecha;
            Viaje nuevo;
            int asientosTotales, asientosVendidos;
            while (opcion == 's'){
                System.out.println("Ingrese la fecha del viaje. Formato año-mes-dia. EJ: 2020-09-21");
                fecha = TecladoIn.readLine();
                System.out.println("Ingrese la cantidad total de asientos del vuelo");
                asientosTotales = TecladoIn.readLineInt();
                System.out.println("Ingrese la cantidad de asientos que fueron vendidos");
                asientosVendidos = TecladoIn.readLineInt();
                //Chequeamos que la cantidad de asientos vendidos sea <= que la cantidad total de asientos
                if (asientosVendidos <= asientosTotales){
                        //Añadimos el viaje a la lista de viajes del vuelo y avisamos al log
                        nuevo = new Viaje(fecha, asientosTotales, asientosVendidos);
                        String aviso = "Se añadio el viaje: " + nuevo.toString() + "  en el vuelo: " + unVuelo.toString() + "\n";
                        unVuelo.addViaje(nuevo);
                        aniadirALog(aviso);
                }
                else{
                    System.out.println("Datos invalidos. No puede haber mas asientos vendidos que totales");
                }
                System.out.println("Desea ingresar otro viaje para este vuelo. s/n");
                opcion = TecladoIn.readLineNonwhiteChar();
            }
        }
    }
    
    public static boolean agregarVuelo(Diccionario tablaVuelos, GrafoEtiquetado mapa, Vuelo nuevo){
        //Añade un vuelo al diccionario y la ruta que lo representa al mapa de aeropuertos
        //Todos los parametros salvo el diccionario son atributos del vuelo a agregar
        //tablaVuelos es el diccionario donde agregaremos el vuelo
        //mapa es el mapa de aeropuertos. Deberemos añadir una ruta entre los aeropuertos de origen y destino para representar el vuelo que se añada
        boolean exito;
        String origen, destino;
        origen = nuevo.getOrigen();
        destino = nuevo.getDestino();
        //Debemos calcular la duracion aproximada del vuelo para colocarla en la etiqueta del mapa de aeropuertos
        int duracionVuelo;
        duracionVuelo = nuevo.getHoraLlegada() - nuevo.getHoraSalida();
        exito = mapa.insertarArco(new Aeropuerto(origen), new Aeropuerto(destino), duracionVuelo);
        //Si el vuelo se añadio a mapa con exito ahora lo añadimos a la tabla de vuelos
        if (exito){
            //Llamamos otro mensaje para añadir los viajes de cada dia y avisamos en el log
            String aviso = "Se añadio el vuelo: " + nuevo.toString() + "\n";
            aniadirALog(aviso);
            agregarViajesAVuelo(nuevo);
            exito = tablaVuelos.insertar(nuevo.getCodigo(), nuevo);
        }
        return exito;
    }
    
    public static boolean modificarAeropuerto(GrafoEtiquetado mapa){
        //Modifica los datos de un aeropuerto determinado
        //mapa es el mapa de aeropuertos
        boolean exito;
        exito = false;
        String nombre, telefono, ciudad;
        System.out.println("Ingrese el nombre aeronautico");
        nombre = TecladoIn.readLine();
        //Chequeamos que el nombre sea valido
        if (nombre.length() == 3){
            //Buscamos el aeropuerto en el mapa
            Aeropuerto unAeropuerto;
            int opcion;
            unAeropuerto = (Aeropuerto) mapa.obtenerElemento(new Aeropuerto(nombre));
            if(unAeropuerto != null){
                opcion = 1;
                while (opcion < 3){
                    System.out.println("1. Modificar la ciudad");
                    System.out.println("2. Modificar el telefono");
                    System.out.println("3. Salir");
                    opcion = TecladoIn.readLineInt();
                    switch(opcion){
                        case 1:
                            System.out.println("Ingrese nueva ciudad del aeropuerto");
                            ciudad = TecladoIn.readLine();
                            unAeropuerto.setCiudad(ciudad);
                            exito = true;
                            break;
                        case 2:
                            System.out.println("Ingrese nuevo numero de telefono");
                            telefono = TecladoIn.readLine();
                            unAeropuerto.setNroTelefono(telefono);
                            exito = true;
                            break;               
                    }
                }
            }
        }
        return exito;
    }
    
    public static boolean eliminarAeropuerto(GrafoEtiquetado mapa){
        //Elimina un aeropuerto
        //mapa es el grafo de donde eliminaremos el aeropuerto
        boolean exito;
        String nombre;
        exito = false;
        System.out.println("Ingrese el nombre aeronautico del aeropuerto");
        nombre = TecladoIn.readLine();
        //Revisamos que sea valido
        if (nombre.length() == 3){
            //Revisamos que el aeropuerto no tenga arcos
            if (!mapa.tieneArco(new Aeropuerto(nombre))){
                exito = mapa.eliminarVertice(new Aeropuerto(nombre));
                //Si se añadio el vuelo escribimos en el log
                if (exito){
                    String aviso = "Se elimino el aeropuerto de clave: " + nombre + "\n";
                    aniadirALog(aviso);
                }
            }
            else{
                System.out.println("Eliminar primero los vuelos que van y vienen de este aeropuerto");
            }
        }
        return exito;
    }
    
    public static boolean cargarDatosAeropuerto(GrafoEtiquetado mapa){
        //Este modulo recibe los datos que ingrese el usuario y luego llama a otro mensaje para agregar el aeropuerto al mapa
        //mapa es nuestro mapa de aeropuertos
        boolean valido, exito;
        exito = false;
        String nombre, ciudad, telefono;
        System.out.println("Ingrese el nombre aeronautico del aeropuerto");
        nombre = TecladoIn.readLine();
        //Chequeamos que el nombre sea valido. Debe tener 3 caracteres
        valido = nombre.length() == 3;
        if (valido){
            System.out.println("Ingrese la ciudad donde se encuentra el aeropuerto");
            ciudad = TecladoIn.readLine();
            System.out.println("Ingrese el telefono del aeropuerto");
            telefono = TecladoIn.readLine();
            exito = agregarAeropuerto( nombre, ciudad, telefono, mapa);
        }
        return exito;
    }
    
    public static boolean agregarAeropuerto(String nombre, String ciudad, String telefono, GrafoEtiquetado mapa){
        //nombre, ciudad y telefono seran los atributos del Aeropuerto. 
        //mapa es el grafo donde insertaremos el aeropuerto
        boolean exito;
        Aeropuerto nuevo;
        nuevo = new Aeropuerto(nombre,ciudad,telefono);
        exito = mapa.insertarVertice(nuevo);
        //Si se añadio con exito entonces llamamos al mensaje que lo escribira en el log
        if (exito){
            String aviso = "Se añadio el aeropuerto: " + nuevo.toString() + "\n";
            aniadirALog(aviso);
        }
        return exito;
    }
     
    public static boolean cargarDatosPasaje(Diccionario tablaClientes, Diccionario tablaVuelos, HashMap <ClavePersona, Lista> pasajesComprados){
        //Solicita los datos para cargar un pasaje y llama a otro mensaje para cargarlo
        //tablaClientes es donde guardamos los clientes
        //tablaVuelos es donde guardamos los vuelos. Lo usaremos aqui para asegurarnos que el vuelo que esta en el pasaje exista
        //pasajesComprados es el mapeo donde guardamos los pasajes que va comprando cada cliente
        boolean exito;
        String tipoDni;
        int nroDni;
        exito = false;
        //Preguntamos los datos del cliente que compra el pasaje
        System.out.println("Ingrese el tipo de dni del cliente que compro el pasaje");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente que compro el pasaje");
        nroDni = TecladoIn.readLineInt();
        ClavePersona claveCliente;
        claveCliente = new ClavePersona(tipoDni, nroDni);
        //Ahora debemos asegurarnos que el cliente exista. Lo buscamos en tablaClientes
        if (tablaClientes.pertenece(claveCliente)){
            //Como el cliente existe podemos proceder a cargar los datos del pasaje
            String codigoVuelo;
            System.out.println("Ingrese el codigo vuelo correspondiente al pasaje");
            codigoVuelo = TecladoIn.readLine();
            //Chequeamos que sea valido
            if (codigoVuelo.length() == 6){
                //Ahora debemos asegurarnos que el vuelo exista. Lo buscamos en la tabla de vuelos
                if (tablaVuelos.pertenece(codigoVuelo)){
                    //Como el vuelo existe podemos cargar el resto de los datos
                    int nroAsiento;
                    String fecha;
                    String estado;
                    System.out.println("Ingrese el numero de asiento");
                    nroAsiento = TecladoIn.readLineInt();
                    System.out.println("Ingrese la fecha del vuelo. Formato año-mes-dia. EJ: 2020-02-23");
                    fecha = TecladoIn.readLine();
                    //Nos fijamos si existe un viaje en el vuelo que tenga esa fecha y con asientos libres
                    Pasaje nuevo;
                    nuevo = new Pasaje(nroAsiento, codigoVuelo, fecha, "pendiente");
                    exito = verificarCompraPasaje(tablaVuelos, nuevo);
                    if (exito){
                        //Asociamos el pasaje a su cliente comprador
                        exito = asociarPasaje(pasajesComprados, claveCliente, nuevo);
                    }
                }
            }
        }
        else{
            System.out.println("El cliente no existe");
        }
        return exito;
    }
    
    public static boolean verificarCompraPasaje(Diccionario tablaVuelos, Pasaje comprado){
        //Se fija si el pasaje comprado es valido, es decir, si el vuelo viaja en esa fecha y si hay asientos disponibles
        //tablaVuelos es donde estan guardados todos los vuelos
        //comprado es el pasaje que debemos verificar
        boolean exito;
        int i, tamanio;
        Vuelo porVolar;
        Lista viajes;
        exito = false;
        i = 1;
        //Buscamos el vuelo que esta en el pasaje
        porVolar = (Vuelo)tablaVuelos.obtenerInformacion(comprado.getVuelo());
        //Ahora revisamos su lista de viajes 
        viajes = porVolar.getViajes();
        tamanio = viajes.longitud();
        Viaje unViaje;
        while (i <= tamanio && !exito){
            unViaje = (Viaje) viajes.recuperar(i);
            exito = unViaje.getFecha().equals(comprado.getFecha()) && unViaje.getAsientosVendidos() + 1 < unViaje.getAsientosTotales();
            if (exito){
                //Actualizamos la cantidad de asientos vendidos para sumar el correspondiente al pasaje que acabamos de vender
                unViaje.setAsientosVendidos(unViaje.getAsientosVendidos() + 1);
            }
            i++;
        }
        if (!exito){
            System.out.println("No se puede comprar el pasaje especificado");
        }
        return exito;
    }
    
    public static boolean asociarPasaje(HashMap <ClavePersona, Lista> pasajesComprados, ClavePersona claveCliente, Pasaje comprado){
        //Asocia un pasaje a un pasaje al cliente que lo compro
        //pasajesComprados es el mapeo entre clientes y los pasajes que compran
        //claveCliente es el tipo y nro de dni del cliente que hizo la compra
        //comprado es el pasaje que debemos asociar al cliente
        boolean exito;
        Lista compras;
        //Buscamos la lista relacionada al cliente en el hashMap y le añadimos el pasaje
        compras = pasajesComprados.get(claveCliente);
        exito = compras.insertar(comprado, compras.longitud() + 1);
        //Si se asocio el pasaje entonces avisamos en el log
        if (exito){
            String aviso = "El cliente de clave: " + claveCliente.toString() + "  compro el pasaje: " + comprado.toString() + "\n";
            aniadirALog(aviso);
        }
        return exito;
    }
    
    public static boolean eliminarPasaje(HashMap <ClavePersona, Lista> pasajesComprados){
        //Elimina un pasaje de la lista de pasajes comprados por el cliente
        boolean exito;
        String tipoDni;
        int nroDni;
        Lista comprados;
        ClavePersona claveCliente;
        exito = false;
        //Pedimos la clave del cliente
        System.out.println("Ingrese el tipo de dni del cliente cuyo pasaje desea eliminar");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente cuyo pasaje desea eliminar");
        nroDni = TecladoIn.readLineInt();
        claveCliente = new ClavePersona(tipoDni,nroDni);
        //Usamos los datos para buscar en el hashMap la lista de pasajes comprados por el cliente
        comprados = pasajesComprados.get(claveCliente);
        //Chequeamos que la lista no sea nula (cliente inexistente) y que no este vacia
        if (comprados != null && !comprados.esVacia()){
            //Ahora solicitamos los datos del pasaje para poder eliminarlo de la lista
            int nroAsiento;
            Pasaje nuevo;
            String codigoVuelo, estado;
            String fecha;
            System.out.println("Ingrese el numero de asiento del pasaje");
            nroAsiento = TecladoIn.readLineInt();
            System.out.println("Ingrese el codigo del vuelo del pasaje");
            codigoVuelo = TecladoIn.readLine();
            System.out.println("Ingrese la fecha del pasaje. Formato año-mes-dia. Ej: 2023-12-23");
            fecha = TecladoIn.readLine();
            System.out.println("Ingrese el estado del pasaje. Pendiente/Volado/Cancelado");
            estado = TecladoIn.readLine();
            //Usando los datos eliminamos el pasaje de la lista
            nuevo = new Pasaje (nroAsiento, codigoVuelo, fecha, estado);
            exito = comprados.eliminar(comprados.localizar(nuevo));
            //Si se elimino el pasaje avisamos al log
            if (exito){
                String aviso = "Se elimino el pasaje: " + nuevo.toString() + "  del cliente con clave: " + claveCliente.toString() + "\n";
                aniadirALog(aviso);
            }
        }
        System.out.println("El cliente no existe, no tiene pasajes comprados o el pasaje que se quiere eliminar no existe");
        return exito;
    }
    
    public static boolean hacerModificacionPasaje(HashMap <ClavePersona, Lista> pasajesComprados, Diccionario tablaVuelos, Pasaje porModificar){
        //Modifica los datos de un pasaje
        //pasajesComprados es el mapeo entre clientes y pasajes compradosj
        //tablaVuelos es donde guardamos todos los vuelos
        //porModificar es el pasaje que vamos a modificar
        int opcion = 1;
        boolean exito;
        exito = false;
        while (opcion < 4){
            System.out.println("1. Modificar el numero de asiento");
            System.out.println("2. Modificar la fecha");
            System.out.println("3. Modificar el estado");
            System.out.println("4. Salir");
            opcion = TecladoIn.readLineInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nuevo numero de asiento");
                    porModificar.setNroAsiento(TecladoIn.readLineInt());
                    exito = true;
                    break;
                case 2: 
                    System.out.println("Ingrese la nueva fecha. Formato año-mes-dia. Ej: 2023-02-21");
                    porModificar.setFecha(TecladoIn.readLine());
                    exito = true;
                    break;
                case 3:
                    String estado;
                    System.out.println("Ingrese el nuevo estado. Pendiente/volado/cancelado");
                    estado = TecladoIn.readLine();
                    //Chequeamos que sea un estado valido antes de añadirlo
                    if(estado.equalsIgnoreCase("pendiente") || estado.equalsIgnoreCase("volado") || estado.equalsIgnoreCase("cancelado")){
                    porModificar.setEstado(estado);
                    exito = true;
                    }
                    else{
                        System.out.println("Estado invalido");
                    }
                    break;
            }
        }
        return exito;
    }
    
    public static boolean modificarPasaje(HashMap <ClavePersona, Lista> pasajesComprados, Diccionario tablaVuelos){
        //Modifica los datos de un pasaje que fue comprado por un cliente
        //pasajesComprados es el HashMap que contiene todos los clientes y sus listas de pasajes comprados
        //tablaVuelos es donde estan guardados todos nuestros vuelos
        boolean exito;
        exito = false;
        //Solicitamos los datos del cliente para buscarlo en el hashMap
        String tipoDni;
        int nroDni;
        System.out.println("Ingrese el tipo de dni del cliente cuyo pasaje desea modificar");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente cuyo pasaje desea modificar");
        nroDni = TecladoIn.readLineInt();
        ClavePersona claveCliente;
        claveCliente = new ClavePersona(tipoDni, nroDni);
        //Usando la clave del cliente obtenemos su lista de pasajes comprados
        Lista comprados;
        comprados = pasajesComprados.get(claveCliente);
        //Nos aseguramos que la lista no sea nula y que no este vacia
        if (comprados != null && !comprados.esVacia()){
            //Ahora debemos buscar el pasaje a modificar dentro de la lista
            int nroAsientos;
            String estado, codigoVuelo,fecha;
            System.out.println("Ingrese el numero de asientos del pasaje que desea modificar");
            nroAsientos = TecladoIn.readLineInt();
            System.out.println("Ingrese el codigo del vuelo del pasaje que desea modificar");
            codigoVuelo = TecladoIn.readLine();
            System.out.println("Ingrese la fecha del pasaje que desea modificar. Formato año-mes-dia. EJ: 2012-01-23");
            fecha = TecladoIn.readLine();
            System.out.println("Ingrese el estado del pasaje que desea modificar. Pendiente/volado/cancelado");
            estado = TecladoIn.readLine();
            //Chequeamos que sea una de las opciones dadas
            if(estado.equalsIgnoreCase("pendiente") || estado.equalsIgnoreCase("volado") || estado.equalsIgnoreCase("cancelado")){
                //Buscamos el pasaje en la lista de pasajes comprados del cliente
                Pasaje porModificar, sinModificar;
                int opcion;
                opcion = 1;
                porModificar = (Pasaje) comprados.recuperar(comprados.localizar(new Pasaje(nroAsientos, codigoVuelo, fecha, estado)));
                //recuperar() puede devolvernos un null, por lo tanto debemos chequear que este no sea el caso antes de continuar
                if (porModificar != null){
                    sinModificar = porModificar.clone();
                    exito = hacerModificacionPasaje(pasajesComprados,tablaVuelos,porModificar);
                    //Si el pasaje fue modificado con exito damos aviso al log
                    if (exito){
                        String aviso = "El pasaje: " + sinModificar.toString() + "  perteneciente al cliente de clave: " + claveCliente.toString()
                                + "  ha sido modificado. Nuevo pasaje: " + porModificar.toString() + "\n";
                        aniadirALog(aviso);
                    }
                }
            }
        }
        System.out.println("El cliente no existe o no tiene pasajes comprados o el pasaje pedido no existe");
        return exito;
    }
    
    public static boolean eliminarCliente(Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados){
        //Elimina un cliente
        //tablaClientes contiene a todos los clientes
        //pasajesComprados asocia a cada cliente con los pasajes que ha comprado
        boolean exito;
        String tipoDni;
        int nroDni;
        //Solicitamos ingresar los datos para formar la clave del cliente
        System.out.println("Ingrese el tipo de dni del cliente a eliminar");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente a eliminar");
        nroDni = TecladoIn.readLineInt();
        ClavePersona claveCliente;
        claveCliente = new ClavePersona(tipoDni, nroDni);
        //Buscamos al cliente en la tabla y lo eliminamos
        exito = tablaClientes.eliminar(claveCliente);
        //Si se pudo eliminar el cliente, o sea que existia en la tabla entonces lo eliminamos tambien del hashMap
        if (exito){
            //Eliminamos al cliente del hashMap
            //Junto con el cliente se elimina el historial de compras
            //Escribimos en el log
            String aviso = "Se elimino el cliente de clave: " + claveCliente.toString() + "\n";
            aniadirALog(aviso);
            pasajesComprados.remove(claveCliente);
        }
        return exito;
    }
    
    public static boolean cargarDatosCliente(Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados){
        //Carga los todos los datos de un cliente
        //tablaClientes es donde guardamos todos los clientes
        //pasajesComprados es donde cada cliente esta asociado a los pasajes que ha comprado
        boolean exito;
        String tipoDni;
        int nroDni;
        //Pedimos los datos para formar la clave del cliente
        System.out.println("Ingrese el tipo de dni del cliente");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente");
        nroDni = TecladoIn.readLineInt();
        //Creamos una clave con los datos recibidos
        ClavePersona claveCliente;
        claveCliente = new ClavePersona(tipoDni, nroDni);
        //Ahora pedimos el resto de los datos para crear el cliente
        String nroTelefono, nombreApellido, domicilio, fechaNacimiento;
        System.out.println("Ingrese el numero de telefono del cliente");
        nroTelefono = TecladoIn.readLine();
        System.out.println("Ingrese el nombre y apellido del cliente");
        nombreApellido = TecladoIn.readLine();
        System.out.println("Ingrese el domicilio del cliente");
        domicilio = TecladoIn.readLine();
        System.out.println("Ingrese la fecha de nacimiento del cliente. Formato año-mes-dia. Ej: 2020-11-02");
        fechaNacimiento = TecladoIn.readLine();
        //Creamos el cliente
        Cliente nuevo;
        nuevo = new Cliente(claveCliente, nroTelefono, domicilio, nombreApellido, fechaNacimiento);
        //Ahora llamamos otro mensaje para agregar el cliente
        exito = agregarCliente(tablaClientes, pasajesComprados, nuevo);
        return exito;
    }
    
    public static boolean agregarCliente(Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados, Cliente nuevo){
        //Agrega un cliente en ambas estructuras de datos
        //tablaClientes es la tabla donde estan guardados todos los clientes
        //pasajesComprados es donde cada cliente esta asociado a los pasajes que ha comprado
        //nuevo es el cliente que vamos a agregar 
        boolean exito;
        ClavePersona claveCliente;
        claveCliente = nuevo.getClave();
        //Primero lo agregamos a la tabla de clientes
        exito = tablaClientes.insertar(claveCliente, nuevo);
        //Si se pudo añadir el cliente, entonces ahora lo añadimos al hashMap y escribimos en el log
        if (exito){
            String aviso = "Se añadio el cliente : " + nuevo.toString() + "\n";
            aniadirALog(aviso);
            //Añadimos la clave del cliente con una lista vacia
            pasajesComprados.put(claveCliente, new Lista());
        }
        return exito;
    }
    
    public static Lista obtenerClientesFieles(HashMap <ClavePersona, Lista> pasajesComprados, Diccionario tablaClientes){
        //Nos devuelve una lista de clientes ordenada de mayor a menor con el cuarto de clientes que mas pasajes a comprado
        //pasajesComprados es donde cada cliente esta asociado a los pasajes que ha comprado
        //tablaClientes es donde se guardan todos los clientes
        Lista clientesConMasPasajes, clavesConMasPasajes;
        clientesConMasPasajes = new Lista();
        clavesConMasPasajes = new Lista();
        //Usamos un heap auxiliar para ordenar las cantidades de compra de mayor a menor (heapsort)
        //Nota. Se modifico la implementacion del heap para que sea maximo
        Heap auxiliar;
        auxiliar = new Heap();
        pasajesComprados.forEach((ClavePersona k, Lista v) -> auxiliar.insertar(v.longitud()));
        //Al insertarse en el heap maximo los elementos nos quedan ordenados de mayor a menor
        //Ahora para los numeros que tenemos en el heap buscamos una clave de cliente que haya comprado esa cantidad de pasajes
        while (clavesConMasPasajes.longitud() < pasajesComprados.size() / 4 ){
            pasajesComprados.forEach((ClavePersona k, Lista v)-> {
                if ((int)auxiliar.recuperarCima() == v.longitud() && clavesConMasPasajes.longitud() < pasajesComprados.size() / 4){
                    clavesConMasPasajes.insertar(k, clavesConMasPasajes.longitud() + 1);
                    auxiliar.eliminarCima();
                }
            });               
        }
        //Ahora usando las claves, que estan ordenadas de mayor a menor dependiendo la cantidad de pasajes comprados, podemos obtener los clientes
        ClavePersona clave;
        Cliente unCliente;
        for (int i = 1; i <= clavesConMasPasajes.longitud(); i++){
            clave = (ClavePersona) clavesConMasPasajes.recuperar(i);
            unCliente = (Cliente) tablaClientes.obtenerInformacion(clave);
            clientesConMasPasajes.insertar(unCliente, clientesConMasPasajes.longitud() + 1);
        }
        return clientesConMasPasajes;
    }
    public static boolean modificarCliente(Diccionario tablaClientes){
        //Modifica los datos de un cliente
        //tablaClientes es donde guardamos todos los clientes
        //pasajesComprados es donde guardamos la asociacion de cada cliente con los pasajes que ha comprado
        String tipoDni;
        int nroDni;
        boolean exito;
        exito = false;
        //Solicitamos ingresar los datos para formar la clave del cliente
        System.out.println("Ingrese el tipo de dni del cliente a modificar");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente a modificar");
        nroDni = TecladoIn.readLineInt();
        //Buscamos al cliente con esa clave
        Cliente porModificar, sinModificar;
        porModificar = (Cliente) tablaClientes.obtenerInformacion(new ClavePersona(tipoDni, nroDni));
        //Obtener informacion devuelve un null si el cliente no existe en la tabla asi que debemos chequear que este no sea el caso antes de continuar
        if (porModificar != null){
            //Llamamos a otro mensaje para presentar y realizar las opciones de modificacion
            sinModificar = (Cliente) porModificar.clone();
            exito = opcionesModificacionCliente(porModificar);
            if (exito){
                //Si se modifico con exito damos aviso al LOG
                String aviso = "Se modifico el cliente: " + sinModificar.toString() + "Nuevo cliente: " + porModificar.toString() + "\n";
                aniadirALog(aviso);
            }
        }
        return exito;
    }
    
    public static boolean opcionesModificacionCliente(Cliente porModificar){
        //Presenta y realiza las opciones disponibles para modificar los datos de un cliente
        //tablaCliente es donde guardamos todos los clientes
        //porModificar es el cliente que debemos modificar
        boolean exito;
        int opcion;
        exito = false;
        opcion = 1;
        while (opcion < 5){
            System.out.println("1. Modificar numero de telefono");
            System.out.println("2. Modificar domicilio");
            System.out.println("3. Modificar nombre y apellido");
            System.out.println("4. Modificar la fecha de nacimiento");
            System.out.println("5. Salir");
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                case 1:
                    //Pedimos el dato y lo colocamos en el objeto
                    System.out.println("Ingrese el nuevo numero de telefono");
                    porModificar.setNroTelefono(TecladoIn.readLine());
                    exito = true;
                    break;
                case 2: 
                    //Pedimos el dato y lo colocamos en el objeto
                    System.out.println("Ingrese el nuevo domicilio");
                    porModificar.setDomicilio(TecladoIn.readLine());
                    exito = true;
                    break;
                case 3:
                    //Pedimos el dato y lo colocamos en el objeto
                    System.out.println("Ingrese el nuevo nombre y apellido");
                    porModificar.setNombreApellido(TecladoIn.readLine());
                    exito = true;
                    break;
                case 4:
                    //Pedimos el dato y lo colocamos en el objeto
                    System.out.println("Ingrese la nueva fecha de nacimiento. Formato año-mes-dia. EJ: 2020-05-21");
                    porModificar.setFechaNacimiento(TecladoIn.readLine());
                    exito = true;
                    break;
            }
        }
        return exito;
    }
    
    public static String obtenerContactoCliente(Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados){
        //Busca un cliente y muestra sus datos de contacto y los pasajes comprados que esten pendientes de volar
        //tablaClientes es donde guardamos todos los clientes
        //pasajesComprados es donde cada cliente esta asociado a los pasajes que ha comprado
        String datosContacto, tipoDni;
        int nroDni;
        //Inicializamos el String que devolveremos en caso de que el cliente dado no exista
        datosContacto = "No existen los datos pedidos";
        //Solicitamos los datos para formar la clave del cliente
        System.out.println("Ingrese el tipo de dni del cliente");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni del cliente");
        nroDni = TecladoIn.readLineInt();
        //Usando esta clave buscamos el cliente
        Cliente buscado;
        buscado = (Cliente) tablaClientes.obtenerInformacion(new ClavePersona(tipoDni, nroDni));
        //obtenerInformacion() devuelve null si el cliente no existe, por lo tanto chequeamos antes de continuar que este no sea el caso
        if (buscado != null){
            //Como debemos mostrar los datos de contacto del cliente los colocamos en un String
            datosContacto = "Nombre y apellido: " + buscado.getNombreApellido() + "\n" + "Domicilio: " + buscado.getDomicilio() + "\n" + "Telefono: " + buscado.getNroTelefono();
            //Como el cliente existe lo buscamos ahora en el hashMap para obtener su historial de compras
            Lista historialCompras;
            historialCompras = pasajesComprados.get(buscado.getClave());
            //Ahora debemos buscar en el historial de compras los pasajes pendientes de volar
            //Para esto usamos el mensaje obtenerPasajesPendientes()
            datosContacto = datosContacto + "\n" + "Historial de Compras: " + obtenerPasajesPendientes(historialCompras);
        }
        return datosContacto;
    }    
    
    public static String obtenerPasajesPendientes(Lista historialCompras){
        //Recibe una lista con pasajes y debe buscar los que tengan estado "pendiente". Los devuelv como String para mostrarlos por pantalla
        //Precondicion: historialCompras debe contener objetos de tipo Pasaje
        //historialCompras es la lista cuyos pasajes debemos ver
        int i, tamanio;
        boolean alMenosUno;
        String pasajes;
        Pasaje pasajeARevisar;
        pasajes = "No hay pasajes pendientes de volar";
        i = 1;
        tamanio = historialCompras.longitud();
        //Usamos un while para pasar por todas las posiciones de la lista
        while (i <= tamanio){
            pasajeARevisar = (Pasaje) historialCompras.recuperar(i);
            //Vemos si el pasaje tiene estado "pendiente"
            if (pasajeARevisar.getEstado().equalsIgnoreCase("pendiente")){
                //Nos fijamos si hay al menos un pasaje ya cargado en el String o no
                alMenosUno = pasajes.equalsIgnoreCase("No hay pasajes pendientes de volar");
                if (alMenosUno){
                    //Antes de cargar el primer pasaje con estado pendiente quitamos el string previamente cargado en la variable
                    pasajes = "";
                }
                pasajes = pasajes + pasajeARevisar.toString() + "\n";
            }
            i++;
        }
        return pasajes;
    }
    
    public static Lista obtenerPasajesVolados (Lista historialCompras){
        //Recibe una lista con pasajes y debe buscar los que tengan estado "volado"
        //Precondicion: historialCompras debe contener objetos de tipo Pasaje
        //historialCompras es la lista cuyos pasajes debemos ver
        Lista pasajesVolados;
        Pasaje pasajeARevisar;
        int i, tamanio;
        i = 1;
        tamanio = historialCompras.longitud();
        pasajesVolados = new Lista();
        //Usamos un while para recorrer la lista
        while (i <= tamanio){
            pasajeARevisar = (Pasaje) historialCompras.recuperar(i);
            //Vemos si el pasaje tiene estado "volado"
            if (pasajeARevisar.getEstado().equalsIgnoreCase("volado")){
                //Si es asi lo añadimos a la lista de resultado
                pasajesVolados.insertar(pasajeARevisar, pasajesVolados.longitud() + 1);
            }
            i++;
        }
        return pasajesVolados;
    } 
    
    public static Lista obtenerVuelosDePasajes(Lista pasajes, Diccionario tablaVuelos){
        //Recibe una lista de pasajes y nos devuelve todos los vuelos que se encuentran en los pasajes
        //Precondicion: pasajes contiene Objetos de tipo Pasaje
        //pasajes es la lista de pasajes cuyos vuelos debemos obtener
        Lista vuelos;
        Pasaje pasajeARevisar;
        Vuelo unVuelo;
        int i, tamanio;
        i = 1;
        tamanio = pasajes.longitud();
        vuelos = new Lista();
        //Usamos un while para recorrer la lista de pasajes
        while (i <= tamanio){
            //Recuperamos el pasaje de la lista
            pasajeARevisar = (Pasaje) pasajes.recuperar(i); 
            //Ahora debemos buscar el vuelo en la tabla de vuelos usando la clave que tiene el pasaje
            unVuelo = (Vuelo) tablaVuelos.obtenerInformacion(pasajeARevisar.getVuelo());
            //Un pasaje viejo podria contener un vuelo que ya no existe. Por lo tanto debemos chequear que obtenerInformacion() no devuelva un null
            if (unVuelo != null){
                vuelos.insertar(unVuelo, vuelos.longitud() + 1);
            }
            i++;
        }
        return vuelos;
    }
    
    public static Lista obtenerAeropuertosDeVuelos(GrafoEtiquetado mapa, Lista vuelos){
        //Recibe una lista de vuelos y nos devuelve los aeropuertos de origen y destino de esos vuelos
        //Precondicion: vuelos es una lista con Objetos de tipo vuelo
        //mapa es el mapa de aeropuertos
        //vuelos es una lista con los vuelos cuyos aeropuertos debemos conseguir
        int i, tamanio;
        String origen, destino;
        Lista aeropuertos;
        Aeropuerto aeropuertoOrigen, aeropuertoDestino;
        Vuelo vueloARevisar;
        i = 1;
        tamanio = vuelos.longitud();
        aeropuertos = new Lista();
        //Usamos un while para recorrer la lista de vuelos
        while (i <= tamanio){
            //Recuperamos el vuelo de la lista
            vueloARevisar = (Vuelo) vuelos.recuperar(i);
            //Obtenemos las claves de los aeropuertos de origen y destino
            origen = vueloARevisar.getOrigen();
            destino = vueloARevisar.getDestino();
            aeropuertoOrigen = new Aeropuerto(origen);
            aeropuertoDestino = new Aeropuerto(destino);
            //Usamos las claves para buscar los aeropuertos en el mapa y añadirlos a la lista de aeropuertos
            if (aeropuertos.localizar(aeropuertoOrigen) == -1){
                aeropuertos.insertar(mapa.obtenerElemento(aeropuertoOrigen), aeropuertos.longitud() + 1);
            }
            if (aeropuertos.localizar(aeropuertoDestino) == -1){
                aeropuertos.insertar(mapa.obtenerElemento(aeropuertoDestino), aeropuertos.longitud() + 1);
            }
            i++;
        }
        return aeropuertos;
    }
    
    public static String obtenerCiudadesDeAeropuertos(Lista aeropuertos){
        //Recibe una lista de aeropuertos y nos devuelve la ciudad de cada uno en un String porque es para mostrar por pantalla
        //Precondicion: aeropuertos es una lista con Objetos de tipo Aeropuerto
        //aeropuertos es la lista de aeropuertos cuyas ciudades debemos obtener
        int i, tamanio;
        Aeropuerto unAeropuerto;
        String ciudades;
        ciudades = "";
        i = 1;
        tamanio = aeropuertos.longitud();
        //Usamos un while para recorrer la estructura
        while (i <= tamanio){
            //Recuperamos un aeropuerto de la lista
            unAeropuerto = (Aeropuerto) aeropuertos.recuperar(i);
            //Añadimos su ciudad a nuestro string de resultado
            ciudades = ciudades + ", " + unAeropuerto.getCiudad();
            i++;
        }
        return ciudades;
    }
    
    public static String obtenerCiudadesVisitadas(GrafoEtiquetado mapa, Diccionario tablaVuelos, HashMap <ClavePersona, Lista> pasajesComprados){
        //Revisa el historial de compras de un cliente para ver por que ciudades ha pasado
        //mapa es el mapa de aeropuertos
        //tablaVuelos es donde se guardan todos los vuelos
        //pasajesComprados es donde cada cliente esta asociado a los pasajes que compro
        String tipoDni, ciudadesVisitadas;
        int nroDni;
        ciudadesVisitadas = "Ninguna";
        //Solicitamos los datos para formar la clave del cliente
        System.out.println("Ingrese el tipo de dni");
        tipoDni = TecladoIn.readLine();
        System.out.println("Ingrese el numero de dni");
        nroDni = TecladoIn.readLineInt();
        //Usamos los datos para buscar el historial de compras del cliente
        Lista historialCompras, pasajesVolados, vuelosTomados, aeropuertosOrigenDestino;
        historialCompras = pasajesComprados.get(new ClavePersona(tipoDni, nroDni));
        //Antes de continuar nos fijamos que la lista no sea nula y que no este vacia
        if (historialCompras != null && !historialCompras.esVacia()){
            //Debemos revisar el historial de compras buscando los pasajes que tengan estado "volado"
            pasajesVolados = obtenerPasajesVolados(historialCompras);
            //Ahora debemos obtener los vuelos en esos pasajes
            vuelosTomados = obtenerVuelosDePasajes(pasajesVolados,tablaVuelos);
            //Ahora debemos obtener los aeropuertos de origen y destino de estos vuelos
            aeropuertosOrigenDestino = obtenerAeropuertosDeVuelos(mapa, vuelosTomados);
            //Finalmente obtenemos las ciudades donde estan los aeropuertos
            ciudadesVisitadas = obtenerCiudadesDeAeropuertos(aeropuertosOrigenDestino);
        }
        else{
            System.out.println("El cliente no existe o no tiene compras");
        }
        return ciudadesVisitadas;
    }
    
    public static Viaje obtenerViajeEnFecha(Lista viajes, String fechaBuscada){
        //Recibe una lista de viajes realizados por un vuelo y devuelve el viaje realizado en determinada fecha
        //Precondicion: viajes debe ser una lista con objetos de tipo Viaje
        //viajes es la lista de viajes que debemos revisar
        //fechaBuscada es la fecha que usamos para encontrar el viaje deseado
        Viaje buscado, viajeARevisar;
        int i, tamanio;
        boolean continuar;
        i = 1;
        continuar = true;
        buscado = null;
        tamanio = viajes.longitud();
        //Usamos un while para recorrer la lista de viajes
        while (i <= tamanio && continuar){
            //Recuperamos un viaje
            viajeARevisar = (Viaje) viajes.recuperar(i);
            //Revisamos si tiene la fecha que buscamos
            if (viajeARevisar.getFecha().equals(fechaBuscada)){
                //Si tiene esa fecha lo guardamos para retornar y terminamos el while
                buscado = viajeARevisar;
                continuar = false;
            }
            i++;
        }
        return buscado;
    }
    
    public static String obtenerVueloEnFecha(Diccionario tablaVuelos){
        //Busca un vuelo y el viaje particular realizado en determinada fecha y muestra su informacion
        String viaje, codigoVuelo;
        viaje = "No se pudo obtener el viaje";
        //Solicitamos el codigo del vuelo
        System.out.println("Ingrese el codigo del vuelo");
        codigoVuelo = TecladoIn.readLine();
        //Chequeamos que el codigo sea valido
        if (codigoVuelo.length() == 6){
            Vuelo vueloBuscado;
            //Buscamos el vuelo para poder obtener su lista de viajes
            vueloBuscado = (Vuelo) tablaVuelos.obtenerInformacion(codigoVuelo);
            //Chequeamos que el vuelo no sea null antes de continuar
            if (vueloBuscado != null){
                String fechaViaje;
                Viaje viajeBuscado;
                //Como el codigo es valido pedimos el ingreso de la fecha
                System.out.println("Ingrese la fecha del viaje realizado que realizo ese vuelo. Formato año-mes-dia. EJ: 2020-02-12");
                fechaViaje = TecladoIn.readLine();
                //Ahora debemos revisar la lista de viajes realizados por este vuelo para encontrar el que fue realizado en esa fecha
                viajeBuscado = obtenerViajeEnFecha(vueloBuscado.getViajes(), fechaViaje);
                //Chequeamos que el viaje no sea null
                if (viajeBuscado != null){
                    viaje = "Informacion del vuelo: " + vueloBuscado.toString() + "\n" + "Informacion del viaje particular: " + viajeBuscado.toString();
                }
            }
        }
        return viaje;
    }
    
    public static String obtenerRangoCodigos(Diccionario tablaVuelos){
        //Obtiene todos los codigos de vuelo que estan en el rango entre dos codigos y los devuelve en un String para mostrar por pantalla
        //tablaVuelos es donde estan guardados todos los vuelos
        String primerCodigo, segundoCodigo, vuelosEnRango;
        vuelosEnRango = "Codigos invalidos";
        System.out.println("Ingrese el primer codigo de vuelo");
        primerCodigo = TecladoIn.readLine();
        //Chequeamos que sea valido
        if (primerCodigo.length() == 6){
            System.out.println("Ingrese el segundo codigo");
            segundoCodigo = TecladoIn.readLine();
            //Chequeamos que sea valido
            if (segundoCodigo.length() == 6){
                //Vemos cual de los dos codigos es el mayor y cual el menor
                if(primerCodigo.compareTo(segundoCodigo) < 0){
                    //El primer codigo es menor que el segundo
                    vuelosEnRango = tablaVuelos.listarRango(primerCodigo, segundoCodigo).toString();
                }
                else{
                    if (primerCodigo.compareTo(segundoCodigo) > 0){
                        //El primer codigo es mayor al segundo
                        vuelosEnRango = tablaVuelos.listarRango(segundoCodigo, primerCodigo).toString();
                    }
                    else{
                        vuelosEnRango = "Los codigos son iguales";
                    }
                }
            }
        }
        return vuelosEnRango;
    }
    
    public static Lista verificarRuta(GrafoEtiquetado mapa){
        //Verifica si es posible llegar de un Aeropuerto a otro en x cantidad de vuelos
        boolean exito;
        int cant;
        Lista ruta;
        String origen, destino;
        System.out.println("Ingrese el nombre del aeropuerto de origen");
        origen = TecladoIn.readLine();
        System.out.println("Ingrese el nombre del aeropuerto de destino");
        destino = TecladoIn.readLine();
        System.out.println("Ingrese la cantidad de vuelos maximos");
        cant = TecladoIn.readLineInt();
        ruta = mapa.caminoMasCorto(new Aeropuerto(origen), new Aeropuerto(destino));
        if (ruta.longitud() > cant + 1){
            System.out.println("No es posible llegar en la cantidad de vuelos pedida");
        }
        else{
            System.out.println("Es posible hacerlo");
        }
        return ruta;
    }
    
    public static Lista rutaMasRapida(GrafoEtiquetado mapa){
        //Encuentra la ruta mas rapida entre 2 aeropuertos dados
        //mapa es el mapa de aeropuertos
        Lista ruta;
        String origen, destino;
        System.out.println("Ingrese el aeropuerto de origen");
        origen = TecladoIn.readLine();
        System.out.println("Ingrese el aeropuerto de destino");
        destino = TecladoIn.readLine();
        ruta = mapa.caminoMasRapido(new Aeropuerto(origen), new Aeropuerto(destino));
        return ruta;
    }
    public static void cargarAeropuerto(GrafoEtiquetado mapa, String linea){
        //Carga un aeropuerto a partir de un String
        StringTokenizer separadorElementos;
        Aeropuerto nuevo;
        String nombre, ciudad, telefono;
        //Borramos A: del string para continuar
        linea = linea.substring(2);
        separadorElementos = new StringTokenizer(linea,",");
        //Primero cargamos el nombre del aeropuerto
        nombre = separadorElementos.nextToken();
        //Segundo la ciudad
        ciudad = separadorElementos.nextToken();
        //Tercero el telefono
        telefono = separadorElementos.nextToken();
        //Cargamos el aeropuerto al mapa si no esta ya ahi
        nuevo = new Aeropuerto(nombre, ciudad, telefono);
        if (!mapa.existeVertice(nuevo)){
            mapa.insertarVertice(nuevo);
        }
    }
    
    public static void cargarViajes(Lista viajes, String linea){
        //Carga una lista de viajes a un vuelo a part de un String
        String fecha;
        int asientosTotales, asientosVendidos;
        Viaje nuevo;
        StringTokenizer separadorElementos;
        //Quitamos T: de la linea
        linea = linea.substring(2);
        separadorElementos = new StringTokenizer(linea, ",");
        //Cargamos los datos del viaje
        fecha = separadorElementos.nextToken();
        asientosTotales = Integer.parseInt(separadorElementos.nextToken());
        asientosVendidos = Integer.parseInt(separadorElementos.nextToken());
        nuevo = new Viaje(fecha, asientosTotales, asientosVendidos);
        //Insertamos el viaje en la lista si no esta ya ahi
        if (viajes.localizar(nuevo) == -1){
            viajes.insertar(nuevo, viajes.longitud() + 1);
        }
    }
    
    public static void cargarVuelo(GrafoEtiquetado mapa, Diccionario tablaVuelos, String linea, Lista viajes){
        //Carga un vuelo a a partir de un String
        StringTokenizer separadorElementos;
        String origen, destino, codigo;
        int salida, llegada;
        Vuelo nuevo;
        linea = linea.substring(2);
        separadorElementos = new StringTokenizer(linea, ",");
        //Cargamos codigo del vuelo
        codigo = separadorElementos.nextToken();
        //Cargamos el origen
        origen = separadorElementos.nextToken();
        //Cargamos el destino
        destino = separadorElementos.nextToken();
        //Cargamos hora salida
        salida = Integer.parseInt(separadorElementos.nextToken());
        //Cargamos hora llegada
        llegada = Integer.parseInt(separadorElementos.nextToken());
        nuevo = new Vuelo(codigo,origen,destino,salida,llegada);
        nuevo.setViajes(viajes.clone());
        //Insertamos el vuelo en la tabla de vuelos, y si se hace exitosamente insertamos el arco que lo representa en el mapa de aeropuertos
        if(tablaVuelos.insertar(codigo, nuevo)){
            //Insertamos el arco que representa al vuelo si no existe ya
            mapa.insertarArco(new Aeropuerto(origen), new Aeropuerto(destino), llegada - salida);
        }
    }
    
    public static void cargarPasajes(String linea, Lista comprados){
        //Carga un pasaje a una lista partir de un String
        int nroAsiento;
        String fecha;
        String vuelo, estado;
        Pasaje nuevo;
        StringTokenizer separadorElementos;
        linea = linea.substring(2);
        separadorElementos = new StringTokenizer(linea,",");
        //Cargamos los datos del pasaje
        nroAsiento = Integer.parseInt(separadorElementos.nextToken());
        vuelo = separadorElementos.nextToken();
        fecha = separadorElementos.nextToken();
        estado = separadorElementos.nextToken();
        //Creamos el pasaje
        nuevo = new Pasaje(nroAsiento, vuelo, fecha, estado);
        //Lo cargamos a la lista, si no esta ya ahi
        if (comprados.localizar(nuevo) == -1){
            comprados.insertar(nuevo, comprados.longitud() + 1);
        }
    }
    
    public static void cargarCliente(Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados, String linea, Lista comprados){
        //Carga un cliente a partir de un String
        String tipoDni, telefono, domicilio, nombreApellido, fechaNacimiento;
        ClavePersona clave;
        int nroDni;
        Cliente nuevo;
        //Cargamos los datos del cliente
        StringTokenizer separadorElementos;
        linea = linea.substring(2);
        separadorElementos = new StringTokenizer(linea,",");
        tipoDni = separadorElementos.nextToken();
        nroDni = Integer.parseInt(separadorElementos.nextToken());
        telefono = separadorElementos.nextToken();
        domicilio = separadorElementos.nextToken();
        nombreApellido = separadorElementos.nextToken();
        fechaNacimiento = separadorElementos.nextToken();
        clave = new ClavePersona(tipoDni, nroDni);
        //Creamos el cliente con los datos 
        nuevo = new Cliente(clave, telefono, domicilio, nombreApellido, fechaNacimiento);
        //Añadimos el cliente a la tabla de clientes y si se hizo exitosamente lo añadimos al hashMap
        if (tablaClientes.insertar(clave, nuevo)){
            //Añadimos el mapeo cliente-lista al hashMap
            pasajesComprados.put(clave, comprados.clone());
        }
    }
    
    public static void cargarDatos(GrafoEtiquetado mapa, Diccionario tablaVuelos, Diccionario tablaClientes, HashMap <ClavePersona, Lista> pasajesComprados) throws FileNotFoundException, IOException{
        //Carga datos a partir de un archivo de texto
        //Precondicion: el archivo debe tener un formato predefinido
        FileReader f;
        Lista viajes, pasajes;
        BufferedReader b;
        String rutaArchivo;
        rutaArchivo =  System.getProperty("user.dir") + "\\src\\Precarga.txt";
        f = new FileReader(rutaArchivo);
        b = new BufferedReader(f);
        viajes = new Lista();
        pasajes = new Lista();
        String linea; 
        while ((linea = b.readLine()) != null){
            switch (linea.charAt(0)){
                case 'A':
                    cargarAeropuerto(mapa, linea);
                    break;
                case 'T':
                    //Acumulamos los viajes en una lista hasta leer el proximo vuelo que esta luego de todos sus viajes
                    cargarViajes(viajes, linea);
                    break;
                case 'V':
                    //Usamos la lista que cargamos con viajes para cargar el vuelo y luego la vaciamos
                    cargarVuelo(mapa, tablaVuelos, linea, viajes);
                    viajes.vaciar();
                    break;    
                case 'C':
                    cargarCliente(tablaClientes, pasajesComprados, linea, pasajes);
                    pasajes.vaciar();
                    break;
                case 'P':
                    //Acumulamos los pasajes en una lista hasta leer el proximo cliente, que esta luego de todos sus pasajes comprados
                    cargarPasajes(linea, pasajes);
                    break;
            }
        }
        b.close();
        f.close();
        //Una vez cargado todo mostramos las estructuras en el log
        aniadirALog(mapa.toString() + "\n\n" + tablaVuelos.toString() + "\n\n" + tablaClientes.toString() + "\n\n");
        pasajesComprados.forEach((ClavePersona k, Lista v) -> {
            aniadirALog(k.toString() + v.toString() + "\n");
        });
    }
    
    public static void aniadirALog(String contenido){     
        //Crea un archivo LOG y escribe en el
        //contenido es el String que se escribira en el archivo LOG
        try {
            String ruta = new File("").getAbsolutePath() + "\\src\\LOG.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            contenido = "\n" + contenido;
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
