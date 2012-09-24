
package drawpanel;

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
    
     public void paint(Graphics g){
        
         for (Vertice vertice : vertices) {
  
        g.setColor(Color.BLACK);
        g.drawOval(vertice.getPosicaoX(), vertice.getPosicaoY(), 30, 30);
             for (Aresta aresta : vertice.getArestas()) {
                 g.setColor(Color.red);
                 g.drawLine(vertice.getPosicaoX(), vertice.getPosicaoY(), 140, 140);
             }
             
        
        }
        
    }
     
     
        
    public static void main(String[] args) throws Exception {
         
        LerXml ler = new LerXml("A:/mapa2.xml");
        DrawPanel dp = new DrawPanel(ler.lerMapa());
        
        
    }
}
