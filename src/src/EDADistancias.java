/*
 * Estrutura de dados auxiliar para armazenar as distancias entre
 * os individuos. A medida que as distancias são adicionadas,
 * é feita a reordenação para que sempre fique em ordem crescente.
 */
package src;

import java.util.Locale;
public class EDADistancias {
    //Indexes dos individuos 1 e 2
    private int id1,id2;
    //Distancia Euclidiana entre os individuos 1 e 2
    private double distancia;
    
    public EDADistancias(int id1, int id2, double distancia){
        this.id1 = id1;
        this.id2 = id2;
        this.distancia = distancia;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public double getDistancia() {
        return distancia;
    }
    
    public String print(){
        String resultado = new String();
        resultado += "Distancia entre ";
        resultado += id1;
        resultado += " e ";
        resultado += id2;
        resultado += ": ";
        resultado += Double.valueOf(String.format(Locale.US, "%.2f", distancia)).toString();
        resultado += "\n";
        return resultado;
    }
}