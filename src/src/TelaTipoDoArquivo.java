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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
public class TelaTipoDoArquivo extends JDialog{
    private static TelaTipoDoArquivo tela;
    JButton btOK = new JButton("OK");
    JLabel txt1 = new JLabel("Formato não suportado.");
    JLabel txt2 = new JLabel("Selecione um arquivo *.txt");
    
    private TelaTipoDoArquivo(){
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(300, 150));
        this.setSize(300, 150);
        this.setResizable(true);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); 
        this.setTitle("Tipo de arquivo não suportado");
        this.setLocationRelativeTo(null); 
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        
        initTelaTipoDoArquivo();
        
        //CONFIGS BOTOES
        btOK.addActionListener( (ActionEvent e) -> {  this.dispose(); } );
    }
    
    private void initTelaTipoDoArquivo(){
        this.add(txt1);
        txt1.setBounds(75, 15, 150, 15);
        this.add(txt2);
        txt2.setBounds(68, 35, 150, 15);
        btOK.setBounds(100, 70, 100, 25);
        this.add(btOK); 
    }
    
    public static TelaTipoDoArquivo getInstance(){
        if(tela == null){
            tela = new TelaTipoDoArquivo();
        }
        return tela;
    }
}


