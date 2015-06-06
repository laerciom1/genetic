/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author CH1CO
 */
public class Gene {
    ArrayList<Double> cromo = new ArrayList<Double>();
    String name = new String();
    
    public ArrayList<Double> getList(){
        return cromo;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public double getCromo(int id){
        return cromo.get(id-1);
    }
    
    public String print(){
        String resultado = new String();
        resultado += this.name;
        resultado += ":\t";
        for(Double f:cromo){
            resultado += Double.valueOf(String.format(Locale.US, "%.2f", f)).toString();
            resultado += "\t";
        }
        resultado += "\n";
        return resultado;
    }

    public void add(double f){
        cromo.add(f);
    }
    
    public double[] toVector(){
        double[] resultado = new double[cromo.size()];
        for(int i = 0; i < cromo.size(); i++){
            resultado[i] = cromo.get(i);
        }
        return resultado;
    }
}
