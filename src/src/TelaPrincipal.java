/* Tela principal do sistema,
 * onde serão exibidas todas
 *  as opçoes para o usuário.
*/
package src;

import src.Drawer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import processing.core.PApplet;
import src.EDAmostra;
import src.EDMatrizDistancia;
import src.OnAssinaturaResponseListener;
import src.SeletorArquivo;
import src.TelaDTamanhoAssinatura;
import src.TelaEAssinatura;
import src.TelaEListaGenes;

public final class TelaPrincipal extends JFrame implements OnAssinaturaResponseListener{ 
    //Atributos do layout
    JLabel genetic = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menuAbrir = new JMenu("Abrir");  
    JMenu menuRodar = new JMenu ("Rodar");
    JMenu menuExibir = new JMenu ("Exibir");
    JMenu menuDefinir = new JMenu ("Definir");
    JMenuItem menuAmostras = new JMenuItem("Amostras");   
    JMenuItem menuTamanho = new JMenuItem("Tamanho da Assinatura");
    JMenuItem menuAgrupamento = new JMenuItem("Agrupamento"); 
    JMenuItem menuValidacao = new JMenuItem("Validação Cruzada"); 
    JMenuItem menuEListaGenes = new JMenuItem("Lista de Genes");
    JMenuItem menuEAssinatura = new JMenuItem("Assinatura genica");
    JMenuItem menuEDendograma = new JMenuItem("Dendograma");
    
    //ED principal que armazenará os dados lidos do arquivo
    EDAmostra amostra;
    
    //FileChooser para selecionar o arquivo através da interface gráfica
    SeletorArquivo SA;
    
    //Janela para escolher o tamanho da assinatura e o campo para guardar essa especificação
    TelaDTamanhoAssinatura t;
    int tamanho;
    
    public TelaPrincipal(){
        //Setando atributos da UI
        super("Genetic"); 
        initTelaPrincipal();
        
        //Configurando botões da UI
        menuAmostras.addActionListener((ActionEvent e) -> { //Abrir arquivo de amostras
            SA = new SeletorArquivo();
            this.t = new TelaDTamanhoAssinatura();
            this.t.setResponseListener(this); 
        });
        
        menuTamanho.addActionListener( (ActionEvent e) -> { //Redefinir tamanho da assinatura
            this.t = new TelaDTamanhoAssinatura();
            this.t.setResponseListener(this); 
        } );
        
        menuAgrupamento.addActionListener( (ActionEvent e) -> { //Rodar o algoritmo de agrupamento
        
        } );
        
        menuValidacao.addActionListener( (ActionEvent e) -> { //Rodar o algoritmo de valicação
        
        } );
        
        menuEListaGenes.addActionListener( (ActionEvent e) -> { //Exibir tela com os genes lidos
            new TelaEListaGenes(amostra);
        } );
        
        menuEAssinatura.addActionListener( (ActionEvent e) -> { //Exibir tela com a assinatura gerada
            new TelaEAssinatura(amostra); 
            EDMatrizDistancia md = new EDMatrizDistancia(amostra);
            md.initMatriz();
            md.printMatriz();
            //md.gerarDendograma();
        } );
        
        menuEDendograma.addActionListener( (ActionEvent e) -> { //Exibir tela com o dendograma gerado
            Drawer.main("src.Drawer");
        } ); 
        
        //Exibindo a janela
        this.setVisible(true);
    }
    
    public void initTelaPrincipal() {
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(800, 600));
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        this.setJMenuBar(menuBar);  
        this.add(genetic);
        genetic.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("img/genetic.jpg")));
        genetic.setBounds(0, -50, 800, 600);
        menuAbrir.add(menuAmostras);
        menuDefinir.add(menuTamanho);
        menuRodar.add(menuAgrupamento);
        menuRodar.add(menuValidacao);
        menuExibir.add(menuEListaGenes);
        menuExibir.add(menuEAssinatura);
        menuExibir.add(menuEDendograma); 
        menuBar.add(menuAbrir);  
        menuBar.add(menuDefinir);
        menuBar.add(menuRodar);
        menuBar.add(menuExibir);     
    }
    
    public static void main(String[] args){
        new TelaPrincipal();
    }

    @Override
    public void onResponse(int tamanhoDeAssinatura) {
        try { amostra = SA.lerAmostras(tamanhoDeAssinatura); } catch (IOException ex) {Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);}
    }
}