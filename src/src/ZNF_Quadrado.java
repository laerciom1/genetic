/*
 * Classe que guarda os atributos necessários para desenhar um quadrado no
 * PApplet (Drawer).
 */
package src;

public class ZNF_Quadrado {
    private float X, Y, tamanho;
    
    public ZNF_Quadrado(float x, float y, float tamanho){
        this.X = x;
        this.Y = y;
        this.tamanho = tamanho;
    }

    public float getX() {
        return X;
    }

    public void setX(float X) {
        this.X = X;
    }

    public float getY() {
        return Y;
    }

    public void setY(float Y) {
        this.Y = Y;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
