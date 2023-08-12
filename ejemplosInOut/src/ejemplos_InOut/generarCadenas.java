/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos_InOut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Leo
 */
public class generarCadenas {
/**
 * Este otro ejemplo esta para mostrar como generar 10000 valores enteros, menores
 * a 1,000,000 de forma aleatoria, y los guardar en un archivo, de a uno por linea.
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
 *
 * Otro enfoque es usar math.random() que les devuelve un double entre 0 y 1, y luego
 * "desnormalizar" los datos hacia el rango que les interese.
 * Ejemplo para generar doubles entre 5 y 10.
 * int techo = 10; int piso = 5;
 * double aleatorio = piso + (Math.random() * (techo - piso));
 *
 */
    static final int CANTCADENAS = 10;
    static final String NOMBRE_ARCHIVO = "src/ejemplos_InOut/cadenas.txt";

    private static void generarArchivo(){
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		Random generador = new Random();
                String cadena = "";
    		for (int i = 0; i < CANTCADENAS ; i++){
                    for (int j = 0; j < 10; j++){
    			char num = (char) generador.nextInt();
                        cadena = cadena + num;
                    }
                    buff.write(cadena +"\n");
                    System.out.println(cadena);
                    cadena = "";
    		}
    		buff.close();

    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static void main(String[] args) {
    	/** Como nos interesa medir la eficiencia de nuestros algoritmos, realizaremos mediciones
    	 * de eficiencia de los metodos que nos interese, partiendo del supuesto de que tenemos
    	 * datos cargados en memoria, para suprimir el sesgo que nos traeria la E/S (por más que
    	 * sea lineal, involucra operaciones muy lentas, y que varian muchisimo de un sistema a
    	 * otro.
    	 *
    	 * Podemos ver como varia el tiempo de ejecución nuestro de algoritmo en función del tamaño
    	 * de entrada.
    	 */
    	generarArchivo(); //Una vez que ya tenemos un archivo generado, no hace falta generar uno nuevo.
    }
}
