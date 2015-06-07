/*
 * Classe entidade para representar um gene.
 * É armazenado primeiramente o nome, e em seguinda a expressividade
 * do gene em cada individuo, onde o cada indice do arraylist será
 * a expressividade do gene em um individuo específico
 */
package src;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

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
        return cromo.get(id);
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
    
    //Converter arraylist em vetor de double para poder usar no método da biblioteca Apache Commons Math
    public double[] toVector(){
        double[] resultado = new double[cromo.size()];
        for(int i = 0; i < cromo.size(); i++){
            resultado[i] = cromo.get(i);
        }
        return resultado;
    }
}