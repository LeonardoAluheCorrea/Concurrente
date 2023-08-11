/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal.Objetos;

import java.util.Objects;

/**
 *
 * @author Leo
 */
public class ClavePersona implements Comparable {
    private String tipoDni;
    private int numeroDni;

    public ClavePersona(String tipoDni, int numeroDni) {
        this.tipoDni = tipoDni;
        this.numeroDni = numeroDni;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public int getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(int numeroDni) {
        this.numeroDni = numeroDni;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tipoDni);
        hash = 23 * hash + this.numeroDni;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClavePersona other = (ClavePersona) obj;
        if (this.numeroDni != other.numeroDni) {
            return false;
        }
        if (!Objects.equals(this.tipoDni, other.tipoDni)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        int res;
        ClavePersona otro;
        otro = (ClavePersona)o;
        if (this.tipoDni.compareTo(otro.tipoDni) < 0){
            res = -1;
        }
        else{
            if (this.tipoDni.compareTo(otro.tipoDni) > 0){
                res = 1;
            }
            else{
                if (this.numeroDni < otro.numeroDni){
                    res = -1;
                }
                else{
                    if (this.numeroDni > otro.numeroDni){
                        res = 1;
                    }
                    else{
                        res = 0;
                    }
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "ClavePersona{" + "tipoDni=" + tipoDni + ", numeroDni=" + numeroDni + '}';
    }    
}
