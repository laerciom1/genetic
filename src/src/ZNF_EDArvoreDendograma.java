/*
 * ED que representaria um nó na arvore. Cada nó seria linha ou quadrado, sempre
 * setando apenas os atribus da linha ou do quadrado (respsctivamente), dependendo
 * do que ele estivesse representando na estrutura final
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author CH1CO
 */
public class ZNF_EDArvoreDendograma {
    private ZNF_EDArvoreDendograma pai;
    private ZNF_EDArvoreDendograma filho1, filho2;
    
    //Array que guardaria todos os nós, que seria usado na impressão
    private static ArrayList<ZNF_EDArvoreDendograma> arrayED = new ArrayList<>(); 
    //Array para guardar quais individuos já foram inseridos. Desta forma, caso
    //o individuo fosse inserido novamente, haveria um tratamento pois sabe-se que
    //ali existiria uma ligação (objeto linha contendo linha e não quadrado)
    private static ArrayList<Integer> arrayID = new ArrayList<>();
    
            /* As variaveis arrayED e arrayID são estáticas pois
             * para qualquer instancia de um objeto ZNF_EDArvoreDendograma
             * é desejado que essa instancia conheça os nós que já estão
             * na arvore e o id dos individuos que ja foram adicionados
             * facilitando assim a manipulação dos dados;
             */
    
    private String txt; //Imprimir o id do individuo
    private ZNF_Linha linha; /* Estrutura que guardaria as informações da linha
                              * para que ela fosse impressa porteriormente
                              */
    private ZNF_Quadrado quadrado; /* Estrutura que guardaria as informações 
                                    * do quadrado para que ele fosse impresso
                                    * porteriormente
                                    */
    public boolean isLine; //Flag para identificar uma linha
    
    public ZNF_EDArvoreDendograma(ZNF_EDArvoreDendograma filho1,
            ZNF_EDArvoreDendograma filho2,
            float altura){ //Construtor para caso o objeto tivesse que ser uma linha
        this.txt = null;
        this.isLine = true;
        this.filho1 = filho1;
        this.filho2 = filho2;
        this.quadrado = new ZNF_Quadrado(0,0,0);
        if(filho1.getIsLine() == true &&
            filho2.getIsLine() == true){ //Caso os dois filhos fossem ligações (linhas)
            this.linha = new ZNF_Linha(filho1.getLinha().getDY()+altura, //EY
                                   filho1.getLinha().getEY(), //Ey
                                   filho1.getLinha().getEX()+((filho1.getLinha().getDX()-filho1.getLinha().getEX())/2), //EX
                                   filho2.getLinha().getDY()+altura,//DY
                                   filho2.getLinha().getDY(),//Dy
                                   filho2.getLinha().getDX()-((filho2.getLinha().getDX()-filho2.getLinha().getEX())/2));//DX
        }
        
        if(filho1.getIsLine() == true &&
            filho2.getIsLine() == false){ //Caso apenas o filho da esquerda fosse ligação (linha)
            this.linha = new ZNF_Linha(filho1.getLinha().getDY()+altura,
                                   filho1.getLinha().getEY(),
                                   filho1.getLinha().getEX()+((filho1.getLinha().getDX()-filho1.getLinha().getEX())/2),
                                   filho2.getQuadrado().getY()+altura,
                                   filho2.getQuadrado().getY(),
                                   filho2.getQuadrado().getX()+((filho2.getQuadrado().getTamanho())/2));
        }
        
        if(filho1.getIsLine() == false &&
            filho2.getIsLine() == true){ //Caro apenas o filho da direita fosse ligação (linha)
            this.linha = new ZNF_Linha(filho1.getQuadrado().getY()+altura,
                                   filho1.getQuadrado().getY(),
                                   filho1.getQuadrado().getX()+((filho1.getQuadrado().getTamanho())/2),
                                   filho2.getLinha().getDY()+altura,
                                   filho2.getLinha().getEY(),
                                   filho2.getLinha().getEX()+((filho2.getLinha().getDX()-filho2.getLinha().getEX())/2));
        }
        
        if(filho1.getIsLine() == false &&
            filho2.getIsLine() == false){ //Caso os dois filhos fossem individuos (quadrados)
            this.linha = new ZNF_Linha(filho1.getQuadrado().getY()+altura,
                                   filho1.getQuadrado().getY(),
                                   filho1.getQuadrado().getX()+((filho1.getQuadrado().getTamanho())/2),
                                   filho2.getQuadrado().getY(),
                                   filho2.getQuadrado().getY()+altura,
                                   filho2.getQuadrado().getX()+((filho2.getQuadrado().getTamanho())/2));
        }
        arrayED.add(this); //Adiciona no array de nós para impressão;
    }
    
    public ZNF_EDArvoreDendograma(int id, int x){ //Construtor para caso o objeto tivesse que ser um quadrado;
        this.isLine = false;
        this.quadrado = new ZNF_Quadrado(((x*20)+((x-1)*50)), 20, 50);
        this.linha = new ZNF_Linha(0,0,0,0,0,0);
        this.txt = Integer.toString(id);
        arrayED.add(this);//Adiciona no array de nós para impressão;
        arrayID.add(id);//Adiciona id o individuo para saber que ele já foi inserido
    }
    
    public final ZNF_EDArvoreDendograma getPai(int id) { /* Método getPai() para
                                                          * achar o representante
                                                          * do nó passando o ID
                                                          */
        for(ZNF_EDArvoreDendograma ed : arrayED){
            if(ed.txt.equals(Integer.toString(id))){
                while(ed.getPai() != null){
                    ed = ed.getPai();
                }
                return ed;
            }
        }
        return null;
    }
    
    public ZNF_EDArvoreDendograma getPai(){ /* Diferente do outro getPai(), esse
                                             * retornaria o pai do nó, e não seu
                                             * representante
                                             */
        return this.pai;
    }
    
    public static ArrayList<ZNF_EDArvoreDendograma> getArrayED(){
        return arrayED;
    }
    
    public static ArrayList<Integer> getArrayID(){
        return arrayID;
    }

    public final ZNF_Linha getLinha() {
        return linha;
    }

    public ZNF_Quadrado getQuadrado() {
        return quadrado;
    }

    public String getTxt() {
        return txt;
    }

    private boolean getIsLine() {
        return this.isLine;
    }
}
