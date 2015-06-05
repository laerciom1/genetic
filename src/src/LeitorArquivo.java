/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import processing.core.PApplet;

/**
 *
 * @author CH1CO
 */
public class LeitorArquivo {
    private BufferedReader breader;
    private FileReader freader;
    
    public LeitorArquivo(File file) throws FileNotFoundException{
        freader = new FileReader(file);
        breader = new BufferedReader(freader);
    }
    
    public void ler() throws IOException{
        Amostra amostra = new Amostra();
        String data;
        
        while((data = breader.readLine()) != null){
            Gene g = new Gene();
            String[] resultado = data.split("\t");
            for(int i = 1; i < resultado.length; i++){
                float f = Float.parseFloat(resultado[i]);
                g.add(f);
            }
            amostra.add(g);
        }
        
        /* Comandos para testes
        amostra.printAll();
        System.out.println("\n\n");
        amostra.getGene(8).print();
        System.out.println("\n\n");
        amostra.getGene(8).getCromo(4);*/
    }
}