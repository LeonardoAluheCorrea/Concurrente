/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabajoPractico05;

/**
 *
 * @author Leo
 */
public class Especia {
    private int growthRate;
    private String name;

     public static void main (String[]args){
         Especia i = new Especia(4, "fish");
     }
    public Especia(int growthRate, String name) {
        this.growthRate = growthRate;
        this.name = name;
    }

    public int getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(int growthRate) {
        this.growthRate = growthRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
