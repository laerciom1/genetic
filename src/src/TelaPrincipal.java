/* Tela principal do sistema,
 * onde serão exibidas todas
 *  as opçoes para o usuário.
*/
package src;

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

public final class TelaPrincipal extends JFrame implements OnAssinaturaResponseListener{ 
    JLabel genetic = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menuAbrir = new JMenu("Abrir");  
    JMenu menuRodar = new JMenu ("Rodar");
    JMenu menuExibir = new JMenu ("Exibir");
    JMenu menuDefinir = new JMenu ("Definir");
    JMenuItem menuAmostras = new JMenuItem("Amostras");  
    JMenuItem menuGAmostras = new JMenuItem("Grupo de Amostras"); 
    JMenuItem menuTamanho = new JMenuItem("Tamanho da Assinatura");
    JMenuItem menuPValor = new JMenuItem("P-Valor"); 
    JMenuItem menuAgrupamento = new JMenuItem("Agrupamento"); 
    JMenuItem menuValidacao = new JMenuItem("Validação Cruzada"); 
    JMenuItem menuEListaGenes = new JMenuItem("Lista de Genes");
    JMenuItem menuEAssinatura = new JMenuItem("Assinatura genica");
    JMenuItem menuEDendograma = new JMenuItem("Dendograma");
    
    EDAmostra amostra;
    int tamanho;
    SeletorArquivo SA;
    TelaDTamanhoAssinatura t;
    
    public TelaPrincipal(){
        super();  
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(800, 600));
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Genetic");
        this.setLocationRelativeTo(null);  
        
        initTelaPrincipal();
        menuAmostras.addActionListener((ActionEvent e) -> { 
            SA = new SeletorArquivo();
            this.t = new TelaDTamanhoAssinatura();
            this.t.setResponseListener(this); 
        });
        menuGAmostras.addActionListener( (ActionEvent e) -> { } );
        menuTamanho.addActionListener( (ActionEvent e) -> {
        this.t = new TelaDTamanhoAssinatura();
        this.t.setResponseListener(this); 
        } );
        menuGAmostras.addActionListener( (ActionEvent e) -> { } );
        menuAgrupamento.addActionListener( (ActionEvent e) -> { } );
        menuValidacao.addActionListener( (ActionEvent e) -> { } );
        menuEListaGenes.addActionListener( (ActionEvent e) -> { new TelaEListaGenes(amostra); } );
        menuEAssinatura.addActionListener( (ActionEvent e) -> { new TelaEAssinatura(amostra); } );
        menuEDendograma.addActionListener( (ActionEvent e) -> { } ); 
        this.setVisible(true);
    }
    
    public void initTelaPrincipal() {
         this.setJMenuBar(menuBar);  
         this.add(genetic);
         genetic.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("img/genetic.jpg")));
         genetic.setBounds(0, -50, 800, 600);
         menuAbrir.add(menuAmostras);
         menuAbrir.add(menuGAmostras);
         menuDefinir.add(menuTamanho);
         menuDefinir.add(menuPValor);
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


