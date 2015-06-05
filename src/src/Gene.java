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
public class Gene {
    ArrayList<Float> cromo = new ArrayList<Float>();
    
    public float getCromo(int id){
        return cromo.get(id-1);
    }
    
    public void print(){
        for(Float f:cromo){
            System.out.print(""+f.toString()+" ");
        }
        System.out.println("");
    }

    public void add(float f){
        cromo.add(f);
    }
}
