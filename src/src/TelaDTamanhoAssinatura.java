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
    //Atributos do layout
    JButton OK = new JButton("OK");
    JLabel txt1 = new JLabel("Digite o tamanho");
    JLabel txt2 = new JLabel("da assinatura:");
    JTextField tamanho = new JTextField();
    //Variavel que guarda o tamanho digitado
    int tam;
    /* Listener deste objeto.
     * No caso é usado o padrão Observer para que a tela principal execute a primeira leitura
     * dos dados apenas quando for definido o tamanho da assinatura desejada.
     * Isso é necessário pois a assinatura é gerada enquanto se lê o arquivo.
     * Nas classes das EDs Assinatura e e no SeletorArquivo isso pode ser visto melhor.
     */
    private OnAssinaturaResponseListener responseListener;
    
    
    public TelaDTamanhoAssinatura(){
        //Setando atributos da UI
        super("Tamanho da assinatura");
        initTelaDTamanhoAssinatura();
        //Configuração do botão OK
        OK.addActionListener( (ActionEvent e) -> {
            if(responseListener != null){
                tam = Integer.parseInt(tamanho.getText().trim());
                    responseListener.onResponse(tam); //Chama o método lerArquivo (em TelaPrincipal>SeletorArquivo) passando o parametro lido
            }
            this.dispose();//
        } );
        this.setVisible(true);
    }
    
    public void initTelaDTamanhoAssinatura(){
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(216, 168));
        this.setSize(216, 168);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
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
    }
    
    public void setResponseListener(OnAssinaturaResponseListener responseListener){
        this.responseListener = responseListener;
    }
}
