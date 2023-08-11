/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

/**
 *
 * @author Leo
 */
public class Ficha {
    private int nroMedico;
    private int nroReceta;
    private int importe;

    public Ficha(int nroMedico, int nroReceta, int importe) {
        this.nroMedico = nroMedico;
        this.nroReceta = nroReceta;
        this.importe = importe;
    }

    public int getNroMedico() {
        return nroMedico;
    }

    public void setNroMedico(int nroMedico) {
        this.nroMedico = nroMedico;
    }

    public int getNroReceta() {
        return nroReceta;
    }

    public void setNroReceta(int nroReceta) {
        this.nroReceta = nroReceta;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
    
}
