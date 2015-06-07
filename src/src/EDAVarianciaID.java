/*
 * Estrutura de dados auxiliar para guardar a variancia e o ID do gene,
 * que corresponde ao indice no ArrayList de genes da amostra.
 */
package src;

public class EDAVarianciaID {
    private double variancia;
    private int id;
    
    public EDAVarianciaID(){
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
