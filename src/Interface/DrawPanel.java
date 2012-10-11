
package Interface;

import Modelos.Aresta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import Modelos.Vertice;
import java.util.ArrayList;

     

public class DrawPanel extends JPanel{
    private ArrayList<Vertice> vertices;
    
     public DrawPanel(ArrayList<Vertice> vertices){       
        //setTitle("Mapa");
        setSize(800,400);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        //setLocationRelativeTo(null);
        this.vertices = vertices;    
    }    
     
     private int retornaPosicaoXdoVerticeDestino(Aresta aresta){
         for (Vertice vertice : vertices) {
             if(vertice.getNome().equals(aresta.getDestino().getNome())){
                 return vertice.getPosicaoX();
             }
         }
         return 0;
     }
     
     private int retornaPosicaoYdoVerticeDestino(Aresta aresta){
         for (Vertice vertice : vertices) {
             if(vertice.getNome().equals(aresta.getDestino().getNome())){
                 return vertice.getPosicaoY();
             }
         }
         return 0;
     }
    
     public void paint(Graphics g){  
         int contador = 0;
         int incremento = 10;
         
         for (Vertice vertice : vertices) {  
            g.setColor(Color.blue);            
            g.setPaintMode();
            //g.fillOval(vertice.getPosicaoX()-30, vertice.getPosicaoY()-30, 60, 60);
            g.drawOval(vertice.getPosicaoX()-30, vertice.getPosicaoY()-30, 60, 60);
            g.setColor(Color.black); 
            g.drawString(vertice.getNome(), vertice.getPosicaoX()-30, vertice.getPosicaoY()-30);
            contador ++;
            for (Aresta aresta : vertice.getArestas()) {
                 g.setColor(Color.red);

                 g.drawLine(vertice.getPosicaoX(), 
                            vertice.getPosicaoY(), 
                            retornaPosicaoXdoVerticeDestino(aresta), 
                            retornaPosicaoYdoVerticeDestino(aresta));
                 g.setColor(Color.BLACK);
                 
                 if((contador%2)==0){
                     incremento = 20;
                 }
                 else{
                     incremento = 0;
                 }
                 
                 g.drawString(String.valueOf(aresta.getPeso()), ((vertice.getPosicaoX() + retornaPosicaoXdoVerticeDestino(aresta))/2)+incremento, 
                                                ((vertice.getPosicaoY() + retornaPosicaoYdoVerticeDestino(aresta))/2)+incremento );
                 
            }                     
        }
        
    }
}
