/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoFinal;

import lineales.dinamicas.Lista;
/**
 *
 * @author Leo
 */
public class Vuelo {
    private String codigo;
    private String origen;
    private String destino;
    private int horaSalida;
    private int horaLlegada;
    private Lista viajes;

    public Vuelo(String codigo, String origen, String destino, int horaSalida, int horaLlegada) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.viajes = new Lista();
    }

    public Lista getViajes() {
        return viajes;
    }

    public void setViajes(Lista viajes) {
        this.viajes = viajes;
    }

    
    public void addViaje(Viaje unViaje) {
        this.viajes.insertar(unViaje, this.viajes.longitud() + 1);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(int horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "codigo=" + codigo + ", origen=" + origen + ", destino=" + destino + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + 
                  ", lista de viajes: " + viajes.toString() + '}';
    }
    
}
