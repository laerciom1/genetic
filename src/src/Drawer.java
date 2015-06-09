/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Iterator;
import processing.core.PApplet;
/**
 *
 * @author CH1CO
 */
public class Drawer extends PApplet{
    public void setup() {  // setup() runs once
        background(0);
        size(800, 600);
        fill(255);
        for(EDArvoreDendograma ed:EDArvoreDendograma.getArrayED()){
            if(ed.isLine == true){
                println("Line:");
                line(ed.getLinha().getEX(), ed.getLinha().getEY(), ed.getLinha().getDX(), ed.getLinha().getDY());
                System.out.println(ed.getLinha().getEX() + " " + ed.getLinha().getEY() + " " + ed.getLinha().getDX() + " " + ed.getLinha().getDY());
                line(ed.getLinha().getEX(), ed.getLinha().getEY(), ed.getLinha().getEX(), ed.getLinha().getEy());
                System.out.println(ed.getLinha().getEX() + " " + ed.getLinha().getEY() + " " + ed.getLinha().getEX() + " " + ed.getLinha().getEy());
                line(ed.getLinha().getDX(), ed.getLinha().getDY(), ed.getLinha().getDX(), ed.getLinha().getDy());
                System.out.println(ed.getLinha().getDX() + " " + ed.getLinha().getDY() + " " + ed.getLinha().getDX() + " " + ed.getLinha().getDy());
            }
            else{
                println("Quadrado");
                rect(ed.getQuadrado().getX(), ed.getQuadrado().getY(), ed.getQuadrado().getTamanho(), ed.getQuadrado().getTamanho());
                println(ed.getQuadrado().getX()+ " " +  ed.getQuadrado().getY()+ " " + ed.getQuadrado().getTamanho()+ " " +  ed.getQuadrado().getTamanho());
            }
        }
        
        stroke(255);
    }
 
    public void draw() {  // draw() loops forever, until stopped
        
        
    }
}