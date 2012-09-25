
package Interface;

import Modelos.Aresta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import Modelos.Vertice;
import Servicos.LerXml;
import java.util.ArrayList;

     

public class DrawPanel extends JFrame{
    ArrayList<Vertice> vertices;
    
     public DrawPanel(ArrayList<Vertice> vertices){       
        setTitle("Mapa");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        this.vertices = vertices;    
    }    
     
     private int retornaPosicaoXdoVerticeDestino(Aresta aresta){
         for (Vertice vertice : vertices) {
             if(vertice.getNome().equals(aresta.getDestino())){
                 return vertice.getPosicaoX();
             }
         }
         return 0;
     }
     
     private int retornaPosicaoYdoVerticeDestino(Aresta aresta){
         for (Vertice vertice : vertices) {
             if(vertice.getNome().equals(aresta.getDestino())){
                 return vertice.getPosicaoY();
             }
         }
         return 0;
     }
    
     public void paint(Graphics g){        
         for (Vertice vertice : vertices) {  
            g.setColor(Color.BLACK);
            g.drawOval(vertice.getPosicaoX()-30, vertice.getPosicaoY()-30, 60, 60);
            for (Aresta aresta : vertice.getArestas()) {
                 g.setColor(Color.red);
                 g.drawLine(vertice.getPosicaoX(), 
                            vertice.getPosicaoY(), 
                            retornaPosicaoXdoVerticeDestino(aresta), 
                            retornaPosicaoYdoVerticeDestino(aresta));
            }
             
        
        }
        
    }
     
     
        
    public static void main(String[] args) throws Exception {
         
        LerXml ler = new LerXml("/home/vitor/Downloads/mapa.xml");
        DrawPanel dp = new DrawPanel(ler.lerMapa());
        
        
    }
}
