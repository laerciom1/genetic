/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author CH1CO
 */
public class EDArvoreDendograma {
    private EDArvoreDendograma pai;
    private EDArvoreDendograma filho1, filho2;
    
    private static ArrayList<EDArvoreDendograma> arrayED = new ArrayList<>();
    private static ArrayList<Integer> arrayID = new ArrayList<>();
    
    private String txt;;
    private Linha linha;
    private Quadrado quadrado;
    public boolean isLine;
    
    public EDArvoreDendograma(EDArvoreDendograma filho1, EDArvoreDendograma filho2, float altura){
        
        this.txt = null;
        this.isLine = true;
        this.filho1 = filho1;
        this.filho2 = filho2;
        this.quadrado = new Quadrado(0,0,0);
        if(filho1.getIsLine() == true && filho2.getIsLine() == true){
            this.linha = new Linha(filho1.getLinha().getDY()+altura, //EY
                                   filho1.getLinha().getEY(), //Ey
                                   filho1.getLinha().getEX()+((filho1.getLinha().getDX()-filho1.getLinha().getEX())/2), //EX
                                   filho2.getLinha().getDY()+altura,//DY
                                   filho2.getLinha().getDY(),//Dy
                                   filho2.getLinha().getDX()-((filho2.getLinha().getDX()-filho2.getLinha().getEX())/2));//DX
        }
        
        if(filho1.getIsLine() == true && filho2.getIsLine() == false){
            this.linha = new Linha(filho1.getLinha().getDY()+altura,
                                   filho1.getLinha().getEY(),
                                   filho1.getLinha().getEX()+((filho1.getLinha().getDX()-filho1.getLinha().getEX())/2),
                                   filho2.getQuadrado().getY()+altura,
                                   filho2.getQuadrado().getY(),
                                   filho2.getQuadrado().getX()+((filho2.getQuadrado().getTamanho())/2));
        }
        
        if(filho1.getIsLine() == false && filho2.getIsLine() == true){
            this.linha = new Linha(filho1.getQuadrado().getY()+altura,
                                   filho1.getQuadrado().getY(),
                                   filho1.getQuadrado().getX()+((filho1.getQuadrado().getTamanho())/2),
                                   filho2.getLinha().getDY()+altura,
                                   filho2.getLinha().getEY(),
                                   filho2.getLinha().getEX()+((filho2.getLinha().getDX()-filho2.getLinha().getEX())/2));
        }
        
        if(filho1.getIsLine() == false && filho2.getIsLine() == false){
            this.linha = new Linha(filho1.getQuadrado().getY()+altura,
                                   filho1.getQuadrado().getY(),
                                   filho1.getQuadrado().getX()+((filho1.getQuadrado().getTamanho())/2),
                                   filho2.getQuadrado().getY(),
                                   filho2.getQuadrado().getY()+altura,
                                   filho2.getQuadrado().getX()+((filho2.getQuadrado().getTamanho())/2));
        }
        arrayED.add(this);
    }
    
    public EDArvoreDendograma(int id, int x){
        this.isLine = false;
        this.quadrado = new Quadrado(((x*20)+((x-1)*50)), 20, 50);
        this.linha = new Linha(0,0,0,0,0,0);
        this.txt = Integer.toString(id);
        arrayED.add(this);
        arrayID.add(id);
    }
    
    public final EDArvoreDendograma getPai(int id) {
        for(EDArvoreDendograma ed : arrayED){
            if(ed.txt.equals(Integer.toString(id))){
                while(ed.getPai() != null){
                    ed = ed.getPai();
                }
                return ed;
            }
        }
        System.out.print("NAO ACHOU!!");
        return null;
    }
    
    public EDArvoreDendograma getPai(){
        return this.pai;
    }
    
    public static ArrayList<EDArvoreDendograma> getArrayED(){
        return arrayED;
    }
    
    public static ArrayList<Integer> getArrayID(){
        return arrayID;
    }

    public final Linha getLinha() {
        return linha;
    }

    public Quadrado getQuadrado() {
        return quadrado;
    }

    public String getTxt() {
        return txt;
    }

    private boolean getIsLine() {
        return this.isLine;
    }
}
