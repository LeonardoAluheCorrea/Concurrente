/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTP5;

/**
 *
 * @author Leo
 */
public class Racional {
    private int numerador;
    private int denominador;
    
    public Racional (int n, int d){
        numerador = n;
        denominador = d;
    }
    public Racional (){
        numerador = 1;
        denominador = 1;
    }
    
    public int getNumerador(){
        return numerador;
    }
    public int getDenominador(){
        return denominador;
    }
    
    public double pasarADouble(){
        return numerador/denominador;
    }
    public String toString(){
        return "numerador = "+numerador+
                "denominador = "+denominador;
    }
    public boolean equals (Racional r){
        return r.pasarADouble() == numerador/denominador;
    }
    
    public void setNumerador(int n){
        numerador = n;
    }
    public void setDenominador(int d){
        denominador = d;
    }
    
    public Racional sumar(Racional r){
        Racional resultado;
        resultado = new Racional();
        resultado.setNumerador(numerador*r.getDenominador()+r.getNumerador()*denominador);
        resultado.setDenominador(denominador*r.getDenominador());
        return resultado;
    }    
    public Racional restar(Racional r){
        Racional resultado;
        resultado = new Racional();
        resultado.setNumerador(numerador*r.getDenominador()-r.getNumerador()*denominador);
        resultado.setDenominador(denominador*r.getDenominador());
        return resultado;
    }
    public Racional multiplicar (Racional r){
        Racional resultado;
        resultado = new Racional();
        resultado.numerador = numerador*r.numerador;
        resultado.denominador = denominador*r.denominador;
        return resultado;
    }
    public Racional dividir(Racional r){
        Racional res;
        res = new Racional();
        if (r.pasarADouble() > 0.0){
            res.setDenominador(denominador*r.getNumerador());
            res.setNumerador(numerador*r.getDenominador());
        }
        else{
            System.out.println("La fraccion es menor a 0, por lo tanto no se realizara la division");
        }
        return res;
    }
      
}
