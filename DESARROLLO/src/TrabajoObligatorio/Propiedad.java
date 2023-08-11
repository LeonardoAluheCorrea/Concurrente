/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoObligatorio;

/**
 *
 * @author Leo
 */
public class Propiedad {
    private int codigo;
    private char tipo;
    private String direccion;
    private int cantAmbientes;
    private char operacion;
    private int superficie;
    private boolean disponibilidad;
    private int precio;
    
    
    
    public Propiedad (int codigo, char tipo, String direccion, int cantAmbientes, char operacion, int superficie, boolean disponibilidad, int precio){
        this.codigo = codigo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.operacion = operacion;
        this.superficie = superficie;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }
    
    
    public Propiedad (int codigo){
        this.codigo = codigo;
        tipo = 'n';
        direccion = null;
        cantAmbientes = 0;
        operacion = 'n';
        superficie = 0;
        disponibilidad = false;
        precio = 0;
    }
    
    public void setTipo(char tipo){
        this.tipo = tipo;
    }
    public void setDireccion (String dir){
        direccion = dir;
    }
    public void setCantAmbientes(int cAmb){
        cantAmbientes = cAmb;
    }
    public void setOperacion (char op){
        operacion = op;
    }
    public void setSuperficie (int sup){
        superficie = sup;
    }
    public void setDisponibilidad(boolean disp){
        disponibilidad = disp;
    }
    public void setPrecio (int pr){
        precio = pr;
    }
    
    
    public int getCodigo(){
        return codigo;
    }
    public char getTipo(){
        return tipo;
    }
    public char getOperacion (){
        return operacion;
    }
    public int getCantAmbientes (){
        return cantAmbientes;
    }
    public int getSuperficie(){
        return superficie;
    }
    public String getDireccion(){
        return direccion;
    }
    public boolean getDisponibilidad(){
        return disponibilidad;
    }
    public int getPrecio (){
        return precio;
    }
    
    
    public String toString(){
        return "codigo= "+codigo+" tipo="+tipo+" direccion="+direccion+" Cantidad de ambientes="+cantAmbientes+
                " Operacion="+operacion+" Superficie="+superficie+" Disponibilidad="+disponibilidad+" Precio="+precio;
    }
    public boolean equals(Propiedad p){
        return codigo == p.getCodigo();
    }
    
}
