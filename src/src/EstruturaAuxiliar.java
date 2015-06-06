/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author CH1CO
 */
public class EstruturaAuxiliar {
    private double variancia;
    private int id;
    
    public EstruturaAuxiliar(){
    }

    public double getVariancia() {
        return variancia;
    }

    public void setVariancia(double variancia) {
        this.variancia = variancia;
    }

    public int getId() {
        return id+1;
    }

    public void setId(int id) {
        this.id = id;
    }
}
