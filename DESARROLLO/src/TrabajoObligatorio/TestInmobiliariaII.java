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
public class TestInmobiliariaII {
    
    public static void buscarPrecio(Propiedad[]a, int n){
        int precio;
        if (verificarOrden(a, n-1)){
            System.out.println("Ingrese el precio a buscar");
            precio = TecladoIn.readLineInt();
            if (busquedaBinaria(a,0,n-1,precio))
                System.out.println("El precio corresponde a una de las propiedades cargadas");
            else
                System.out.println("EL precio no corresponde a ninguna de las propiedades cargadas");
        }
        else
            System.out.println("Como el arreglo no esta ordenado por precio no podemos utlizar la busqueda binaria");
    }
    
    public static boolean busquedaBinaria (Propiedad[]a, int pri, int ult, int valor){
        boolean rta;
        int medio;
            medio =(int) Math.floor((pri + ult)/2);
            if (pri > ult)
                rta = false;
            else{
                if (a[medio].getPrecio() == valor)
                    rta = true;
                else{
                    if (a[medio].getPrecio() < valor)
                        rta = busquedaBinaria(a,medio+1,ult,valor);
                    else
                        rta = busquedaBinaria(a,pri,medio-1,valor);
                }
            }                    
        return rta;
    }
   
    public static boolean verificarOrden(Propiedad[]a, int n){
        int i;
        boolean orden;
        i = 0;
        orden = true;
        while (orden && i < n){
            if (a[i].getPrecio() > a[i+1].getPrecio())
                orden = false;
            i++;
        }
        return orden;
    }
    
    public static int ultimaCarga(Propiedad[]a){
        //Busca en el arreglo la primera posicion donde no hay propiedad cargada
        //Devuelve -1 si en el arreglo no hay propiedades cargadas
        int n, pos, i;
        boolean found;
        found = false;
        n = a.length;
        pos = -1;
        i = 0;
        while (i < n && !found){
            if (a[i] == null){
                found = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }
    
    public static int particion(Propiedad[]a, int inicio, int fin){
        int pivote, i;
        Propiedad temp;
        pivote = a[fin].getSuperficie();
        i = inicio-1; 
        for (int j = inicio; j < fin; j++) {
            if (a[j].getSuperficie() <= pivote) {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[i+1];
        a[i+1] = a[fin];
        a[fin] = temp;
        return i+1;
    }
    
    public static void quickSort(Propiedad[]a, int inicio, int fin){
        int indice;
        if (inicio < fin){
            indice = particion (a,inicio,fin);        
            quickSort(a,inicio,indice-1);
            quickSort(a,indice+1,fin);
        }
    }
    
    
    public static void casaMayorSuperficie (Propiedad[]a, int n){        
        if(buscarCasaMayorSuperficie(a,0,n,null) == null)
            System.out.println("No existen casas disponibles para alquilar");
        else
            System.out.println("La casa disponible para alquilar con la mayor superficie es:"+buscarCasaMayorSuperficie(a,0,n,null).toString());
        Propiedad[2].codigo;
    }
    
    public static Propiedad buscarCasaMayorSuperficie(Propiedad[]a, int pos,int n, Propiedad mayorSup){
        Propiedad res;
        if (pos < n){
            if (a[pos].getDisponibilidad() && a[pos].getTipo() == 'c' && a[pos].getOperacion() == 'a'){
                if(mayorSup == null)
                    mayorSup = a[pos];
                if (a[pos].getSuperficie() > mayorSup.getSuperficie())
                    res = buscarCasaMayorSuperficie(a,pos+1,n,a[pos]);
                else
                    res = buscarCasaMayorSuperficie(a,pos+1,n,mayorSup);
            }
            else
                res = buscarCasaMayorSuperficie(a,pos+1,n,mayorSup);
        }
        else
            res = mayorSup;
        return res;
}
    
    public static int buscarAmbientes (Propiedad[]a, int n){
        int cant;
        System.out.println("Ingrese la cantidad de ambientes a buscar");
        cant = TecladoIn.readLineInt();
        return contarAmbientes(a,0,cant,n);
    }
    
    public static int contarAmbientes(Propiedad[]a, int pos, int cantAmbientes, int n){
        int res;
        res = 0;
        if (pos < n){
            if (a[pos].getCantAmbientes() == cantAmbientes)
                res = contarAmbientes(a,pos+1,cantAmbientes,n)+1;
            else
                res = contarAmbientes(a,pos+1,cantAmbientes,n);
        }
        return res;
    }
    
    public static void elegirOrdenamiento (Propiedad[]a, int n){
        int opcion;
        System.out.println("Ingrese el metodo de ordenamiento deseado");
        System.out.println("1: Insercion");
        System.out.println("2: Seleccion");
        System.out.println("3: Burbuja");
        opcion = TecladoIn.readLineInt();
        switch (opcion){
            case 1:
                insertionSort(a,n);
                break;
            case 2:
                selectionSort(a,n);
                break;
            case 3:
                bubleSort(a,n);
                break;
        }
    }
    
    public static void selectionSort(Propiedad[]a, int n){
        int min;
        Propiedad temp;
        for (int i = 0; i < n; i++){
            min = i;
            for (int j = i+1; j < n; j++){
                if (a[j].getPrecio() < a[min].getPrecio()){
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    
    public static void insertionSort(Propiedad[]a, int n){
        int j;
        Propiedad temp;
        for (int i = 1; i < n; i++){
            temp = a[i];
            j = i;
            while (j > 0 && temp.getPrecio() < a[j-1].getPrecio()){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }
    
    public static void bubleSort (Propiedad[]a, int n){
        int i, j;
        Propiedad temp;
        boolean ordenado;
        ordenado = false;
        i = 0;
        while (i < n-1 && !ordenado) {
            ordenado = true;
            for (j = 0; j < n-i-1; j++){
                if (a[j].getPrecio() > a[j+1].getPrecio()){
                    ordenado = false;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            i++;
        }
    }

    
    //A partir de aqui para arriba los modulos corresponden a la parte 3 del trabajo
    //Los modulos de abajo pertenecen a la parte 2 del trabajo 
    
     public static boolean verificarCasa(Propiedad p){
        return p.getDisponibilidad() && p.getTipo() == 'c' && p.getSuperficie() > 100
                && p.getOperacion() == 'v';
    }
    public static boolean verificarDepartamento (Propiedad p){
        return p.getTipo() == 'd' && p.getOperacion() == 'a' && p.getCantAmbientes() == 1 && p.getPrecio() < 20000;
    }
    
    public static void precarga(Propiedad[]p){
        //precarga 10 propiedades 
        p[0] = new Propiedad(0,'c',"Anaya",2,'a',65,true,20888);
        //Esta casa cumple las condicioens pedidas en la parte III
        p[1] = new Propiedad(1,'d',"Chocon 234",1,'a',59,true,19999);
        //Este departamento cumple las condiciones pedidas
        p[2] = new Propiedad(2,'c',"Elordi 24",3,'v',199,true,89787);
        //Esta casa cumple las condiciones pedidas
        p[3] = new Propiedad(3,'c',"Anaya 343",2,'v',123,false,334);
        p[4] = new Propiedad(4,'d',"Chocon 2278",1,'a',32,true,14569);
        //Este departamento cumple las condiciones pedidas
        p[5] = new Propiedad(5,'d',"Obrero Argentino 234",1,'a',59,true,19999);
        //Este departamento cumple con las condidiciones pedidas
        p[6] = new Propiedad(6,'c',"Olascoaga 242",3,'v',193,true,72334);
        //Esta casa cumple las condiciones pedidas
        p[7] = new Propiedad(7,'x',"Anaya",2,'t',62,false,3488);
        p[8] = new Propiedad(8,'c',"Richieri",2,'v',128,true,63888);
        //Esta casa cumple las condiciones pedidas
        p[9] = new Propiedad(9,'c',"Anaya",2,'a',146,true,22358);
        //Esta casa cumple las condiciones pedidas en la parte III
    }
    
    public static void listarCasas(Propiedad[] propiedad, int n){
        //Lista todas las casas que cumplen con las condiciones pedidas
        boolean v;
        v = true;
        for (int i = 0; i < n; i++){
                if(verificarCasa(propiedad[i])){
                    v = false;
                    System.out.println(propiedad[i].toString());
                }            
        }
        if(v)
            System.out.println("No hay propiedades que cumplan las condiciones pedidas");
    }
    
    public static void listarDepartamentos(Propiedad[] propiedad, int n){
        //Lista todos los departamentos que cumplen con las condiciones pedidas
        boolean v;
        v = true;
        for (int i = 0; i < n; i++){
                if (verificarDepartamento(propiedad[i])){
                    v = false;
                    System.out.println(propiedad[i].toString());
                }
        }
        if (v)
            System.out.println("No hay propiedades que cumplan las condiciones pedidas");
    }
    
    public static int menu(){
        System.out.println("1. Cargar propiedades");
        System.out.println("2. Listar todas las propiedades cargadas");
        System.out.println("3. Listar todas las casas disponibles para vender con superficie mayor a 100m");
        System.out.println("4. Listar todos los departamentos disponibles para alquilar, de 1 solo ambiente  y por menos de 20000");
        System.out.println("5. Ordenar las propiedades por precio, de menor a mayor");
        System.out.println("6. Ver cuantas propiedades tienen cierta cantidad de ambientes");
        System.out.println("7. Ver casa disponible para alquiler con mayor superficie");
        System.out.println("8. Ordenar las propiedades por superficie, de menor a mayor");
        System.out.println("9. Dado el precio de una propiedad, verificar si existe");
        System.out.println("10. Salir");
        return TecladoIn.readLineInt();
    }
    
    public static void listAll(Propiedad[] p, int n){
        //lista los datos de todos los objetos del arreglo
        int tamaño;
        for (int i = 0; i < n; i++){
            System.out.println(p[i].toString());
        }
    }
    
    
    public static void cargarDato(Propiedad prop){
        System.out.println("Ingrese la direccion");
        prop.setDireccion(TecladoIn.readLine());
        System.out.println("Ingrese true o false dependiendo si la propiedad esta disponible");
        prop.setDisponibilidad(TecladoIn.readLineBoolean());
        System.out.println("Ingrese el tipo de operacion a realizar con la propiedad. v: venta, a: alquiler, q: alquiler temporario");
        prop.setOperacion(TecladoIn.readNonwhiteChar());
        System.out.println("Ingrese el precio");
        prop.setPrecio(TecladoIn.readLineInt());
        System.out.println("Ingrese la superficie en metros cuadrados");
        prop.setSuperficie(TecladoIn.readLineInt());
        System.out.println("Ingrese la cantidad de ambientes");
        prop.setCantAmbientes(TecladoIn.readLineInt());
        System.out.println("Ingrese el tipo de propiedad. c: casa, d: departamento, x: duplex");
        prop.setTipo(TecladoIn.readNonwhiteChar());
    }

    
    public static boolean verificarCodigo(Propiedad[]p,int cod, int n){
        boolean igualCodigo;
        int j;
        j = 0;
        igualCodigo = false;
        while (j < n && !igualCodigo){
                if (p[j].getCodigo() == cod){
                    igualCodigo = true;
                    System.out.println("El codigo ingresado coincide con el de otra propiedad");
                }
                j++;
            }
        return igualCodigo;
    }
    
    
    public static int cargarArreglo (Propiedad[] propiedad, int start){
        int tamaño, i, cod;
        char continuar;
        tamaño = propiedad.length-1;
        i = start;
        continuar = 's';
        while(continuar == 's' && i < tamaño){
            System.out.println("Ingrese el codigo de la propiedad, este no debe coincidir con el de ninguna otra");
            cod = TecladoIn.readLineInt();            
            if (!verificarCodigo(propiedad, cod, start)){
                propiedad [i] = new Propiedad(cod);
                cargarDato(propiedad[i]);
                start++;
                i++;
            }
            System.out.println("Desea continuar ingresando propiedades?. s/n. Si el codigo que ingreso anteriormente era repetido entonces no se cargo ninguna propiedad");
            continuar = TecladoIn.readNonwhiteChar();
        }
        if (start == tamaño+1)
            System.out.println("Tiene almacenada la maxima cantidad de propiedades");
        return i;
    }
    
    public static void main (String[]args){
        Propiedad[] lista;
        int n, indice;
        indice = 10;
        lista = new Propiedad[60];
        precarga(lista);
        do{
            n = menu();
            switch(n){
                case 1:
                    indice = cargarArreglo(lista, indice);
                    break;
                case 2:
                    listAll(lista,indice);
                    break;
                case 3:
                    listarCasas(lista, indice);
                    break;
                case 4: 
                    listarDepartamentos(lista, indice);
                    break;
                case 5:
                    elegirOrdenamiento(lista, indice);
                    break;
                case 6:
                    System.out.println("La cantidad de propiedades es:"+buscarAmbientes(lista, indice));
                    break;
                case 7:
                    casaMayorSuperficie(lista, indice);
                    break;
                case 8: 
                    quickSort(lista,0,indice-1);
                    break;
                case 9:
                    buscarPrecio(lista, indice);
                    break;
            }
        }
        while(n != 10);
    }
            
}
