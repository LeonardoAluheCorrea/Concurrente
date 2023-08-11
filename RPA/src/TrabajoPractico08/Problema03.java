/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico08;
import Utiles.TecladoIn;
import Utiles.FormulasGeometricas;
import Utiles.CalculosGeometricos;
/**
 *
 * @author Leo
 */
public class Problema03 {
    public static void main(String[]args){
        //Este programa pide una figura y retorna al usuario como calcular su area y perimetro ademas de calcularlos
        double lado1,lado2,lado3,cateto1,cateto2,base,altura,radio,areaRec,periRec,areaCir,periCir,areaTri,periTri;
        int figura;
        System.out.println("Ingrese 1 para rectangulo, 2 para triangulo o 3 para circulo");
        figura=TecladoIn.readLineInt();
       
        switch(figura){
            case 1:
                //En caso de ser un rectangulo invocamos modulo que muestran las formulas correspondientes
                FormulasGeometricas.formulaPerimetroRectangulo();
                FormulasGeometricas.formulaAreaRectangulo();
                //Ahora realizamos el calculo del perimetro y el area del rectangulo con los datos que ingrese el usuario
                System.out.println("Ingrese la base y altura del rectangulo");
                base=TecladoIn.readLineDouble();
                altura=TecladoIn.readLineDouble();
                areaRec=CalculosGeometricos.areaRectangulo(altura, base);
                periRec=CalculosGeometricos.perimetroRectangulo(altura,base);
                System.out.println("El area del rectangulo es: "+areaRec+" y su perimetro es: "+periRec);
                break;
            case 2:
                //En caso de ser un circulo invocamos modulos que muestran las formulas correspondientes
                FormulasGeometricas.formulaAreaCirculo();
                FormulasGeometricas.formulaPerimetroCirculo();
                //Ahora realizamos el calculo del perimetro y el area del rectangulo con los datos que ingrese el usuario
                System.out.println("Ingrese el radio del circulo");
                radio=TecladoIn.readLineInt();
                areaCir=CalculosGeometricos.areaCirculo(radio);
                periCir=CalculosGeometricos.perimetroCirculo(radio);
                System.out.println("El area del circulo es: "+areaCir+" y el perimetro es: "+periCir);
                break;
            case 3: 
                //En caso de ser un triangulo invocamos modulo que muestran las formulas correspondientes
                FormulasGeometricas.formulaAreaTriangulo();
                FormulasGeometricas.formulaPerimetroTriangulo();
                //Ahora realizamos los calculos de area y perimetro con los datos que entregue el usuario
                System.out.println("Ingrese los 3 lados del triangulo");
                lado1=TecladoIn.readLineDouble();
                lado2=TecladoIn.readLineDouble();
                lado3=TecladoIn.readLineDouble();
                areaTri=CalculosGeometricos.areaTriangulo(lado1,lado2);
                periTri=CalculosGeometricos.perimetroTriangulo(lado1,lado2,lado3);
                System.out.println("El area del triangulo es: "+areaTri+" y el perimetro es: "+periTri);
                break;
            default:
                System.out.println("Reinicie y selecciones un figura por favor");
                break;
        }
    }
    
}
