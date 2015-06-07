/*
 * Tela de definição do tamanho da assinatura;
 */
package src;

import java.awt.event.ActionEvent;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaDTamanhoAssinatura extends JFrame{
    JButton OK = new JButton("OK");
    JLabel txt1 = new JLabel("Digite o tamanho");
    JLabel txt2 = new JLabel("da assinatura:");
    JTextField tamanho = new JTextField();
    int tam;
    private OnAssinaturaResponseListener responseListener;
    
    
    public TelaDTamanhoAssinatura(){
        super();
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(216, 168));
        this.setSize(216, 168);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initTelaDTamanhoAssinatura();
    }
    
    public void initTelaDTamanhoAssinatura(){
        Scanner sc;
        OK.setBounds(62, 95, 76, 25);
        this.add(OK);
        tamanho.setBounds(35, 60, 130, 25); 
        tamanho.setHorizontalAlignment(tamanho.CENTER);
        this.add(tamanho);
        txt1.setBounds(30, 10, 130, 15);
        txt1.setHorizontalAlignment(txt1.CENTER);
        this.add(txt1);
        txt2.setBounds(30, 30, 130, 15);
        txt2.setHorizontalAlignment(txt2.CENTER);
        this.add(txt2);
        OK.addActionListener( (ActionEvent e) -> {
            if(responseListener != null){
                tam = Integer.parseInt(tamanho.getText().trim());
                    responseListener.onResponse(tam);
            }
            this.dispose();//
        } );
        this.setVisible(true);
    }
    
    public OnAssinaturaResponseListener getResponseListener(){
        return responseListener;
    }
    public void setResponseListener(OnAssinaturaResponseListener responseListener){
        this.responseListener = responseListener;
    }
}
