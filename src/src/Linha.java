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
public class Linha {
    private float EY, Ey, EX;
    private float DY, Dy, DX;

    public Linha(float EY, float Ey, float EX, float DY, float Dy, float DX) {
        this.EY = EY;
        this.Ey = Ey;
        this.EX = EX;
        this.DY = DY;
        this.Dy = Dy;
        this.DX = DX;
    }
    
    public float getEY() {
        return EY;
    }

    public void setEY(float EY) {
        this.EY = EY;
    }

    public float getEy() {
        return Ey;
    }

    public void setEy(float Ey) {
        this.Ey = Ey;
    }

    public float getEX() {
        return EX;
    }

    public void setEX(float EX) {
        this.EX = EX;
    }

    public float getDY() {
        return DY;
    }

    public void setDY(float DY) {
        this.DY = DY;
    }

    public float getDy() {
        return Dy;
    }

    public void setDy(float Dy) {
        this.Dy = Dy;
    }

    public float getDX() {
        return DX;
    }

    public void setDX(float DX) {
        this.DX = DX;
    }
}

    