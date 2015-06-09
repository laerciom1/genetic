/*
 * Estrutura de dados auxiliar para armazenar as distancias entre
 * os individuos. A medida que as distancias são adicionadas,
 * é feita a reordenação para que sempre fique em ordem crescente.
 */
package src;

/**
 *
 * @author CH1CO
 */
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
    
    public float getDistanciaFloat() {
        return (float)distancia;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public void print(){
        System.out.println("Distancia entre " + id1 + " e " + id2 + ": " + distancia);
    }
}