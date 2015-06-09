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

public class EDGene {
    ArrayList<Double> list = new ArrayList<Double>();
    String name = new String();
    
    public ArrayList<Double> getList(){
        return list;
    }
    
    public void add(double f){
        list.add(f);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public double getCromo(int id){
        return list.get(id);
    }
    
    public String print(){//Método que retorna as expressividades do gene em cada individuo em forma de texto
        String resultado = new String();
        resultado += this.name;
        resultado += ":\t";
        for(Double f:list){
            resultado += Double.valueOf(String.format(Locale.US, "%.2f", f)).toString();
            resultado += "\t";
        }
        resultado += "\n";
        return resultado;
    }

    //Converter arraylist em vetor de double para poder usar no método da biblioteca Apache Commons Math
    public double[] toVector(){
        double[] resultado = new double[list.size()];
        for(int i = 0; i < list.size(); i++){
            resultado[i] = list.get(i);
        }
        return resultado;
    }
}