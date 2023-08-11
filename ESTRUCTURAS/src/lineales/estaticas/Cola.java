/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Leo
 */
public class Cola {
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;
    private Object[] array;
    
    public Cola (){
        frente = 1;
        fin = 1;
        array = new Object[TAMANIO]; 
    }
    public boolean poner (Object nuevoElemento){
        boolean exito;
        if (frente == fin + 1)
            //La cola esta llena
            exito = false;
        else{
            array[fin] = nuevoElemento;
            fin = (fin + 1) % TAMANIO;
            exito = true;
        }        
        return exito;
    }
    public boolean sacar (){
        boolean exito;
        if (frente == fin)
            exito = false;
        else{
            array[frente] = null;
            frente = (frente + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }
    public Object obtenerFrente (){
        Object res;
        if (frente == fin)
            res =  null;
        else
            res = array[frente];
        return res;
    }
    public boolean esVacia (){
        return frente == fin;
    }
    public void vaciar (){
        boolean continuar;
        int i;
        i = frente;
        continuar = true;
        if (frente != fin){
            while (continuar){
                array[i] = null;
                i = (i + 1) % TAMANIO;
                continuar = i != fin;
            }
            fin = frente;
        }
    }
    public Cola clone (){
        Cola copia;
        copia = new Cola();
        if (frente != fin){
            boolean continuar;
            int i;
            copia.frente = this.frente;
            copia.fin = this.fin;
            i = frente;
            continuar = true;
            while (continuar){
                copia.array[i] = this.array[i];
                i = (i + 1) % TAMANIO;
                continuar = i != fin;
            }
        }
        return copia;
    }
    public String toString (){
        String result;
        boolean continuar;
        result = "";
        if (frente == fin)
            result = "Cola vacia";
        else{
            int i = frente;
            continuar = true;
            while (continuar){
                result = result + array[i] + ",";
                i = (i + 1) % TAMANIO;
                continuar = i != fin;
            }
        }
        return result;
    }
}
